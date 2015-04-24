package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class TestSettings {
    @Attribute(required = false)
    private String name;

    @Attribute(required = false)
    private String id;

    @ElementList(entry = "Execution", inline = true, required = false)
    private List<Execution> executions;

    @ElementList(entry = "Deployment", inline = true, required = false)
    private List<Deployment> deployments;

    public TestSettings() {
    }

    public TestSettings(String name, String id, List<Execution> executions, List<Deployment> deployments) {
        this.name = name;
        this.id = id;
        this.executions = executions;
        this.deployments = deployments;
    }

    public String getName() { return name; }
    public void setName(String name){ this.name = name; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public List<Execution> getExecutions() { return executions; }
    public void setExecutions(List<Execution> executions) { this.executions = executions; }
    public List<Deployment> getDeployments() { return deployments; }
    public void setDeployments(List<Deployment> deployments) { this.deployments = deployments; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof TestSettings)) return false;

        TestSettings that = (TestSettings) o;

        if(name != null ? !name.equals(that.name) : that.name != null) return false;
        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(executions != null ? !executions.equals(that.executions) : that.executions != null) return false;
        if(deployments != null ? !deployments.equals(that.deployments) : that.deployments != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (executions != null ? executions.hashCode() : 0);
        result = 31 * result + (deployments != null ? deployments.hashCode() : 0);

        return result;
    }
}
