package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import org.simpleframework.xml.Element;

public class Output {
    @Element(name = "DebugTrace", required = false)
    private DebugTrace debugTrace;

    @Element(name = "ErrorInfo", required = false)
    private ErrorInfo errorInfo;

    public Output() {
    }

    public Output(DebugTrace debugTrace, ErrorInfo errorInfo) {
        this.debugTrace = debugTrace;
        this.errorInfo = errorInfo;
    }

    public DebugTrace getDebugTrace() {
        return debugTrace;
    }

    public void setDebugTrace(DebugTrace debugTrace) {
        this.debugTrace = debugTrace;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Output output = (Output) o;

        if (debugTrace != null ? !debugTrace.equals(output.debugTrace) : output.debugTrace != null) return false;
        if (errorInfo != null ? !errorInfo.equals(output.errorInfo) : output.errorInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = debugTrace != null ? debugTrace.hashCode() : 0;
        result = 31 * result + (errorInfo != null ? errorInfo.hashCode() : 0);
        return result;
    }
}
