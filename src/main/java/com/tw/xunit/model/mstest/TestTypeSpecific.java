package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */
public class TestTypeSpecific {

    public TestTypeSpecific(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof TestTypeSpecific)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
