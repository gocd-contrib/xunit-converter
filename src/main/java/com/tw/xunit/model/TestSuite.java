package com.tw.xunit.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "testsuite", strict = false)
public class TestSuite {
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

    @Attribute(required = false)
    private int skipped;

    @Attribute(required = false)
    private String timestamp;

    @Attribute(required = false)
    private String hostname;

    @Attribute(required = false)
    private String id;

    @Attribute(name = "package", required = false)
    private String _package;

    @Attribute(required = false)
    private String assertions;

    @Attribute(required = false)
    private String file;

    @ElementList(inline = true, required = false)
    private List<Properties> properties;

    @ElementList(entry = "testcase", inline = true, required = false)
    private List<TestCase> testCases;

    @ElementList(entry = "system-out", inline = true, required = false)
    private List<SysOut> sysOuts;

    @ElementList(entry = "system-err", inline = true, required = false)
    private List<SysErr> sysErrs;

    public TestSuite() {
    }

    public TestSuite(String name, double time, int tests, int failures, int errors, int disabled, int skipped, String timestamp, String hostname, String id, String _package, String assertions, String file, List<Properties> properties, List<TestCase> testCases, List<SysOut> sysOuts, List<SysErr> sysErrs) {
        this.name = name;
        this.time = time;
        this.tests = tests;
        this.failures = failures;
        this.errors = errors;
        this.disabled = disabled;
        this.skipped = skipped;
        this.timestamp = timestamp;
        this.hostname = hostname;
        this.id = id;
        this._package = _package;
        this.assertions = assertions;
        this.file = file;
        this.properties = properties;
        this.testCases = testCases;
        this.sysOuts = sysOuts;
        this.sysErrs = sysErrs;
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

    public int getSkipped() {
        return skipped;
    }

    public void setSkipped(int skipped) {
        this.skipped = skipped;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get_package() {
        return _package;
    }

    public void set_package(String _package) {
        this._package = _package;
    }

    public String getAssertions() {
        return assertions;
    }

    public void setAssertions(String assertions) {
        this.assertions = assertions;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<Properties> getProperties() {
        return properties;
    }

    public void setProperties(List<Properties> properties) {
        this.properties = properties;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    public List<SysOut> getSysOuts() {
        return sysOuts;
    }

    public void setSysOuts(List<SysOut> sysOuts) {
        this.sysOuts = sysOuts;
    }

    public List<SysErr> getSysErrs() {
        return sysErrs;
    }

    public void setSysErrs(List<SysErr> sysErrs) {
        this.sysErrs = sysErrs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestSuite)) return false;

        TestSuite testSuite = (TestSuite) o;

        if (disabled != testSuite.disabled) return false;
        if (errors != testSuite.errors) return false;
        if (failures != testSuite.failures) return false;
        if (skipped != testSuite.skipped) return false;
        if (tests != testSuite.tests) return false;
        if (Double.compare(testSuite.time, time) != 0) return false;
        if (_package != null ? !_package.equals(testSuite._package) : testSuite._package != null) return false;
        if (assertions != null ? !assertions.equals(testSuite.assertions) : testSuite.assertions != null) return false;
        if (file != null ? !file.equals(testSuite.file) : testSuite.file != null) return false;
        if (hostname != null ? !hostname.equals(testSuite.hostname) : testSuite.hostname != null) return false;
        if (id != null ? !id.equals(testSuite.id) : testSuite.id != null) return false;
        if (name != null ? !name.equals(testSuite.name) : testSuite.name != null) return false;
        if (properties != null ? !properties.equals(testSuite.properties) : testSuite.properties != null) return false;
        if (sysErrs != null ? !sysErrs.equals(testSuite.sysErrs) : testSuite.sysErrs != null) return false;
        if (sysOuts != null ? !sysOuts.equals(testSuite.sysOuts) : testSuite.sysOuts != null) return false;
        if (testCases != null ? !testCases.equals(testSuite.testCases) : testSuite.testCases != null) return false;
        if (timestamp != null ? !timestamp.equals(testSuite.timestamp) : testSuite.timestamp != null) return false;

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
        result = 31 * result + skipped;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (hostname != null ? hostname.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (_package != null ? _package.hashCode() : 0);
        result = 31 * result + (assertions != null ? assertions.hashCode() : 0);
        result = 31 * result + (file != null ? file.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        result = 31 * result + (testCases != null ? testCases.hashCode() : 0);
        result = 31 * result + (sysOuts != null ? sysOuts.hashCode() : 0);
        result = 31 * result + (sysErrs != null ? sysErrs.hashCode() : 0);
        return result;
    }
}
