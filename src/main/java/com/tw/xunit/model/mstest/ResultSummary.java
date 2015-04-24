package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class ResultSummary {
    @Attribute(required = false)
    private String outcome;

    @ElementList(entry = "Counters", inline = true, required = false)
    private List<Counters> countersList;

    public ResultSummary() {
    }

    public ResultSummary(String outcome, List<Counters> counters) {
        this.outcome = outcome;
        this.countersList = counters;
    }

    public String getOutcome() { return outcome; }
    public void setOutcome(String outcome) { this.outcome = outcome; }
    public List<Counters> getCountersList() {return countersList; }
    public void setCountersList(List<Counters> countersList) {this.countersList = countersList; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof ResultSummary)) return false;

        ResultSummary that = (ResultSummary) o;

        if(outcome != null ? !outcome.equals(that.outcome) : that.outcome != null) return false;
        if(countersList != null ? !countersList.equals(that.countersList) : that.countersList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int results;
        results = outcome != null ? outcome.hashCode() : 0;
        results = 31 * results + (countersList != null ? countersList.hashCode() : 0);

        return results;
    }
}
