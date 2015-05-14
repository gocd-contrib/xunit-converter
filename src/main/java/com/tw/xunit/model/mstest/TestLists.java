package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import org.simpleframework.xml.ElementList;

import java.util.List;

public class TestLists {
    @ElementList(entry = "TestList", inline = true, required = false)
    private List<TestList> testLists;

    public TestLists() {
    }

    public TestLists(List<TestList> testLists) {
        this.testLists = testLists;
    }

    public List<TestList> getTestLists() {
        return testLists;
    }

    public void setTestLists(List<TestList> testLists) {
        this.testLists = testLists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestLists testLists1 = (TestLists) o;

        if (testLists != null ? !testLists.equals(testLists1.testLists) : testLists1.testLists != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return testLists != null ? testLists.hashCode() : 0;
    }
}
