package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;

public class TestCategoryItem {
    @Attribute(required = false)
    private String TestCategory;

    public TestCategoryItem() {
    }

    public TestCategoryItem(String TestCategory) {
        this.TestCategory = TestCategory;
    }

    public String getTestCategory() {
        return TestCategory;
    }

    public void setTestCategory(String TestCategory) {
        this.TestCategory = TestCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestCategoryItem that = (TestCategoryItem) o;

        if (TestCategory != null ? !TestCategory.equals(that.TestCategory) : that.TestCategory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return TestCategory != null ? TestCategory.hashCode() : 0;
    }
}
