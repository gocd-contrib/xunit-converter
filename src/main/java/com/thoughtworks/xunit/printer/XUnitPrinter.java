package com.thoughtworks.xunit.printer;

import com.thoughtworks.xunit.model.TestSuite;
import com.thoughtworks.xunit.model.TestSuites;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.Writer;

public class XUnitPrinter {
    public static void printTestSuitesXUnitXML(TestSuites testSuites, Writer writer) throws Exception {
        Serializer serializer = new Persister();

        serializer.write(testSuites, writer);
    }

    public static void printTestSuiteXUnitXML(TestSuite testSuite, Writer writer) throws Exception {
        Serializer serializer = new Persister();

        serializer.write(testSuite, writer);
    }

    public static void printTestSuiteXUnitXML(TestSuite testSuite, File outputFile) throws Exception {
        Serializer serializer = new Persister();

        serializer.write(testSuite, outputFile);
    }
}
