package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */
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

    public String getCreation() {return creation; }
    public void setCreation(String creation) { this.creation = creation; }
    public String getQueuing() { return queuing; }
    public void setQueuing(String queuing) { this.queuing = queuing; }
    public String getStart() {return start; }
    public void setStart(String start) { this.start = start; }
    public String getFinish() { return finish; }
    public void setFinish(String finish) { this.finish = finish; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Times)) return false;

        Times that = (Times) o;

        if(creation != null ? !creation.equals(that.creation) : that.creation != null) return false;
        if(queuing != null ? !queuing.equals(that.queuing) : that.queuing != null) return false;
        if(start != null ? !start.equals(that.start) : that.start != null) return false;
        if(finish != null ? !finish.equals(that.finish) : that.finish != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = creation != null ? creation.hashCode() : 0;
        result = 31 * result + (queuing != null ? queuing.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (finish != null ? finish.hashCode() : 0);

        return result;
    }
}
