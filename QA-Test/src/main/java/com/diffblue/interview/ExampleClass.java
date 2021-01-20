
package com.diffblue.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Simple test implementation of an object
 * to represent a single java file
 */
class ExampleClass implements CodeClass {

    private final File classFile;
    private final List<CodeLine> codeLines = new LinkedList<CodeLine>();

    /**
     * Main constructor for the code class
     * Returns an empty class if the provided list is null
     * @param classFile file object representing the class file to be read
     */
    ExampleClass(final File classFile) throws IOException {
        this.classFile = classFile;
        final List<String> linesRead = readAllLines(classFile);
        for (int i = 0; i < linesRead.size(); i++) {
            codeLines.add(new ExampleLine(i + 1, linesRead.get(i)));
        }
    }

    /**
     * Attempt to read in all lines of a file
     * and throw an IOException if it doesn't exist
     * @param file object to be read
     * @return each line in the file as a string
     */
    private List<String> readAllLines(File file) throws IOException {
        final FileInputStream fileInputStream = new FileInputStream(file);
        final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(fileInputStream));
        String line;
        final LinkedList<String> lines = new LinkedList<String>();
        line = bufferedReader.readLine();
        while (line != null) {
            lines.add(line);
            line = bufferedReader.readLine();
        }
        return lines;
    }

    /**
     * Getter for the lines of the code in the class
     * @return code lines in the class
     */
    public List<CodeLine> getLinesOfCode() {
        return codeLines;
    }

    /**
     * Getter for the file from which the source is taken
     * @return a file object representing the source file
     */
    public File getFile() {
        return classFile;
    }

}