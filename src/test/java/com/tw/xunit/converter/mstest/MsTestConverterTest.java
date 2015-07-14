package com.tw.xunit.converter.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import com.tw.xunit.converter.TestReportConverter;
import com.tw.xunit.model.TestSuite;
import com.tw.xunit.parser.XUnitParser;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.UUID;

import static com.tw.xunit.helpers.ResourceHelper.resource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MsTestConverterTest {
    @Test
    public void testConvertDBResultToXUnitFormat() throws Exception {
        File outputDirectory = new File("/tmp/" + UUID.randomUUID());
        new TestReportConverter().convert("mstest", resource("/sample-mstest-reports/database-result"), outputDirectory);
        File outputFile = new File(outputDirectory.getAbsoluteFile() + "/1.trx.xml");
        TestSuite testSuite = XUnitParser.parseTestSuiteXUnitXML(outputFile);
        assertThat(testSuite.getTestCases().size(), is(142));
    }

    @Test
    public void testConvertWebResultToXUnitFormat() throws Exception {
        File outputDirectory = new File("/tmp/" + UUID.randomUUID());
        new TestReportConverter().convert("mstest", resource("/sample-mstest-reports/web-app-result"), outputDirectory);
        File outputFile = new File(outputDirectory.getAbsoluteFile() + "/1.trx.xml");
        TestSuite testSuite = XUnitParser.parseTestSuiteXUnitXML(outputFile);
        assertThat(testSuite.getTestCases().size(), is(2));
    }

    @Test
    public void testConvertMultipleResults() throws Exception {
        File outputDirectory = new File("/tmp/" + UUID.randomUUID());
        new TestReportConverter().convert("mstest", resource("/sample-mstest-reports/combined-multiple-results"), outputDirectory);
        File databaseoutputFile = new File(outputDirectory.getAbsoluteFile() + "/database.trx.xml");
        File weboutputFile = new File(outputDirectory.getAbsoluteFile() + "/web.trx.xml");
        TestSuite databasetestSuite = XUnitParser.parseTestSuiteXUnitXML(databaseoutputFile);
        TestSuite webtestSuite = XUnitParser.parseTestSuiteXUnitXML(weboutputFile);
        assertThat(databasetestSuite.getTestCases().size(), is(3));
        assertThat(webtestSuite.getTestCases().size(), is(2));
    }
}
