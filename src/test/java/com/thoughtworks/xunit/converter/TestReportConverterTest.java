package com.thoughtworks.xunit.converter;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.UUID;

import static com.thoughtworks.xunit.helpers.ResourceHelper.resource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestReportConverterTest {
    @Test
    public void shouldConvertToXUnitCorrectly() throws Exception {
        TestReportConverter.converters.put("DummyXUnitConverterImplementer", new DummyXUnitConverterImplementer());

        File outputDirectory = new File("/tmp/" + UUID.randomUUID());

        new TestReportConverter().convert("DummyXUnitConverterImplementer", resource("/xunit-report-output"), outputDirectory);

        assertThat(FileUtils.readFileToString(new File(outputDirectory.getAbsolutePath() + "/2.xml.xml")), is(FileUtils.readFileToString(resource("/xunit-report-output/2.xml"))));
    }

    @Test
    public void shouldGetMatchingFilesCorrectly() throws Exception {
        File[] matchingFiles = new TestReportConverter().getMatchingFiles(resource("/sample-xunit-reports"), Arrays.asList(new String[]{"*.xml"}));
        assertThat(matchingFiles.length, is(2));
        assertThat(matchingFiles[0].getName(), is("1.xml"));
        assertThat(matchingFiles[1].getName(), is("2.xml"));
    }
}