package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import org.simpleframework.xml.Text;

public class StackTrace {
    @Text(required = false)
    public String value;

    public StackTrace() {
    }

    public StackTrace(String value) {
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
        if (!(o instanceof StackTrace)) return false;

        StackTrace stackTrace = (StackTrace) o;

        if (value != null ? !value.equals(stackTrace.value) : stackTrace.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
