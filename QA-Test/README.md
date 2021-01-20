Java Test Coverage Application QA Challenge
============

This project contains an interview question designed to assess your Java
testing ability.

Please note that we will look as much at readability, structure and documentation
as we will at accuracy and correctness. Show us how good you are!

This project contains some basic interfaces & implementations 
which represent Java source code and coverage of that source code by tests, and
a simple application to demonstrate how these classes might be used to analyze
a single source file.

- `CodeLine` represents a line of Java code in a file
- `CodeClass` represents a Java class or interface file
- `CodeAnalyzer` represents the coverage analysis engine
- `CodeTest` represents a Java test

Briefly, the goal of the application written using these classes will be 
to analyze a series of Java source files together with tests that cover 
those classes. This analysis will give the user insights such as which lines 
are covered by the tests, what is the minimal set of tests which can cover 
all possible lines, etc...

In this exercise no real analysis will be done. The analysis will return a 
random set of covered lines for a given Java source file.

Include your answers to the questions (aside from the code that you write)
or any other notes either as comments in the Java files that you create 
or as a separate document. Please make sure that this project can be compiled
using `mvn compile` and tested using `mvn test` on the reviewer's computers 
under any operating system.

Question 1
------
Consider the class `Example Line`. 
Which parts of this class would you test and which would you not test? Why?

Question 2
------
Write tests for the classes `ExampleClass` and `ExampleAnalyzer`.

For methods that you choose to test, write down which sets of inputs
you have chosen to test and explain why you have chosen those inputs.
Keep also in mind that in order to test `ExampleAnalyzer`, you will likely have
to interact with `ExampleTest`, which has a random component. Make sure that
your unit tests pass reliably in repeated executions.

Hint: Search `ExampleTest` and `pom.xml` for hints of two ways how the
randomness of `ExampleTest` could be handled in your unit tests.

Question 3
------
Consider the use case where the program is used to find all lines of code
covered in a Java source file by at least two different test files. Write 
an end-to-end test for this use case.

Note that you do not have to read in any test files, but you may use the
randomly generated test coverage that `ExampleTest` generates. Do ensure that
the randomly covered lines are consistent between invocations of the test
that you write.

Note also that we do not expect you to test the 'user interface' layer
(i.e. command line output), hence you may write tests that use 
only the classes other than `ExampleApplication`.

Question 4
------
Briefly describe how you would perform a manual test of the main application
included in this example (`ExampleApplication#main`). What inputs to the
application would you consider and what behaviour might you be looking for?
