package com.thoughtworks.go.xunit.model;

import org.simpleframework.xml.Text;

public class SysOut {
    @Text(required = false)
    public String value;

    public SysOut() {
    }

    public SysOut(String value) {
        this.value = value;
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
        if (!(o instanceof SysOut)) return false;

        SysOut sysOut = (SysOut) o;

        if (value != null ? !value.equals(sysOut.value) : sysOut.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
