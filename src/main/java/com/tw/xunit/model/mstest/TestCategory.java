package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.ElementList;

import java.util.List;

public class TestCategory {
    @ElementList(entry = "TestCategoryItem", inline = true, required = false)
    private List<TestCategoryItem> testCategoryItemList;

    public TestCategory() {
    }

    public TestCategory(List<TestCategoryItem> testCategoryItemList) {
        this.testCategoryItemList = testCategoryItemList;
    }

    public List<TestCategoryItem> getTestCategoryItemList() { return testCategoryItemList; }
    public void setTestCategoryItemList(List<TestCategoryItem> testCategoryItemList) { this.testCategoryItemList = testCategoryItemList; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof TestCategory)) return false;

        TestCategory that = (TestCategory) o;

        if(testCategoryItemList != null ? !testCategoryItemList.equals(that.testCategoryItemList) : that.testCategoryItemList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return testCategoryItemList != null ? testCategoryItemList.hashCode() : 0;
    }
}
