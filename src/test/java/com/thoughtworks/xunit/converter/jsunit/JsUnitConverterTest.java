package com.thoughtworks.xunit.converter.jsunit;

import com.thoughtworks.xunit.converter.TestReportConverter;
import com.thoughtworks.xunit.model.TestSuite;
import com.thoughtworks.xunit.parser.XUnitParser;
import org.junit.Test;

import java.io.File;
import java.util.UUID;

import static com.thoughtworks.xunit.helpers.ResourceHelper.resource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JsUnitConverterTest {
    @Test
    public void testConvertToXUnitFormat() throws Exception {
        File outputDirectory = new File("/tmp/" + UUID.randomUUID());
        new TestReportConverter().convert("jsunit", resource("/sample-jsunit-reports"), outputDirectory);
        File outputFile = new File(outputDirectory.getAbsoluteFile() + "/1.xml.xml");
        TestSuite testSuite = XUnitParser.parseTestSuiteXUnitXML(outputFile);
        assertThat(testSuite.getTestCases().size(), is(330));
    }
}