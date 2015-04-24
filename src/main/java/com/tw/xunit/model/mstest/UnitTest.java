package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class UnitTest {
    @Attribute(required = false)
    private String name;

    @Attribute(required = false)
    private String storage;

    @Attribute(required = false)
    private String id;

    @ElementList(entry = "TestCategory", inline = true, required = false)
    private List<TestCategory> testCategoryList;

    @ElementList(entry = "Execution", inline = true, required = false)
    private List<Execution> executions;

    @ElementList(entry = "TestMethod", inline = true, required = false)
    private List<TestMethod> testMethods;

    public UnitTest () {
    }

    public UnitTest(String name, String storage, String id, List<TestCategory> testCategoryList, List<Execution> executions, List<TestMethod> testMethods) {
        this.name = name;
        this.storage = storage;
        this.id = id;
        this.testCategoryList = testCategoryList;
        this.executions = executions;
        this.testMethods = testMethods;
    }

    public String getName() {return name; }
    public void setName(String name) {this.name = name; }
    public String getId() {return id; }
    public void setId(String id) {this.id = id; }
    public String getStorage() { return storage; }
    public void setStorage(String storage) { this.storage = storage; }
    public List<TestCategory> getTestCategoryList() { return testCategoryList; }
    public void setTestCategoryList(List<TestCategory> testCategoryList) { this.testCategoryList = testCategoryList; }
    public List<Execution> getExecutions() {return executions; }
    public void setExecutions(List<Execution> executions){ this.executions = executions; }
    public List<TestMethod> getTestMethods() {return testMethods; }
    public void setTestMethods(List<TestMethod> testMethods){ this.testMethods = testMethods; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof UnitTest)) return false;

        UnitTest that = (UnitTest) o;

        if(name != null ? !name.equals(that.name) : that.name != null) return false;
        if(storage != null ? !storage.equals(that.id) : that.storage != null) return false;
        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(testCategoryList != null ? !testCategoryList.equals(that.testCategoryList) : that.testCategoryList != null) return false;
        if(executions != null ? !executions.equals(that.executions) : that.executions != null) return false;
        if(testMethods != null ? !testMethods.equals(that.testMethods) : that.testMethods != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (storage != null ? storage.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (testCategoryList != null ? testCategoryList.hashCode() : 0);
        result = 31 * result + (executions != null ? executions.hashCode() : 0);
        result = 31 * result + (testMethods != null ? testMethods.hashCode() : 0);

        return result;
    }

}
