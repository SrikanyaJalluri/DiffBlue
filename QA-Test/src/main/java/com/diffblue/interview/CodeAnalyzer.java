
package com.diffblue.interview;

import java.util.Set;

/**
 * An interface representing code analysis functions
 */
public interface CodeAnalyzer {
    /**
     * Runs the given test and returns the covered lines of code
     * @param test to run
     * @return the covered lines of code
     */
    Set<CodeLine> runTest(CodeTest test);

    /**
     * Run all tests and returns the covered lines of code
     * @param tests to run
     * @return the covered lines of code
     */
    Set<CodeLine> runTestSuite(Set<CodeTest> tests);

    /**
     * Get a set of tests that have been analysed
     * by this analyzer which cover code lines
     * that are covered by no other test
     * @return a set of code tests which cover code lines uniquely
     */
    Set<CodeTest> uniqueTests();
}
