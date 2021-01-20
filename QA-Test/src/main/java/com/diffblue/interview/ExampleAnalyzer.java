
package com.diffblue.interview;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Simple test implementation of a code analysis application
 */
class ExampleAnalyzer implements CodeAnalyzer {

    private final Set<CodeTest> testsPreviouslyRun = new LinkedHashSet<CodeTest>();

    /**
     * Main constructor for the example analyzer implementation
     * Does nothing
     */
    ExampleAnalyzer() {}

    /**
     * A shared method to analyse a given test
     * Adds the test to the set of previous run tests
     * and also adds all of the lines covered by the
     * test to the set of all covered code lines
     * @param test a code test, to be analyzed
     * @return a set of code lines covered by the test
     */
    private Set<CodeLine> runTestShared(final CodeTest test) {
        testsPreviouslyRun.add(test);
        return test.getCoveredLines();
    }

    /**
     * Analyze a test to check which code lines it covers
     * @param test (the test to be analyzed)
     * @return a set of code lines covered by this test
     */
    public Set<CodeLine> runTest(final CodeTest test) {
        return runTestShared(test);
    }

    /**
     * Analyse a set of tests to check which code lines they cover
     * @param tests (all tests to be analyzed)
     * @return a set of code lines which are covered by these tests
     */
    public Set<CodeLine> runTestSuite(final Set<CodeTest> tests) {
        final Set<CodeLine> allCoveredLines = new LinkedHashSet<CodeLine>();
        for (final CodeTest test : tests) {
            allCoveredLines.addAll(runTestShared(test));
        }
        return allCoveredLines;
    }

    /**
     * Get a set of tests that have been analysed
     * by this analyzer which cover code lines
     * that are covered by no other test
     * @return a set of code tests which cover code lines uniquely
     */
    public Set<CodeTest> uniqueTests() {
        final Set<CodeTest> unique = new LinkedHashSet<CodeTest>();
        final CodeTest[] tests = testsPreviouslyRun.toArray(new CodeTest[]{});
        // For each set, subtract all other sets
        for (int i = 0; i < tests.length; i++) {
            final List<Set<CodeLine>> testedLineSets = copyAllTestedCodeLines();
            final Set<CodeLine> testedCodeLines = testedLineSets.get(i);
            for (int j = 0; j < tests.length; j++) {
                if (i == j) {
                    // Don't difference self
                    continue;
                }
                testedCodeLines.removeAll(testedLineSets.get(j));
            }
            // If any code lines remain in testedCodeLines, then ith test covers something unique
            if (testedCodeLines.size() > 0) {
                unique.add(tests[i]);
            }
        }
        return unique;
    }

    /**
     * Get a copy of covered code line sets for all tests
     * @return copies of all sets of code lines covered by the tests
     */
    private List<Set<CodeLine>> copyAllTestedCodeLines() {
        final CodeTest[] tests = testsPreviouslyRun.toArray(new CodeTest[]{});
        // Provide the number of tests to avoid array resizing
        final List<Set<CodeLine>> testedLineSets = new ArrayList<Set<CodeLine>>(tests.length);
        // Make copies of each since they will be mutated by set operations later
        for (final CodeTest test : tests){
            final Set<CodeLine> nextLineSet = new LinkedHashSet<CodeLine>();
            nextLineSet.addAll(test.getCoveredLines());
            testedLineSets.add(nextLineSet);
        }
        return testedLineSets;
    }

}