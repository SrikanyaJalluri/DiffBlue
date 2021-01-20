
package com.diffblue.interview;

class ExampleLine implements CodeLine {

    private final int lineNumber;
    private String contents;

    /**
     * Main constructor for this code line class
     * @param lineNumber (the number of the line in the file)
     * @param contents (the contents of the line, should not be null)
     */
    ExampleLine(final int lineNumber, final String contents) {
        this.lineNumber = lineNumber;
        if (contents == null) {
            this.contents = "";
        }
        this.contents = contents;
    }

    /**
     * Getter for this line's line number in the source file
     * @return int line number
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Getter for the contents of the code line in the source file
     * @return String line of code
     */
    public String getContents() {
        return contents;
    }

}
