package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 5/13/2015.
 */

public class Text {

    @org.simpleframework.xml.Text(required = false)
    public String value;

    public Text() {
    }

    public Text(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        if (value != null ? !value.equals(text.value) : text.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
