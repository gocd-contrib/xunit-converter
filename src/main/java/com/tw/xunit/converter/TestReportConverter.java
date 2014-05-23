package com.tw.xunit.converter;

import com.tw.xunit.converter.jsunit.JsUnitConverter;
import com.tw.xunit.exception.NoFileToConvertException;
import com.tw.xunit.exception.UnknownConverterException;
import com.tw.xunit.model.TestSuite;
import com.tw.xunit.printer.XUnitPrinter;
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
        converters.put("jsunit", new JsUnitConverter());
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
            try {
                convertToXUnit(currentTestReport, converter, outputDirectory);
            } catch (Exception e) {
                // report this
            }
        }
    }

    public static boolean supportsConverter(String converterId) {
        return converters.containsKey(converterId);
    }

    XUnitConverter getConverterFor(String converterId) throws UnknownConverterException {
        if (!supportsConverter(converterId)) {
            throw new UnknownConverterException(converterId);
        }
        return converters.get(converterId);
    }

    File[] getMatchingFiles(File directory, final List<String> patterns) {
        return directory.listFiles((FileFilter) new WildcardFileFilter(patterns.toArray(new String[patterns.size()]), IOCase.INSENSITIVE));
    }

    void convertToXUnit(File currentTestReport, XUnitConverter converter, File outputDirectory) throws Exception {
        TestSuite testSuiteForTestReport = converter.convertToXUnitFormat(currentTestReport);
        String outputFilePath = outputDirectory + "/" + currentTestReport.getName() + ".xml";
        XUnitPrinter.printTestSuiteXUnitXML(testSuiteForTestReport, new File(outputFilePath));
    }
}
