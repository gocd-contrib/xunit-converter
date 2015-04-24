package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Element;

import java.util.List;

public class UnitTest {
    @Attribute(required = false)
    private String name;

    @Attribute(required = false)
    private String storage;

    @Attribute(required = false)
    private String id;

    @Element(name = "TestCategory", required = false)
    private TestCategory testCategory;

    @Element(name = "Execution", required = false)
    private Execution execution;

    @Element(name = "TestMethod", required = false)
    private TestMethod testMethod;

    public UnitTest () {
    }

    public UnitTest(String name, String storage, String id, TestCategory testCategory, Execution execution, TestMethod testMethod) {
        this.name = name;
        this.storage = storage;
        this.id = id;
        this.testCategory = testCategory;
        this.execution = execution;
        this.testMethod = testMethod;
    }

    public String getName() {return name; }
    public void setName(String name) {this.name = name; }
    public String getId() {return id; }
    public void setId(String id) {this.id = id; }
    public String getStorage() { return storage; }
    public void setStorage(String storage) { this.storage = storage; }
    public TestCategory getTestCategory() { return testCategory; }
    public void setTestCategory(TestCategory testCategory) { this.testCategory = testCategory; }
    public Execution getExecution() {return execution; }
    public void setExecution(Execution execution){ this.execution = execution; }
    public TestMethod getTestMethod() {return testMethod; }
    public void setTestMethod(TestMethod testMethod){ this.testMethod = testMethod; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof UnitTest)) return false;

        UnitTest that = (UnitTest) o;

        if(name != null ? !name.equals(that.name) : that.name != null) return false;
        if(storage != null ? !storage.equals(that.id) : that.storage != null) return false;
        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(testCategory != null ? !testCategory.equals(that.testCategory) : that.testCategory != null) return false;
        if(execution != null ? !execution.equals(that.execution) : that.execution != null) return false;
        if(testMethod != null ? !testMethod.equals(that.testMethod) : that.testMethod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (storage != null ? storage.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (testCategory != null ? testCategory.hashCode() : 0);
        result = 31 * result + (execution != null ? execution.hashCode() : 0);
        result = 31 * result + (testMethod != null ? testMethod.hashCode() : 0);

        return result;
    }

}
