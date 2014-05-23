package com.tw.xunit.printer;

import com.tw.xunit.model.*;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;

import static com.tw.xunit.helpers.ResourceHelper.resource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class XUnitPrinterTest {
    @Test
    public void testPrintTestSuitesXUnitXMLCorrectly() throws Exception {
        TestSuites testSuites = getTestSuites(getTestSuite());
        StringWriter writer = new StringWriter();
        XUnitPrinter.printTestSuitesXUnitXML(testSuites, writer);
        assertThat(writer.toString(), is(FileUtils.readFileToString(resource("/xunit-report-output/1.xml"))));
    }

    @Test
    public void testPrintTestSuiteXUnitXMLCorrectly() throws Exception {
        TestSuite testSuite = getTestSuite();
        StringWriter writer = new StringWriter();
        XUnitPrinter.printTestSuiteXUnitXML(testSuite, writer);
        assertThat(writer.toString(), is(FileUtils.readFileToString(resource("/xunit-report-output/2.xml"))));
    }

    private TestSuites getTestSuites(TestSuite... testSuites) {
        return new TestSuites("name", 0.5, 5, 1, 1, 1, new ArrayList<TestSuite>(Arrays.asList(testSuites)));
    }

    private TestSuite getTestSuite() {
        return new TestSuite("name", 0.5, 5, 1, 1, 1, 1, "time", null, null, null, null, null, getProperties(new Property("name", "value")), getTestCases(getTestCase()), null, null);
    }

    private ArrayList<Properties> getProperties(Property... properties) {
        return new ArrayList<Properties>(Arrays.asList(new Properties(new ArrayList<Property>(Arrays.asList(properties)))));
    }

    private ArrayList<TestCase> getTestCases(TestCase testCase) {
        return new ArrayList<TestCase>(Arrays.asList(testCase));
    }

    private TestCase getTestCase() {
        return new TestCase("name", 0.1, "classname", null, null, null, null, null, getFailures(new Failure("type", "message", "value")), null, null, getSysOuts(new SysOut("value")), null);
    }

    private ArrayList<Failure> getFailures(Failure... failures) {
        return new ArrayList<Failure>(Arrays.asList(failures));
    }

    private ArrayList<SysOut> getSysOuts(SysOut... sysOuts) {
        return new ArrayList<SysOut>(Arrays.asList(sysOuts));
    }
}