
package com.diffblue.interview;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * A simple example of a test on a code class
 * which says that it covers a random set of lines
 * that is fixed on instantiation
 */
class ExampleTest implements CodeTest {

    private final String testName;
    private final Set<CodeLine> linesTested = new LinkedHashSet<CodeLine>();
    private int seed;

    /**
     * Main constructor for the example test implementation
     * @param testName the name of the test represented by this object
     */
    ExampleTest(final String testName)
    {

        this(testName, new Random().nextInt());
    }

    /**
     * Equivalent to {@link #ExampleTest(String), but uses a defined seed for
     * random test coverage generation.
     * 
     * @param testName the name of the test represented by this object
     * @param seed Seed to use when randomly deciding which lines are covered.
     */
    ExampleTest(final String testName, int seed) {
    	this.testName = testName;
    	this.seed = seed;
    }

    /**
     * Getter for the test name
     * @return the name of the test represented by this object
     */
    public String getName() {
        return testName;
    }

    /**
     * Getter for the code lines covered by the test
     * @return a set of code lines covered by this test
     */
    public Set<CodeLine> getCoveredLines() {
        return linesTested;
    }

    /**
     * Check which lines of code in the code class object
     * provided as an argument are covered by this test
     * Does nothing if the provided object is null
     * @param codeClass the class whose coverage by this test is to be checked
     */
    void testAgainst(final CodeClass codeClass) {
        if (codeClass == null) {
            return;
        }
        final Random randomNumberGenerator = new Random(seed);
        for (final CodeLine line : codeClass.getLinesOfCode()) {
            if (randomNumberGenerator.nextInt(2) == 0) {
                linesTested.add(line);
            }
        }
    }
}
