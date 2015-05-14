package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import org.simpleframework.xml.ElementList;

import java.util.List;

public class TestEntries {
    @ElementList(entry = "TestEntry", inline = true, required = false)
    private List<TestEntry> testEntries;

    public TestEntries() {
    }

    public TestEntries(List<TestEntry> testEntries) {
        this.testEntries = testEntries;
    }

    public List<TestEntry> getTestEntries() {
        return testEntries;
    }

    public void setTestEntries(List<TestEntry> testEntries) {
        this.testEntries = testEntries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestEntries that = (TestEntries) o;

        if (testEntries != null ? !testEntries.equals(that.testEntries) : that.testEntries != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return testEntries != null ? testEntries.hashCode() : 0;
    }
}
