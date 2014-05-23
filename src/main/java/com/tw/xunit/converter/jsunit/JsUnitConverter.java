package com.tw.xunit.converter.jsunit;

import com.tw.xunit.converter.XUnitConverter;
import com.tw.xunit.model.TestSuite;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class JsUnitConverter implements XUnitConverter {
    @Override
    public List<String> testReportFilePattern() {
        return Arrays.asList("*.xml");
    }

    @Override
    public TestSuite convertToXUnitFormat(File file) {
        Serializer serializer = new Persister();

        try {
            BrowserResult br = serializer.read(BrowserResult.class, file);
            br.getTestCases().getTestCases();
            return new TestSuite(null, br.getTime(), 0, 0, 0, 0, 0, null, null, br.getId(), null, null, null, br.getProperties(), br.getTestCases().getTestCases(), null, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
