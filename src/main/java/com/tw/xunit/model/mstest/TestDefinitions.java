package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.ElementList;

import java.util.List;

public class TestDefinitions {
    @ElementList(entry = "UnitTest", inline = true, required = false)
    private List<UnitTest> unitTests;

    public TestDefinitions() {
    }

    public TestDefinitions(List<UnitTest> unitTests){
        this.unitTests = unitTests;
    }

    public List<UnitTest> getUnitTests() {return unitTests; }
    public void setUnitTests(List<UnitTest> unitTests) { this.unitTests = unitTests; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof TestDefinitions)) return false;

        TestDefinitions that = (TestDefinitions) o;

        if(unitTests != null ? !unitTests.equals(that.unitTests) : that.unitTests != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return unitTests != null ? unitTests.hashCode() : 0;
    }
}
