package com.thoughtworks.xunit.converter;

import com.thoughtworks.xunit.model.TestSuite;
import com.thoughtworks.xunit.parser.XUnitParser;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DummyXUnitConverterImplementer implements XUnitConverter {
    @Override
    public List<String> testReportFilePattern() {
        return Arrays.asList(new String[]{"2.xml"});
    }

    @Override
    public TestSuite convertToXUnitFormat(File file) {
        TestSuite testSuite = null;
        try {
            testSuite = XUnitParser.parseTestSuiteXUnitXML(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return testSuite;
    }
}
