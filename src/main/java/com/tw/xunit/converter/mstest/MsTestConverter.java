package com.tw.xunit.converter.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import com.tw.xunit.converter.XUnitConverter;
import com.tw.xunit.model.mstest.TestRun;
import com.tw.xunit.model.TestSuite;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MsTestConverter implements XUnitConverter {
    @Override
    public List<String> testReportFilePattern() {
        return Arrays.asList("*.xml");
    }

    @Override
    public TestSuite convertToXUnitFormat(File file) throws Exception {
        Serializer serializer = new Persister();

        TestRun tr = serializer.read(TestRun.class, file);
        tr.getResultsList();
        return new TestSuite(tr.getConverted_Name(), 0, tr.getConverted_tests(),tr.getConverted_failures(), tr.getConverted_errors(), tr.getConverted_disabled(), tr.getConverted_skipped(), tr.getConverted_timestamp(), null, tr.getId(), null, null, null, tr.getConverted_properties(), tr.getConverted_testcases(), null, null);
    }
}
