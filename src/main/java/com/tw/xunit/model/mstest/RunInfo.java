package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 5/13/2015.
 */

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class RunInfo {
    @Attribute(required = false)
    private String computerName;

    @Attribute(required = false)
    private String outcome;

    @Attribute(required = false)
    private String timestamp;

    @Element(name = "Text", required = false)
    private Text text;

    public RunInfo() {
    }

    public RunInfo(String computerName, String outcome, String timestamp, Text text){
        this.computerName = computerName;
        this.outcome = outcome;
        this.timestamp = timestamp;
        this.text = text;
    }

    public String getComputerName() { return computerName; }
    public void setComputerName(String computerName) { this.computerName = computerName; }
    public String getOutcome() { return outcome; }
    public void setOutcome(String outcome) { this.outcome = outcome; }
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public Text getText() { return text; }
    public void setText(Text text) { this.text = text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof RunInfo)) return false;

        RunInfo that = (RunInfo) o;

        if(computerName != null ? !computerName.equals(that.computerName) : that.computerName != null) return false;
        if(outcome != null ? !outcome.equals(that.outcome) : that.outcome != null) return false;
        if(timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if(text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = computerName != null ? computerName.hashCode() : 0;
        result = 31 * result + (outcome != null ? outcome.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);

        return result;
    }

}
