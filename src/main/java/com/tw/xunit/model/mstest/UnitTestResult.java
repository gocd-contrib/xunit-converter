package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import com.tw.xunit.model.*;
import com.tw.xunit.model.Error;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.ArrayList;
import java.util.List;

public class UnitTestResult {

    @Attribute(required = false)
    private String executionId;

    @Attribute(required = false)
    private String testId;

    @Attribute(required = false)
    private String testName;

    @Attribute(required = false)
    private String computerName;

    @Attribute(required = false)
    private String duration;

    @Attribute(required = false)
    private String startTime;

    @Attribute(required = false)
    private String endTime;

    @Attribute(required = false)
    private String testType;

    @Attribute(required = false)
    private String outcome;

    @Attribute(required = false)
    private String testListId;

    @Attribute(required = false)
    private String relativeResultsDirectory;

    @ElementList(entry = "Output", inline = true, required = false)
    private List<Output>  outputs;

    public UnitTestResult() {
    }

    public UnitTestResult(String executionId, String testId, String testName, String computerName, String duration, String startTime, String endTime, String testType, String outcome, String testListId, String relativeResultsDirectory, List<Output> outputs ) {
       this.executionId = executionId;
        this.testId = testId;
        this.testName = testName;
        this.computerName = computerName;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.testType = testType;
        this.outcome = outcome;
        this.testListId = testListId;
        this.relativeResultsDirectory = relativeResultsDirectory;
        this.outputs = outputs;
    }

    public String getExecutionId() {return executionId;}
    public void setExecutionId(String executionId) {this.executionId = executionId ;}
    public String getTestId() {return testId ;}
    public void setTestId(String testId) {this.testId = testId ;}
    public String getTestName() {return testName ;}
    public void setTestName(String testName) {this.testName = testName ;}
    public String getComputerName() {return computerName ;}
    public void setComputerName(String computerName) {this.computerName = computerName ;}
    public String getDuration() {return duration;}
    public void setDuration(String duration) {this.duration = duration ;}
    public String getStartTime() {return startTime;}
    public void setStartTime(String startTime) {this.startTime = startTime;}
    public String getEndTime() {return endTime ;}
    public void setEndTime(String endTime) {this.endTime = endTime ;}
    public String getTestType() {return testType ;}
    public void setTestType(String testType) {this.testType = testType;}
    public String getOutcome() {return outcome;}
    public void setOutcome(String outcome ) {this.outcome = outcome ;}
    public String getTestListId() {return testListId ;}
    public void setTestListId(String testListId ) {this.testListId = testListId ;}
    public String getRelativeResultsDirectory() {return relativeResultsDirectory;}
    public void setRelativeResultsDirectory(String relativeResultsDirectory ) {this.relativeResultsDirectory = relativeResultsDirectory ;}
    public List<Output> getOutputs() {return outputs;}
    public void setOutputs(List<Output> outputs ) {this.outputs = outputs;}

    /* Methods to handle conversion to xunit */
    public TestCase getConverted_TestCase() {
        String name = this.testName;
        /* Class name for MSTest is a unit id */
        String classname = this.testId;
        String status = this.outcome;
        List<Error> errorTests = this.outputs.get(0).getConverted_error();
        List<SysOut> sysOuts = this.outputs.get(0).getConverted_sysout();

        return new TestCase(name, 0, classname, status, null, null, null, null,null,errorTests, null, sysOuts, null );
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof UnitTestResult)) return false;

        UnitTestResult unitTestResult = (UnitTestResult) o;
        if (executionId != null? !executionId.equals(unitTestResult.executionId) : unitTestResult.executionId !=null) return false;
        if (testId != null? !testId.equals(unitTestResult.testId) : unitTestResult.testId !=null) return false;
        if (testName != null? !testName.equals(unitTestResult.testName) : unitTestResult.testName !=null) return false;
        if (computerName != null? !computerName.equals(unitTestResult.computerName) : unitTestResult.computerName !=null) return false;
        if (duration != null? !duration.equals(unitTestResult.duration) : unitTestResult.duration !=null) return false;
        if (startTime != null? !startTime.equals(unitTestResult.startTime) : unitTestResult.startTime !=null) return false;
        if (endTime != null? !endTime.equals(unitTestResult.endTime) : unitTestResult.endTime !=null) return false;
        if (testType != null? !testType.equals(unitTestResult.testType) : unitTestResult.testType !=null) return false;
        if (outcome != null? !outcome.equals(unitTestResult.outcome) : unitTestResult.outcome !=null) return false;
        if (testListId != null? !testListId.equals(unitTestResult.testListId) : unitTestResult.testListId !=null) return false;
        if (relativeResultsDirectory != null? !relativeResultsDirectory.equals(unitTestResult.relativeResultsDirectory) : unitTestResult.relativeResultsDirectory !=null) return false;
        if (outputs != null? !outputs.equals(unitTestResult.outputs) : unitTestResult.outputs !=null) return false;
        return true;
    }

    public  int hashCode() {
        int result;
        result = executionId != null? executionId.hashCode() : 0;
        result = 31 * result + (testId != null ? testId.hashCode() : 0);
        result = 31 * result + (testName != null ? testName.hashCode() : 0);
        result = 31 * result + (computerName != null ? computerName.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (testType != null ? testType.hashCode() : 0);
        result = 31 * result + (outcome != null ? outcome.hashCode() : 0);
        result = 31 * result + (testListId != null ? testListId.hashCode() : 0);
        result = 31 * result + (relativeResultsDirectory != null ? relativeResultsDirectory.hashCode() : 0);
        result = 31 * result + (outputs != null ? outputs.hashCode() : 0);
        return result;
    }
}
