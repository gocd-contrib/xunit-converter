package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.ElementList;

import java.util.HashMap;
import java.util.List;

public class TestDefinitions {
    @ElementList(entry = "UnitTest", inline = true, required = false)
    private List<UnitTest> unitTests;

    private HashMap<String, String> testIdClassMap;

    public TestDefinitions() {
    }

    public TestDefinitions(List<UnitTest> unitTests) {
        this.unitTests = unitTests;
    }

    public List<UnitTest> getUnitTests() {
        return unitTests;
    }

    public void setUnitTests(List<UnitTest> unitTests) {
        this.unitTests = unitTests;
    }


    public HashMap<String, String> getTestIdClassMap() {
        if (testIdClassMap == null) {
            testIdClassMap = new HashMap<String, String>();

            for (int i = 0; i < unitTests.size(); i++) {
                testIdClassMap.put(unitTests.get(i).getId(), unitTests.get(i).getTestMethod().getClassNamePretty());
            }
        }
        return testIdClassMap;
        //return testIdClassMap.containsKey(testId) ? testIdClassMap.get(testId) : "Not Found";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestDefinitions that = (TestDefinitions) o;

        if (testIdClassMap != null ? !testIdClassMap.equals(that.testIdClassMap) : that.testIdClassMap != null)
            return false;
        if (unitTests != null ? !unitTests.equals(that.unitTests) : that.unitTests != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitTests != null ? unitTests.hashCode() : 0;
        result = 31 * result + (testIdClassMap != null ? testIdClassMap.hashCode() : 0);
        return result;
    }
}
