package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

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

    public UnitTest() {
    }

    public UnitTest(String name, String storage, String id, TestCategory testCategory, Execution execution, TestMethod testMethod) {
        this.name = name;
        this.storage = storage;
        this.id = id;
        this.testCategory = testCategory;
        this.execution = execution;
        this.testMethod = testMethod;
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

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public TestCategory getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(TestCategory testCategory) {
        this.testCategory = testCategory;
    }

    public Execution getExecution() {
        return execution;
    }

    public void setExecution(Execution execution) {
        this.execution = execution;
    }

    public TestMethod getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(TestMethod testMethod) {
        this.testMethod = testMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitTest unitTest = (UnitTest) o;

        if (execution != null ? !execution.equals(unitTest.execution) : unitTest.execution != null) return false;
        if (id != null ? !id.equals(unitTest.id) : unitTest.id != null) return false;
        if (name != null ? !name.equals(unitTest.name) : unitTest.name != null) return false;
        if (storage != null ? !storage.equals(unitTest.storage) : unitTest.storage != null) return false;
        if (testCategory != null ? !testCategory.equals(unitTest.testCategory) : unitTest.testCategory != null)
            return false;
        if (testMethod != null ? !testMethod.equals(unitTest.testMethod) : unitTest.testMethod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (storage != null ? storage.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (testCategory != null ? testCategory.hashCode() : 0);
        result = 31 * result + (execution != null ? execution.hashCode() : 0);
        result = 31 * result + (testMethod != null ? testMethod.hashCode() : 0);
        return result;
    }
}
