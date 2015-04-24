package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import org.simpleframework.xml.ElementList;
import com.tw.xunit.model.Error;


import java.util.List;

public class ErrorInfo {
    @ElementList(entry = "Message", inline = true, required = false)
    private List<Message> messageList;

    @ElementList(entry = "StackTrace", inline = true, required = false)
    private List<StackTrace> stackTraceList;

    public ErrorInfo() {
    }

    public  ErrorInfo(List<Message> messageList, List<StackTrace> stackTraceList) {
        this.messageList = messageList;
        this.stackTraceList = stackTraceList;
    }

    public List<Message> getMessageList() {return messageList;}

    public void setMessageList(List<Message> messageList) {this.messageList = messageList;}

    public List<StackTrace> getStackTraceList() {return stackTraceList;}

    public void setStackTraceList(List<StackTrace> stackTraceList) {this.stackTraceList = stackTraceList; }

    /* Methods to handle conversion to xunit */
    public Error getConverted_Error() {
        return new Error(null,this.messageList.toString(),this.stackTraceList.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorInfo)) return false;

        ErrorInfo errorInfo = (ErrorInfo) o;

        if (messageList != null ? !messageList.equals(errorInfo.messageList) : errorInfo.messageList != null) return false;
        if (stackTraceList != null ? !stackTraceList.equals(errorInfo.stackTraceList) : errorInfo.stackTraceList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageList != null ? messageList.hashCode():0;
        result = 31 * result + (stackTraceList != null ? stackTraceList.hashCode():0);
        return result;
    }
}
