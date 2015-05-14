package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import com.tw.xunit.model.Properties;
import com.tw.xunit.model.Property;
import com.tw.xunit.model.TestCase;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "TestRun", strict = false)
public class TestRun {
    @Attribute(required = false)
    private String xmlns;

    @Attribute(required = false)
    private String id;

    @Attribute(required = false)
    private String name;

    @Attribute(required = false)
    private String runUser;

    @Element(name = "TestSettings", required = false)
    private TestSettings testSettings;

    @Element(name = "Times", required = false)
    private Times times;

    @Element(name = "ResultSummary", required = false)
    private ResultSummary resultSummary;

    @Element(name = "TestDefinitions", required = false)
    private TestDefinitions testDefinitions;

    @Element(name = "TestLists", required = false)
    private TestLists testLists;

    @Element(name = "TestEntries", required = false)
    private TestEntries testEntries;

    @Element(name = "Results", required = false)
    private Results results;

    public TestRun() {
    }

    public TestRun(String xmlns, String id, String name, String runUser, TestSettings testSettings, Times times, ResultSummary resultSummary, TestDefinitions testDefinitions, TestLists testLists, TestEntries testEntries, Results results) {
        this.xmlns = xmlns;
        this.id = id;
        this.name = name;
        this.runUser = runUser;
        this.testSettings = testSettings;
        this.times = times;
        this.resultSummary = resultSummary;
        this.testDefinitions = testDefinitions;
        this.testLists = testLists;
        this.testEntries = testEntries;
        this.results = results;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRunUser() {
        return runUser;
    }

    public void setRunUser(String runUser) {
        this.runUser = runUser;
    }

    public TestSettings getTestSettings() {
        return testSettings;
    }

    public void setTestSettings(TestSettings testSettings) {
        this.testSettings = testSettings;
    }

    public Times getTimes() {
        return times;
    }

    public void setTimes(Times times) {
        this.times = times;
    }

    public ResultSummary getResultSummary() {
        return resultSummary;
    }

    public void setResultSummary(ResultSummary resultSummary) {
        this.resultSummary = resultSummary;
    }

    public TestDefinitions getTestDefinitions() {
        return testDefinitions;
    }

    public void setTestDefinitions(TestDefinitions testDefinitions) {
        this.testDefinitions = testDefinitions;
    }

    public TestLists getTestLists() {
        return testLists;
    }

    public void setTestLists(TestLists testLists) {
        this.testLists = testLists;
    }

    public TestEntries getTestEntries() {
        return testEntries;
    }

    public void setTestEntries(TestEntries testEntries) {
        this.testEntries = testEntries;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    /* Methods to handle conversion to xunit */
    public double getTotalTime() {
        return this.times.getTotalTime();
    }

    public int getConverted_tests() {
        return this.resultSummary.getCounters().total;
    }

    public int getConverted_failures() {
        return this.resultSummary.getCounters().failed;
    }

    public int getConverted_errors() {
        return this.resultSummary.getCounters().error;
    }

    public int getConverted_disabled() {
        return this.resultSummary.getCounters().inconclusive;
    }

    public int getConverted_skipped() {
        return this.resultSummary.getCounters().notExecuted;
    }

    public String getConverted_timestamp() {
        return this.times.getCreation_pretty();
    }

    public String getConverted_hostname() {
        return this.name.substring(0, this.name.indexOf(" "));
    }

    /* Don't know what assertions,packages,or files look like */

    public List<Properties> getConverted_properties() {
        ArrayList<Property> propertyList = new ArrayList<Property>();
        ArrayList<Properties> propertiesList = new ArrayList<Properties>();

        if (this.id != null) {
            propertyList.add(new Property("id", id));
        }
        if (this.name != null) {
            propertyList.add(new Property("name", name));
        }
        if (this.runUser != null) {
            propertyList.add(new Property("runuser", runUser));
        }
        if (this.times.getStart() != null) {
            propertyList.add(new Property("start", this.times.getStart_pretty()));
        }
        if (this.times.getFinish() != null) {
            propertyList.add(new Property("finish", this.times.getFinish_pretty()));
        }

        propertiesList.add(new Properties(propertyList));

        return propertiesList;
    }

    public List<TestCase> getTestCases() {
        return this.results.getTestCases(this.testDefinitions.getTestIdClassMap());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestRun testRun = (TestRun) o;

        if (id != null ? !id.equals(testRun.id) : testRun.id != null) return false;
        if (name != null ? !name.equals(testRun.name) : testRun.name != null) return false;
        if (resultSummary != null ? !resultSummary.equals(testRun.resultSummary) : testRun.resultSummary != null)
            return false;
        if (results != null ? !results.equals(testRun.results) : testRun.results != null) return false;
        if (runUser != null ? !runUser.equals(testRun.runUser) : testRun.runUser != null) return false;
        if (testDefinitions != null ? !testDefinitions.equals(testRun.testDefinitions) : testRun.testDefinitions != null)
            return false;
        if (testEntries != null ? !testEntries.equals(testRun.testEntries) : testRun.testEntries != null) return false;
        if (testLists != null ? !testLists.equals(testRun.testLists) : testRun.testLists != null) return false;
        if (testSettings != null ? !testSettings.equals(testRun.testSettings) : testRun.testSettings != null)
            return false;
        if (times != null ? !times.equals(testRun.times) : testRun.times != null) return false;
        if (xmlns != null ? !xmlns.equals(testRun.xmlns) : testRun.xmlns != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xmlns != null ? xmlns.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (runUser != null ? runUser.hashCode() : 0);
        result = 31 * result + (testSettings != null ? testSettings.hashCode() : 0);
        result = 31 * result + (times != null ? times.hashCode() : 0);
        result = 31 * result + (resultSummary != null ? resultSummary.hashCode() : 0);
        result = 31 * result + (testDefinitions != null ? testDefinitions.hashCode() : 0);
        result = 31 * result + (testLists != null ? testLists.hashCode() : 0);
        result = 31 * result + (testEntries != null ? testEntries.hashCode() : 0);
        result = 31 * result + (results != null ? results.hashCode() : 0);
        return result;
    }
}
