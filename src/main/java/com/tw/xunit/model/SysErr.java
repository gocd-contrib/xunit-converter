package com.tw.xunit.model;

import org.simpleframework.xml.Text;

public class SysErr {
    @Text(required = false)
    public String value;

    public SysErr() {
    }

    public SysErr(String value) {
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
        if (!(o instanceof SysErr)) return false;

        SysErr sysErr = (SysErr) o;

        if (value != null ? !value.equals(sysErr.value) : sysErr.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
