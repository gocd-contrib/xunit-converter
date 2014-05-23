package com.tw.xunit.model;

import org.simpleframework.xml.Attribute;

public class Property {
    @Attribute(required = false)
    private String name;

    @Attribute(required = false)
    private String value;

    public Property() {
    }

    public Property(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;

        Property property = (Property) o;

        if (name != null ? !name.equals(property.name) : property.name != null) return false;
        if (value != null ? !value.equals(property.value) : property.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
