package com.tw.xunit.converter.nose;

import com.tw.xunit.converter.XUnitConverter;
import com.tw.xunit.model.TestSuite;
import com.tw.xunit.parser.XUnitParser;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class NoseConverter implements XUnitConverter {
    @Override
    public List<String> testReportFilePattern() {
        return Arrays.asList("*.xml");
    }

    @Override
    public TestSuite convertToXUnitFormat(File file) throws Exception {
        return XUnitParser.parseTestSuiteXUnitXML(file);
    }
}
