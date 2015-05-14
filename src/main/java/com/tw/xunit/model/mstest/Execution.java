package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Execution {
    @Attribute(required = false)
    private String id;

    @Element(name = "TestTypeSpecific", required = false)
    private TestTypeSpecific testTypeSpecific;

    @Element(name = "AgentRule", required = false)
    private AgentRule agentRule;

    public Execution() {
    }

    public Execution(String id, TestTypeSpecific testTypeSpecific, AgentRule agentRule) {
        this.id = id;
        this.testTypeSpecific = testTypeSpecific;
        this.agentRule = agentRule;
    }

    public String getId(){ return id; }
    public void setId(String id) {this.id = id; }
    public TestTypeSpecific getTestTypeSpecific() {return testTypeSpecific; }
    public void setTestTypeSpecific(TestTypeSpecific testTypeSpecific) { this.testTypeSpecific = testTypeSpecific; }
    public AgentRule getAgentRule() {return agentRule; }
    public void setAgentRule(AgentRule agentRule) {this.agentRule = agentRule; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Execution)) return false;

        Execution that = (Execution) o;

        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(testTypeSpecific != null ? !testTypeSpecific.equals(that.testTypeSpecific) : that.testTypeSpecific != null) return false;
        if(agentRule != null ? !agentRule.equals(that.agentRule) : that.agentRule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (testTypeSpecific != null ? testTypeSpecific.hashCode() : 0);
        result = 31 * result + (agentRule != null ? agentRule.hashCode() : 0 );

        return result;
    }
}
