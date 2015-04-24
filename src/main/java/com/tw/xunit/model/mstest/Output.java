package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import com.tw.xunit.model.*;
import com.tw.xunit.model.Error;
import org.simpleframework.xml.ElementList;

import java.util.ArrayList;
import java.util.List;

public class Output {
    @ElementList(entry = "DebugTrace", inline = true, required = false)
    private List<DebugTrace> debugTraceList;

    @ElementList(entry = "ErrorInfo", inline = true, required = false)
    private List<ErrorInfo> errorInfoList;

    public Output() {
    }

    public  Output(List<DebugTrace> debugTraceList, List<ErrorInfo> errorInfoList) {
        this.debugTraceList = debugTraceList;
        this.errorInfoList = errorInfoList;
    }

    public List<DebugTrace> getDebugTraceList() {return debugTraceList;}

    public void setDebugTraceList(List<DebugTrace> debugTraceList) {this.debugTraceList = debugTraceList;}

    public List<ErrorInfo> getErrorInfoList() {return errorInfoList;}

    public void setErrorInfoList(List<ErrorInfo> errorInfoList) {this.errorInfoList = errorInfoList; }

    /* Methods to handle conversion to xunit */
    public List<SysOut> getConverted_sysout() {
        ArrayList<SysOut> sysOuts = new ArrayList<SysOut>();

        for (int i = 0; i < debugTraceList.size(); i++) {
            sysOuts.add(debugTraceList.get(i).getConverted_SysOut());
        }

        return sysOuts;
    }

    public List<Error> getConverted_error() {
        ArrayList<Error> errors = new ArrayList<Error>();

        for (int i = 0; i< errorInfoList.size(); i++) {
            errors.add(errorInfoList.get(i).getConverted_Error());
        }

        return  errors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Output)) return false;

        Output output = (Output) o;

        if (debugTraceList != null ? !debugTraceList.equals(output.debugTraceList) : output.debugTraceList != null) return false;
        if (errorInfoList != null ? !errorInfoList.equals(output.errorInfoList) : output.errorInfoList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = debugTraceList != null ? debugTraceList.hashCode():0;
        result = 31 * result + (errorInfoList != null ? errorInfoList.hashCode():0);
        return result;
    }
}
