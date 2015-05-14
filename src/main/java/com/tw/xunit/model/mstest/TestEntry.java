package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import org.simpleframework.xml.Attribute;

public class TestEntry {
    @Attribute(required = false)
    private String testId;

    @Attribute(required = false)
    private String executionId;

    @Attribute(required = false)
    private String testListId;

    public TestEntry() {
    }

    public TestEntry(String testId, String executionId, String testListId) {
        this.testId = testId;
        this.executionId = executionId;
        this.testListId = testListId;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getTestListId() {
        return testListId;
    }

    public void setTestListId(String testListId) {
        this.testListId = testListId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestEntry testEntry = (TestEntry) o;

        if (executionId != null ? !executionId.equals(testEntry.executionId) : testEntry.executionId != null)
            return false;
        if (testId != null ? !testId.equals(testEntry.testId) : testEntry.testId != null) return false;
        if (testListId != null ? !testListId.equals(testEntry.testListId) : testEntry.testListId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testId != null ? testId.hashCode() : 0;
        result = 31 * result + (executionId != null ? executionId.hashCode() : 0);
        result = 31 * result + (testListId != null ? testListId.hashCode() : 0);
        return result;
    }
}
