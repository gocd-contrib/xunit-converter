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
    
    public Counters(Integer total, Integer executed, Integer passed, Integer error, Integer failed, Integer timeout, Integer aborted, Integer inconclusive, Integer passedButRunAborted, Integer notRunnable, Integer notExecuted, Integer disconnected, Integer warning, Integer completed, Integer inProgress, Integer pending ) {
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
        if(!(o instanceof Counters)) return false;

        Counters that = (Counters) o;

        if(Integer.compare(that.total,total) != 0) return false;
        if(Integer.compare(that.executed,executed) != 0) return false;
        if(Integer.compare(that.passed,passed) != 0) return false;
        if(Integer.compare(that.error,error) != 0) return false;
        if(Integer.compare(that.failed,failed) != 0) return false;
        if(Integer.compare(that.timeout,timeout) != 0) return false;
        if(Integer.compare(that.aborted,aborted) != 0) return false;
        if(Integer.compare(that.inconclusive,inconclusive) != 0) return false;
        if(Integer.compare(that.passedButRunAborted,passedButRunAborted) != 0) return false;
        if(Integer.compare(that.notRunnable,notRunnable) != 0) return false;
        if(Integer.compare(that.notExecuted,notExecuted) != 0) return false;
        if(Integer.compare(that.disconnected,disconnected) != 0) return false;
        if(Integer.compare(that.warning,warning) != 0) return false;
        if(Integer.compare(that.completed,completed) != 0) return false;
        if(Integer.compare(that.inProgress,inProgress) != 0) return false;
        if(Integer.compare(that.pending,pending) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = total.hashCode();
        result = 31 * result + executed.hashCode();
        result = 31 * result + passed.hashCode();
        result = 31 * result + error.hashCode();
        result = 31 * result + failed.hashCode();
        result = 31 * result + timeout.hashCode();
        result = 31 * result + aborted.hashCode();
        result = 31 * result + inconclusive.hashCode();
        result = 31 * result + passedButRunAborted.hashCode();
        result = 31 * result + notRunnable.hashCode();
        result = 31 * result + notExecuted.hashCode();
        result = 31 * result + disconnected.hashCode();
        result = 31 * result + warning.hashCode();
        result = 31 * result + completed.hashCode();
        result = 31 * result + inProgress.hashCode();
        result = 31 * result + pending.hashCode();

        return result;
    }
}
