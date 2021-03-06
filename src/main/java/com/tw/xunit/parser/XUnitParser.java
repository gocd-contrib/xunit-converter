package com.tw.xunit.parser;

import com.tw.xunit.model.TestSuite;
import com.tw.xunit.model.TestSuites;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

public class XUnitParser {
    public static TestSuites parseTestSuitesXUnitXML(File inputFile) throws Exception {
        Serializer serializer = new Persister();

        TestSuites testSuites = serializer.read(TestSuites.class, inputFile);

        return testSuites;
    }

    public static TestSuite parseTestSuiteXUnitXML(File inputFile) throws Exception {
        Serializer serializer = new Persister();

        TestSuite testSuite = serializer.read(TestSuite.class, inputFile);

        return testSuite;
    }
}
