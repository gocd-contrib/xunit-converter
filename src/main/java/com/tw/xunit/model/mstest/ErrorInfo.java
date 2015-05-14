package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import com.tw.xunit.model.Error;
import org.simpleframework.xml.Element;

public class ErrorInfo {
    @Element(name = "Message", required = false)
    private Message message;

    @Element(name = "StackTrace", required = false)
    private StackTrace stackTrace;

    public ErrorInfo() {
    }

    public ErrorInfo(Message message, StackTrace stackTrace) {
        this.message = message;
        this.stackTrace = stackTrace;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public StackTrace getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(StackTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

    /* Methods to handle conversion to xunit */
    public Error getError() {
        return new Error(null, this.message.getMessage(), this.stackTrace.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorInfo errorInfo = (ErrorInfo) o;

        if (message != null ? !message.equals(errorInfo.message) : errorInfo.message != null) return false;
        if (stackTrace != null ? !stackTrace.equals(errorInfo.stackTrace) : errorInfo.stackTrace != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (stackTrace != null ? stackTrace.hashCode() : 0);
        return result;
    }
}
