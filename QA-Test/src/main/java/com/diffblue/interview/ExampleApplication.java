package com.diffblue.interview;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class ExampleApplication {

  /**
   * Utility method to exit the application and print an error message
   *
   * @param errorMessage error message to print
   */
  private static void exitWithErrorMessage(final String errorMessage) {
    System.out.println(errorMessage);
    System.exit(1);
  }

  /**
   * Takes a filename as a command line argument and prints out the test coverage line by line
   *
   * @param args (command line arguments)
   */
  public static void main(final String[] args) {
    if (args.length == 0) {
      exitWithErrorMessage("Please provide a path to a Java file");
    }
    // Get the file path, open it as code class object
    final String filePath = args[0];
    CodeClass codeClass = null;
    try {
      final File file = new File(filePath);
      codeClass = new ExampleClass(file);
    } catch (IOException e) {
      exitWithErrorMessage("The file does not exist");
    }
    // Create a new random test, check against the code class
    final ExampleTest codeTest = new ExampleTest("Random Test");
    if (codeClass != null) {
      codeTest.testAgainst(codeClass);
    }
    // Work out which lines of the class are covered by the test
    final CodeAnalyzer codeAnalyzer = new ExampleAnalyzer();
    final Set<CodeLine> coveredLines = codeAnalyzer.runTest(codeTest);
    // Print out all lines, denoting covered lines prefixed with an X
    for (final CodeLine line : codeClass.getLinesOfCode()) {
      String printedLine = "";
      if (coveredLines.contains(line)) {
        printedLine = "X";
      } else {
        printedLine = " ";
      }
      printedLine += String.format(
          " %03d %s ",
          line.getLineNumber(),
          line.getContents()
      );
      System.out.println(printedLine);
    }
  }

}
