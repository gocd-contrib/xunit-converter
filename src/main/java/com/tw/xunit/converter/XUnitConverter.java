package com.tw.xunit.converter;

import com.tw.xunit.model.TestSuite;

import java.io.File;
import java.util.List;

public interface XUnitConverter {
    /**
     * @return list of test report file matcher that converter understands. Ex: *.csv, *.xml.
     */
    public List<String> testReportFilePattern();

    /**
     * @param file input file that needs to be converted to XUnit format. Guaranteed to match one of the specified patterns.
     * @return XUnit Object map for <testsuite>...</testsuite> - TestSuite. It will be serialized to a file confirming to XUnit format.
     */
    public TestSuite convertToXUnitFormat(File file);
}
