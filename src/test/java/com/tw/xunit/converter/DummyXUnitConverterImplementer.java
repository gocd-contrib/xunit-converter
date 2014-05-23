package com.tw.xunit.converter;

import com.tw.xunit.model.TestSuite;
import com.tw.xunit.parser.XUnitParser;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DummyXUnitConverterImplementer implements XUnitConverter {
    @Override
    public List<String> testReportFilePattern() {
        return Arrays.asList(new String[]{"2.xml"});
    }

    @Override
    public TestSuite convertToXUnitFormat(File file) throws Exception {
        return XUnitParser.parseTestSuiteXUnitXML(file);
    }
}
