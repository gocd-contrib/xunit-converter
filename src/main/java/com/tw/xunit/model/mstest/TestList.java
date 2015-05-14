package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */
import org.simpleframework.xml.Attribute;

import java.security.PublicKey;

public class TestList {
    @Attribute(required = false)
    private String name;

    @Attribute(required = false)
    private String id;

    public TestList() {
    }

    public TestList(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getName() {return name; }
    public void setName(String name) {this.name = name; }
    public String getId() {return id; }
    public void setId(String id) {this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof TestList)) return false;

        TestList that = (TestList) o;

        if(name != null ? !name.equals(that.name) : that.name != null) return false;
        if(id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);

        return result;
    }
}
