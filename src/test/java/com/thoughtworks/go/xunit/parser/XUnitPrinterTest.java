package com.thoughtworks.go.xunit.parser;

import com.thoughtworks.go.xunit.model.*;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.StringWriter;
import java.util.ArrayList;

import static com.thoughtworks.go.xunit.helpers.TestHelper.resource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class XUnitPrinterTest {
    @Test
    public void testPrintTestSuitesXUnitXMLCorrectly() throws Exception {
        ArrayList<TestSuite> testSuiteList = new ArrayList<TestSuite>();
        ArrayList<Properties> propertiesList = new ArrayList<Properties>();
        ArrayList<Property> propertyList = new ArrayList<Property>();
        Property property = new Property("name", "value");
        propertyList.add(property);
        Properties properties = new Properties(propertyList);
        propertiesList.add(properties);
        ArrayList<TestCase> testCaseList = new ArrayList<TestCase>();
        ArrayList<Failure> failureList = new ArrayList<Failure>();
        Failure failure = new Failure("type", "message", "value");
        failureList.add(failure);
        ArrayList<SysOut> sysOuts = new ArrayList<SysOut>();
        SysOut sysout = new SysOut("value");
        sysOuts.add(sysout);
        TestCase testCase = new TestCase("name", 0, "classname", null, null, null, null, null, failureList, null, null, sysOuts, null);
        testCaseList.add(testCase);
        TestSuite testSuite = new TestSuite("name", 0, 1, 1, 1, 1, 1, "time", null, null, null, null, null, propertiesList, testCaseList, null, null);
        testSuiteList.add(testSuite);
        TestSuites testSuites = new TestSuites("name", 0, 1, 1, 1, 1, testSuiteList);
        StringWriter writer = new StringWriter();
        XUnitPrinter.printTestSuitesXUnitXML(testSuites, writer);
        assertThat(writer.toString(), is(FileUtils.readFileToString(resource("/xunit-report-output/1.xml"))));
    }
}