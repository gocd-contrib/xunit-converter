package com.thoughtworks.go.xunit.parser;

import com.thoughtworks.go.xunit.model.TestSuites;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.Writer;

public class XUnitPrinter {
    public static TestSuites printTestSuitesXUnitXML(TestSuites testSuites, Writer writer) throws Exception {
        Serializer serializer = new Persister();

        serializer.write(testSuites, writer);

        return testSuites;
    }
}
