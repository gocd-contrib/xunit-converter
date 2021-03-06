package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import com.tw.xunit.model.SysOut;
import org.simpleframework.xml.Text;

public class DebugTrace {
    @Text(required = false)
    private String value;

    public DebugTrace() {
    }

    public DebugTrace(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /* Methods to handle conversion to xunit */
    public SysOut getSysout() {
        return new SysOut(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DebugTrace that = (DebugTrace) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
