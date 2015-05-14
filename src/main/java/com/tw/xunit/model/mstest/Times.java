package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import com.tw.xunit.converter.mstest.ConversionHelpers;
import org.simpleframework.xml.Attribute;

public class Times {
    @Attribute(required = false)
    private String creation;

    @Attribute(required = false)
    private String queuing;

    @Attribute(required = false)
    private String start;

    @Attribute(required = false)
    private String finish;

    public Times() {
    }

    public Times(String creation, String queuing, String start, String finish) {
        this.creation = creation;
        this.queuing = queuing;
        this.start = start;
        this.finish = finish;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public String getQueuing() {
        return queuing;
    }

    public void setQueuing(String queuing) {
        this.queuing = queuing;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getCreation_pretty() {
        return ConversionHelpers.stringDateFormatter(creation) != null ? ConversionHelpers.stringDateFormatter(creation) : creation;
    }

    public String getStart_pretty() {
        return ConversionHelpers.stringDateFormatter(start) != null ? ConversionHelpers.stringDateFormatter(start) : start;
    }

    public String getFinish_pretty() {
        return ConversionHelpers.stringDateFormatter(finish) != null ? ConversionHelpers.stringDateFormatter(finish) : finish;
    }

    public String getQueueing_pretty() {
        return ConversionHelpers.stringDateFormatter(queuing) != null ? ConversionHelpers.stringDateFormatter(queuing) : queuing;
    }

    public double getTotalTime() {
        return ConversionHelpers.getDateDifference(start, finish);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Times times = (Times) o;

        if (creation != null ? !creation.equals(times.creation) : times.creation != null) return false;
        if (finish != null ? !finish.equals(times.finish) : times.finish != null) return false;
        if (queuing != null ? !queuing.equals(times.queuing) : times.queuing != null) return false;
        if (start != null ? !start.equals(times.start) : times.start != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = creation != null ? creation.hashCode() : 0;
        result = 31 * result + (queuing != null ? queuing.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (finish != null ? finish.hashCode() : 0);
        return result;
    }
}
