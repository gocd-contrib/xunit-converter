package com.thoughtworks.xunit.converter.jsunit;

import com.thoughtworks.xunit.model.TestCase;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class TestCases {
    @ElementList(entry = "testCase", inline = true, required = false)
    private List<TestCase> testCases;

    public TestCases() {
    }

    public TestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestCases)) return false;

        TestCases testCases1 = (TestCases) o;

        if (testCases != null ? !testCases.equals(testCases1.testCases) : testCases1.testCases != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return testCases != null ? testCases.hashCode() : 0;
    }
}
