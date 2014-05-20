package com.thoughtworks.go.xunit.model;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class Properties {
    @ElementList(entry = "property", inline = true, required = false)
    private List<Property> properties;

    public Properties() {
    }

    public Properties(List<Property> properties) {
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Properties)) return false;

        Properties that = (Properties) o;

        if (properties != null ? !properties.equals(that.properties) : that.properties != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return properties != null ? properties.hashCode() : 0;
    }
}
