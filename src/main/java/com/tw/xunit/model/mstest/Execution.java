package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class Execution {
    @Attribute(required = false)
    private String id;

    @ElementList(entry = "TestTypeSpecific", inline = true, required = false)
    private List<TestTypeSpecific> testTypeList;

    @ElementList(entry = "AgentRule", inline = true, required = false)
    private List<AgentRule> agentRules;

    public Execution() {
    }

    public Execution(String id, List<TestTypeSpecific> testTypeList, List<AgentRule> agentRules) {
        this.id = id;
        this.testTypeList = testTypeList;
        this.agentRules = agentRules;
    }

    public String getId(){ return id; }
    public void setId(String id) {this.id = id; }
    public List<TestTypeSpecific> getTestTypeList() {return testTypeList; }
    public void setTestTypeList(List<TestTypeSpecific> testTypeList) { this.testTypeList = testTypeList; }
    public List<AgentRule> getAgentRules() {return agentRules; }
    public void setAgentRules(List<AgentRule> agentRules) {this.agentRules = agentRules; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Execution)) return false;

        Execution that = (Execution) o;

        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(testTypeList != null ? !testTypeList.equals(that.testTypeList) : that.testTypeList != null) return false;
        if(agentRules != null ? !agentRules.equals(that.agentRules) : that.agentRules != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (testTypeList != null ? testTypeList.hashCode() : 0);
        result = 31 * result + (agentRules != null ? agentRules.hashCode() : 0 );

        return result;
    }
}
