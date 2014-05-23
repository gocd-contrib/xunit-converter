package com.thoughtworks.xunit.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class TestCase {
    @Attribute(required = false)
    private String name;

    @Attribute(required = false)
    private double time;

    @Attribute(name = "classname", required = false)
    private String className;

    @Attribute(required = false)
    private String status;

    @Attribute(name = "class", required = false)
    private String klass;

    @Attribute(required = false)
    private String file;

    @Attribute(required = false)
    private String line;

    @Attribute(required = false)
    private String assertions;

    @ElementList(entry = "failure", inline = true, required = false)
    private List<Failure> failureTests;

    @ElementList(entry = "error", inline = true, required = false)
    private List<Error> errorTests;

    @ElementList(entry = "skipped", inline = true, required = false)
    private List<Skipped> skipTests;

    @ElementList(entry = "system-out", inline = true, required = false)
    private List<SysOut> sysOuts;

    @ElementList(entry = "system-err", inline = true, required = false)
    private List<SysErr> sysErrs;

    public TestCase() {
    }

    public TestCase(String name, double time, String className, String status, String klass, String file, String line, String assertions, List<Failure> failureTests, List<Error> errorTests, List<Skipped> skipTests, List<SysOut> sysOuts, List<SysErr> sysErrs) {
        this.name = name;
        this.time = time;
        this.className = className;
        this.status = status;
        this.klass = klass;
        this.file = file;
        this.line = line;
        this.assertions = assertions;
        this.failureTests = failureTests;
        this.errorTests = errorTests;
        this.skipTests = skipTests;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getAssertions() {
        return assertions;
    }

    public void setAssertions(String assertions) {
        this.assertions = assertions;
    }

    public List<Failure> getFailureTests() {
        return failureTests;
    }

    public void setFailureTests(List<Failure> failureTests) {
        this.failureTests = failureTests;
    }

    public List<Error> getErrorTests() {
        return errorTests;
    }

    public void setErrorTests(List<Error> errorTests) {
        this.errorTests = errorTests;
    }

    public List<Skipped> getSkipTests() {
        return skipTests;
    }

    public void setSkipTests(List<Skipped> skipTests) {
        this.skipTests = skipTests;
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
        if (!(o instanceof TestCase)) return false;

        TestCase testCase = (TestCase) o;

        if (Double.compare(testCase.time, time) != 0) return false;
        if (assertions != null ? !assertions.equals(testCase.assertions) : testCase.assertions != null) return false;
        if (className != null ? !className.equals(testCase.className) : testCase.className != null) return false;
        if (errorTests != null ? !errorTests.equals(testCase.errorTests) : testCase.errorTests != null) return false;
        if (failureTests != null ? !failureTests.equals(testCase.failureTests) : testCase.failureTests != null)
            return false;
        if (file != null ? !file.equals(testCase.file) : testCase.file != null) return false;
        if (klass != null ? !klass.equals(testCase.klass) : testCase.klass != null) return false;
        if (line != null ? !line.equals(testCase.line) : testCase.line != null) return false;
        if (name != null ? !name.equals(testCase.name) : testCase.name != null) return false;
        if (skipTests != null ? !skipTests.equals(testCase.skipTests) : testCase.skipTests != null) return false;
        if (status != null ? !status.equals(testCase.status) : testCase.status != null) return false;
        if (sysErrs != null ? !sysErrs.equals(testCase.sysErrs) : testCase.sysErrs != null) return false;
        if (sysOuts != null ? !sysOuts.equals(testCase.sysOuts) : testCase.sysOuts != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(time);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (klass != null ? klass.hashCode() : 0);
        result = 31 * result + (file != null ? file.hashCode() : 0);
        result = 31 * result + (line != null ? line.hashCode() : 0);
        result = 31 * result + (assertions != null ? assertions.hashCode() : 0);
        result = 31 * result + (failureTests != null ? failureTests.hashCode() : 0);
        result = 31 * result + (errorTests != null ? errorTests.hashCode() : 0);
        result = 31 * result + (skipTests != null ? skipTests.hashCode() : 0);
        result = 31 * result + (sysOuts != null ? sysOuts.hashCode() : 0);
        result = 31 * result + (sysErrs != null ? sysErrs.hashCode() : 0);
        return result;
    }
}
