package com.thoughtworks.xunit.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "testsuites", strict = false)
public class TestSuites {
    @Attribute(required = false)
    private String name;

    @Attribute(required = false)
    private double time;

    @Attribute(required = false)
    private int tests;

    @Attribute(required = false)
    private int failures;

    @Attribute(required = false)
    private int errors;

    @Attribute(required = false)
    private int disabled;

    @ElementList(entry = "testsuite", inline = true, required = false)
    private List<TestSuite> testSuites;

    public TestSuites() {
    }

    public TestSuites(String name, double time, int tests, int failures, int errors, int disabled, List<TestSuite> testSuites) {
        this.name = name;
        this.time = time;
        this.tests = tests;
        this.failures = failures;
        this.errors = errors;
        this.disabled = disabled;
        this.testSuites = testSuites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public int getFailures() {
        return failures;
    }

    public void setFailures(int failures) {
        this.failures = failures;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    public List<TestSuite> getTestSuites() {
        return testSuites;
    }

    public void setTestSuites(List<TestSuite> testSuites) {
        this.testSuites = testSuites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestSuites)) return false;

        TestSuites that = (TestSuites) o;

        if (disabled != that.disabled) return false;
        if (errors != that.errors) return false;
        if (failures != that.failures) return false;
        if (tests != that.tests) return false;
        if (Double.compare(that.time, time) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (testSuites != null ? !testSuites.equals(that.testSuites) : that.testSuites != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(time);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + tests;
        result = 31 * result + failures;
        result = 31 * result + errors;
        result = 31 * result + disabled;
        result = 31 * result + (testSuites != null ? testSuites.hashCode() : 0);
        return result;
    }
}
