package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 5/13/2015.
 */

import org.simpleframework.xml.ElementList;

import java.util.List;

public class RunInfos {
    @ElementList(entry = "RunInfo", inline = true, required = false)
    private List<RunInfo> runInfoList;

    public RunInfos() {
    }

    public RunInfos(List<RunInfo> runInfoList) {
        this.runInfoList = runInfoList;
    }

    public List<RunInfo> getRunInfoList() {
        return runInfoList;
    }

    public void setRunInfoList(List<RunInfo> runInfoList) {
        this.runInfoList = runInfoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RunInfos runInfos = (RunInfos) o;

        if (runInfoList != null ? !runInfoList.equals(runInfos.runInfoList) : runInfos.runInfoList != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return runInfoList != null ? runInfoList.hashCode() : 0;
    }
}
