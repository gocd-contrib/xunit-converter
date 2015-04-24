package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */
import com.tw.xunit.converter.jsunit.TestCases;
import com.tw.xunit.model.Properties;
import com.tw.xunit.model.Property;
import com.tw.xunit.model.TestCase;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
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

    @ElementList(entry = "TestSettings", inline = true, required = false)
    private List<TestSettings> testSettingsList;

    @ElementList(entry = "Times", inline = true, required = false)
    private List<Times> timesList;

    @ElementList(entry = "ResultSummary", inline = true, required = false)
    private List<ResultSummary> resultSummaryList;

    @ElementList(entry = "TestDefinitions", inline = true, required = false)
    private List<TestDefinitions> testDefinitionsList;

    @ElementList(entry = "TestLists", inline = true, required = false)
    private List<TestLists> testListsList;

    @ElementList(entry = "TestEntries", inline = true, required = false)
    private List<TestEntries> testEntriesList;

    @ElementList(entry = "Results", inline = true, required = false)
    private List<Results> resultsList;

    public TestRun() {
    }

    public TestRun(String xmlns, String id, String name, String runUser, List<TestSettings> testSettingsList, List<Times> timesList, List<ResultSummary> resultSummaryList, List<TestDefinitions> testDefinitionsList, List<TestLists> testListsList, List<TestEntries> testEntriesList, List<Results> resultsList) {
        this.xmlns = xmlns;
        this.id = id;
        this.name = name;
        this.runUser = runUser;
        this.testSettingsList = testSettingsList;
        this.timesList = timesList;
        this.resultSummaryList = resultSummaryList;
        this.testDefinitionsList = testDefinitionsList;
        this.testListsList = testListsList;
        this.testEntriesList = testEntriesList;
        this.resultsList = resultsList;
    }

    public String getXmlns() {return xmlns; }
    public void setXmlns(String xmlns) {this.xmlns = xmlns; }
    public String getName() {return name; }
    public void setName(String name) {this.name = name; }
    public String getId() {return id; }
    public void setId(String id) {this.id = id; }
    public String getRunUser() {return runUser; }
    public void setRunUser(String runUser) {this.runUser = runUser; }
    public List<TestSettings> getTestSettingsList() {return testSettingsList;}
    public void setTestSettingsList(List<TestSettings> testSettingsList) { this.testSettingsList = testSettingsList; }
    public List<Times> getTimesList() { return timesList; }
    public void setTimesList(List<Times> timesList) { this.timesList = timesList;}
    public List<ResultSummary> getResultSummaryList() { return resultSummaryList; }
    public void setResultSummaryList(List<ResultSummary> resultSummaryList) { this.resultSummaryList = resultSummaryList; }
    public List<TestDefinitions> getTestDefinitionsList() { return testDefinitionsList; }
    public void setTestDefinitionsList(List<TestDefinitions> testDefinitionsList) { this.testDefinitionsList = testDefinitionsList; }
    public List<TestLists> getTestListsList() { return testListsList; }
    public void setTestListsList(List<TestLists> testListsList){ this.testListsList = testListsList; }
    public List<TestEntries> getTestEntriesList() { return testEntriesList; }
    public void setTestEntriesList(List<TestEntries> testEntriesList) { this.testEntriesList = testEntriesList; }
    public List<Results> getResultsList() { return resultsList; }
    public void setResultsList(List<Results> resultsList) { this.resultsList = resultsList; }

    /* Methods to handle conversion to xunit */
    public String getConverted_Name() {
        return this.name;
    }

    /* time will be tough, need to calculate it */
    public int getConverted_tests() {
        return this.resultSummaryList.get(0).getCountersList().get(0).total;
    }
    public int getConverted_failures() {
        return this.resultSummaryList.get(0).getCountersList().get(0).failed;
    }
    public int getConverted_errors() {
        return this.resultSummaryList.get(0).getCountersList().get(0).error;
    }
    public int getConverted_disabled() {
        return this.resultSummaryList.get(0).getCountersList().get(0).inconclusive;
    }
    public int getConverted_skipped() {
        return this.resultSummaryList.get(0).getCountersList().get(0).notExecuted;
    }
    public String getConverted_timestamp() {
        return this.timesList.get(0).getCreation();
    }

    /* Don't know what assertions,packages,or files look like */

    public List<Properties> getConverted_properties() {
        ArrayList<Property> propertyList = new ArrayList<Property>();
        ArrayList<Properties> propertiesList = new ArrayList<Properties>();

        if(this.id != null) { propertyList.add(new Property("id",id)); }

        if(this.name != null) { propertyList.add(new Property("name",name));}

        if(this.runUser != null) {propertyList.add(new Property("runuser",runUser));}

        if(this.timesList != null) {
            String start = timesList.get(0).getStart();
            String finish = timesList.get(0).getFinish();

            if (start != null) { propertyList.add(new Property("start",start)); }
            if (finish != null) {propertyList.add(new Property("finish",finish)); }
        }

         propertiesList.add(new Properties(propertyList));

        return propertiesList;
    }

    public List<TestCase> getConverted_testcases() {
        return resultsList.get(0).getConverted_testcases();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof TestRun)) return false;

        TestRun that = (TestRun) o;

        if(xmlns != null ? !xmlns.equals(that.xmlns) : that.xmlns != null) return false;
        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(name != null ? !name.equals(that.name) : that.name != null) return false;
        if(runUser != null ? !runUser.equals(that.runUser) : that.runUser != null) return false;
        if(testSettingsList != null ? !testSettingsList.equals(that.testSettingsList) : that.testSettingsList != null) return false;
        if(timesList != null ? !timesList.equals(that.timesList) : that.timesList != null) return false;
        if(resultSummaryList != null ? !resultSummaryList.equals(that.resultSummaryList) : that.resultSummaryList != null) return false;
        if(testDefinitionsList != null ? !testDefinitionsList.equals(that.testDefinitionsList) : that.testDefinitionsList != null) return false;
        if(testListsList != null ? !testListsList.equals(that.testListsList) : that.testListsList != null) return false;
        if(testEntriesList != null ? !runUser.equals(that.testEntriesList) : that.testEntriesList != null) return false;
        if(resultsList != null ? !resultsList.equals(that.resultsList) : that.resultsList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (xmlns != null ? xmlns.hashCode() : 0);
        result = 31 * result + (runUser != null ? runUser.hashCode() : 0);
        result = 31 * result + (testSettingsList != null ? testSettingsList.hashCode() : 0);
        result = 31 * result + (timesList != null ? timesList.hashCode() : 0);
        result = 31 * result + (resultSummaryList != null ? resultSummaryList.hashCode() : 0);
        result = 31 * result + (testDefinitionsList != null ? testDefinitionsList.hashCode() : 0);
        result = 31 * result + (testListsList != null ? testListsList.hashCode() : 0);
        result = 31 * result + (testEntriesList != null ? testEntriesList.hashCode() : 0);
        result = 31 * result + (resultsList != null ? resultsList.hashCode() : 0);

        return result;
    }

}
