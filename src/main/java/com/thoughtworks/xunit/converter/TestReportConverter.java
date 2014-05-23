package com.thoughtworks.xunit.converter;

import com.thoughtworks.xunit.exception.NoFileToConvertException;
import com.thoughtworks.xunit.exception.UnknownConverterException;
import com.thoughtworks.xunit.model.TestSuite;
import com.thoughtworks.xunit.printer.XUnitPrinter;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestReportConverter {
    static Map<String, XUnitConverter> converters = new HashMap<String, XUnitConverter>();

    static {
    }

    public void convert(String converterId, File inputDirectory, File outputDirectory) throws UnknownConverterException, NoFileToConvertException {
        if (!inputDirectory.exists()) {
            throw new RuntimeException("input directory: " + inputDirectory + " not found.");
        }

        XUnitConverter converter = getConverterFor(converterId);

        File[] testReports = getMatchingFiles(inputDirectory, converter.testReportFilePattern());

        if (testReports == null || testReports.length == 0) {
            throw new NoFileToConvertException(inputDirectory, converter.testReportFilePattern());
        }

        outputDirectory.mkdirs();

        for (File currentTestReport : testReports) {
            convertToXUnit(currentTestReport, converter, outputDirectory);
        }
    }

    XUnitConverter getConverterFor(String converterId) throws UnknownConverterException {
        if (!converters.containsKey(converterId)) {
            throw new UnknownConverterException(converterId);
        }
        return converters.get(converterId);
    }

    File[] getMatchingFiles(File directory, final List<String> patterns) {
        return directory.listFiles((FileFilter) new WildcardFileFilter(patterns.toArray(new String[patterns.size()]), IOCase.INSENSITIVE));
    }

    void convertToXUnit(File currentTestReport, XUnitConverter converter, File outputDirectory) {
        TestSuite testSuiteForTestReport = converter.convertToXUnitFormat(currentTestReport);
        String outputFilePath = outputDirectory + "/" + currentTestReport.getName() + ".xml";
        try {
            XUnitPrinter.printTestSuiteXUnitXML(testSuiteForTestReport, new File(outputFilePath));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
