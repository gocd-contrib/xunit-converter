package com.tw.xunit.converter.jsunit;

import com.tw.xunit.model.Properties;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "browserResult", strict = false)
public class BrowserResult {
    @Attribute(required = false)
    private double time;

    @Attribute(required = false)
    private String id;

    @ElementList(inline = true, required = false)
    private List<Properties> properties;

    @Element(name = "testCases", required = false)
    private TestCases testCases;

    public BrowserResult() {
    }

    public BrowserResult(double time, String id, List<Properties> properties, TestCases testCases) {
        this.time = time;
        this.id = id;
        this.properties = properties;
        this.testCases = testCases;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Properties> getProperties() {
        return properties;
    }

    public void setProperties(List<Properties> properties) {
        this.properties = properties;
    }

    public TestCases getTestCases() {
        return testCases;
    }

    public void setTestCases(TestCases testCases) {
        this.testCases = testCases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrowserResult)) return false;

        BrowserResult that = (BrowserResult) o;

        if (Double.compare(that.time, time) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) return false;
        if (testCases != null ? !testCases.equals(that.testCases) : that.testCases != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(time);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        result = 31 * result + (testCases != null ? testCases.hashCode() : 0);
        return result;
    }
}
