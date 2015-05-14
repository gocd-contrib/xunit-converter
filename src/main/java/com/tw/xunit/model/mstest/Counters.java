package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;

public class Counters {
    @Attribute(required = false)
    public Integer total;

    @Attribute(required = false)
    public Integer executed;

    @Attribute(required = false)
    public Integer passed;

    @Attribute(required = false)
    public Integer error;

    @Attribute(required = false)
    public Integer failed;

    @Attribute(required = false)
    public Integer timeout;

    @Attribute(required = false)
    public Integer aborted;

    @Attribute(required = false)
    public Integer inconclusive;

    @Attribute(required = false)
    public Integer passedButRunAborted;

    @Attribute(required = false)
    public Integer notRunnable;

    @Attribute(required = false)
    public Integer notExecuted;

    @Attribute(required = false)
    public Integer disconnected;

    @Attribute(required = false)
    public Integer warning;

    @Attribute(required = false)
    public Integer completed;

    @Attribute(required = false)
    public Integer inProgress;

    @Attribute(required = false)
    public Integer pending;

    public Counters() {
    }

    public Counters(Integer total, Integer executed, Integer passed, Integer error, Integer failed, Integer timeout, Integer aborted, Integer inconclusive, Integer passedButRunAborted, Integer notRunnable, Integer notExecuted, Integer disconnected, Integer warning, Integer completed, Integer inProgress, Integer pending) {
        this.total = total;
        this.executed = executed;
        this.passed = passed;
        this.error = error;
        this.failed = failed;
        this.timeout = timeout;
        this.aborted = aborted;
        this.inconclusive = inconclusive;
        this.passedButRunAborted = passedButRunAborted;
        this.notRunnable = notRunnable;
        this.notExecuted = notExecuted;
        this.disconnected = disconnected;
        this.warning = warning;
        this.completed = completed;
        this.inProgress = inProgress;
        this.pending = pending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Counters counters = (Counters) o;

        if (aborted != null ? !aborted.equals(counters.aborted) : counters.aborted != null) return false;
        if (completed != null ? !completed.equals(counters.completed) : counters.completed != null) return false;
        if (disconnected != null ? !disconnected.equals(counters.disconnected) : counters.disconnected != null)
            return false;
        if (error != null ? !error.equals(counters.error) : counters.error != null) return false;
        if (executed != null ? !executed.equals(counters.executed) : counters.executed != null) return false;
        if (failed != null ? !failed.equals(counters.failed) : counters.failed != null) return false;
        if (inProgress != null ? !inProgress.equals(counters.inProgress) : counters.inProgress != null) return false;
        if (inconclusive != null ? !inconclusive.equals(counters.inconclusive) : counters.inconclusive != null)
            return false;
        if (notExecuted != null ? !notExecuted.equals(counters.notExecuted) : counters.notExecuted != null)
            return false;
        if (notRunnable != null ? !notRunnable.equals(counters.notRunnable) : counters.notRunnable != null)
            return false;
        if (passed != null ? !passed.equals(counters.passed) : counters.passed != null) return false;
        if (passedButRunAborted != null ? !passedButRunAborted.equals(counters.passedButRunAborted) : counters.passedButRunAborted != null)
            return false;
        if (pending != null ? !pending.equals(counters.pending) : counters.pending != null) return false;
        if (timeout != null ? !timeout.equals(counters.timeout) : counters.timeout != null) return false;
        if (total != null ? !total.equals(counters.total) : counters.total != null) return false;
        if (warning != null ? !warning.equals(counters.warning) : counters.warning != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = total != null ? total.hashCode() : 0;
        result = 31 * result + (executed != null ? executed.hashCode() : 0);
        result = 31 * result + (passed != null ? passed.hashCode() : 0);
        result = 31 * result + (error != null ? error.hashCode() : 0);
        result = 31 * result + (failed != null ? failed.hashCode() : 0);
        result = 31 * result + (timeout != null ? timeout.hashCode() : 0);
        result = 31 * result + (aborted != null ? aborted.hashCode() : 0);
        result = 31 * result + (inconclusive != null ? inconclusive.hashCode() : 0);
        result = 31 * result + (passedButRunAborted != null ? passedButRunAborted.hashCode() : 0);
        result = 31 * result + (notRunnable != null ? notRunnable.hashCode() : 0);
        result = 31 * result + (notExecuted != null ? notExecuted.hashCode() : 0);
        result = 31 * result + (disconnected != null ? disconnected.hashCode() : 0);
        result = 31 * result + (warning != null ? warning.hashCode() : 0);
        result = 31 * result + (completed != null ? completed.hashCode() : 0);
        result = 31 * result + (inProgress != null ? inProgress.hashCode() : 0);
        result = 31 * result + (pending != null ? pending.hashCode() : 0);
        return result;
    }
}
