package com.diffblue.interview;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Sample {
    @Test
    public void coverageForAnalyzer(){
        ExampleAnalyzer analyzer=new ExampleAnalyzer();
        Set<CodeTest> sample=analyzer.uniqueTests();
        for(CodeTest sam : sample)
        {
          analyzer.runTestSuite(analyzer.uniqueTests());
        }
    }
}











