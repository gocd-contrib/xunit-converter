package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class ResultSummary {
    @Attribute(required = false)
    private String outcome;

    @Element(name = "Counters", required = false)
    private Counters counters;

    @Element(name = "RunInfos", required = false)
    private RunInfos runInfos;


    public ResultSummary() {
    }

    public ResultSummary(String outcome, Counters counters, RunInfos runInfos) {
        this.outcome = outcome;
        this.counters = counters;
        this.runInfos = runInfos;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Counters getCounters() {
        return counters;
    }

    public void setCounters(Counters counters) {
        this.counters = counters;
    }

    public RunInfos getRunInfos() {
        return runInfos;
    }

    public void setRunInfos(RunInfos runInfos) {
        this.runInfos = runInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultSummary that = (ResultSummary) o;

        if (counters != null ? !counters.equals(that.counters) : that.counters != null) return false;
        if (outcome != null ? !outcome.equals(that.outcome) : that.outcome != null) return false;
        if (runInfos != null ? !runInfos.equals(that.runInfos) : that.runInfos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = outcome != null ? outcome.hashCode() : 0;
        result = 31 * result + (counters != null ? counters.hashCode() : 0);
        result = 31 * result + (runInfos != null ? runInfos.hashCode() : 0);
        return result;
    }
}
