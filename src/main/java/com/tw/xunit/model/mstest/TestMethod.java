package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;

public class TestMethod {
    @Attribute(required = false)
    private String codeBase;

    @Attribute(required = false)
    private String adapterTypeName;

    @Attribute(required = false)
    private String className;

    @Attribute(required = false)
    private String name;

    public TestMethod() {
    }

    public TestMethod(String codeBase, String adapterTypeName, String className, String name) {
        this.codeBase = codeBase;
        this.adapterTypeName = adapterTypeName;
        this.className = className;
        this.name = name;
    }

    public String getCodeBase() {return codeBase; }
    public void setCodeBase(String codeBase) {this.codeBase = codeBase; }
    public String getAdapterTypeName() {return  adapterTypeName;}
    public void setAdapterTypeName(String adapterTypeName) {this.adapterTypeName = adapterTypeName;}
    public String getClassName() {return className; }
    public void setClassName(String className) {this.className = className; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getClassNamePretty() {
        return className.substring(0,className.indexOf(","));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof TestMethod)) return false;

        TestMethod that = (TestMethod) o;

        if(codeBase != null ? !codeBase.equals(that.codeBase) : that.codeBase != null) return false;
        if(adapterTypeName != null ? !adapterTypeName.equals(that.adapterTypeName) : that.adapterTypeName != null) return false;
        if(className != null ? !className.equals(that.className) : that.className != null) return false;
        if(name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = codeBase != null ? codeBase.hashCode() : 0;
        result = 31 * result + (adapterTypeName != null ? adapterTypeName.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }
}
