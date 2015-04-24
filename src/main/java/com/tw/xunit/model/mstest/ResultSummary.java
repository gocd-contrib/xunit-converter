package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.List;

public class ResultSummary {
    @Attribute(required = false)
    private String outcome;

    @Element(name = "Counters", required = false)
    private Counters counters;

    public ResultSummary() {
    }

    public ResultSummary(String outcome, Counters counters) {
        this.outcome = outcome;
        this.counters = counters;
    }

    public String getOutcome() { return outcome; }
    public void setOutcome(String outcome) { this.outcome = outcome; }
    public Counters getCounters() {return counters; }
    public void setCounters(Counters counters) {this.counters = counters; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof ResultSummary)) return false;

        ResultSummary that = (ResultSummary) o;

        if(outcome != null ? !outcome.equals(that.outcome) : that.outcome != null) return false;
        if(counters != null ? !counters.equals(that.counters) : that.counters != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int results;
        results = outcome != null ? outcome.hashCode() : 0;
        results = 31 * results + (counters != null ? counters.hashCode() : 0);

        return results;
    }
}
