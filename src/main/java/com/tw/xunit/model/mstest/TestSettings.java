package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class TestSettings {
    @Attribute(required = false)
    private String name;

    @Attribute(required = false)
    private String id;

    @Element(name = "Execution", required = false)
    private Execution execution;

    @Element(name = "Deployment", required = false)
    private Deployment deployment;

    public TestSettings() {
    }

    public TestSettings(String name, String id, Execution execution, Deployment deployment) {
        this.name = name;
        this.id = id;
        this.execution = execution;
        this.deployment = deployment;
    }

    public String getName() { return name; }
    public void setName(String name){ this.name = name; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Execution getExecution() { return execution; }
    public void setExecution(Execution execution) { this.execution = execution; }
    public Deployment getDeployment() { return deployment; }
    public void setDeployment(Deployment deployment) { this.deployment = deployment; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof TestSettings)) return false;

        TestSettings that = (TestSettings) o;

        if(name != null ? !name.equals(that.name) : that.name != null) return false;
        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(execution != null ? !execution.equals(that.execution) : that.execution != null) return false;
        if(deployment != null ? !deployment.equals(that.deployment) : that.deployment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (execution != null ? execution.hashCode() : 0);
        result = 31 * result + (deployment != null ? deployment.hashCode() : 0);

        return result;
    }
}
