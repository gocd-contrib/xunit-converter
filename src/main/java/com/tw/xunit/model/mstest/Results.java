package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import com.tw.xunit.model.TestCase;
import org.simpleframework.xml.ElementList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Results {
    @ElementList(entry = "UnitTestResult", inline = true, required = false)
    private List<UnitTestResult> results;

    public Results() {
    }

    public Results(List<UnitTestResult> results) {
        this.results = results;
    }

    public List<UnitTestResult> getResults() {
        return results;
    }

    public void setResults(List<UnitTestResult> results) {
        this.results = results;
    }

    /* Methods to handle conversion to xunit */
    public List<TestCase> getTestCases(HashMap<String, String> classNameMap) {
        ArrayList<TestCase> testCases = new ArrayList<TestCase>();

        for (int i = 0; i < results.size(); i++) {
            testCases.add(results.get(i).getTestCase(classNameMap));
        }

        return testCases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Results results1 = (Results) o;

        if (results != null ? !results.equals(results1.results) : results1.results != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return results != null ? results.hashCode() : 0;
    }
}
