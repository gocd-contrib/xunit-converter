package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/22/2015.
 */

import com.tw.xunit.converter.mstest.ConversionHelpers;
import com.tw.xunit.model.*;
import com.tw.xunit.model.Error;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

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

    @Element(name = "Output", required = false)
    private Output output;

    private double convertedDuration;

    public UnitTestResult() {
    }

    public UnitTestResult(String executionId, String testId, String testName, String computerName, String duration, String startTime, String endTime, String testType, String outcome, String testListId, String relativeResultsDirectory, Output output ) {
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
        this.output = output;
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
    public void setDuration(String duration) { this.duration = duration; }
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
    public Output getOutput() {return output;}
    public void setOutput(Output output ) {this.output = output;}

    public double getConvertedDuration() { return ConversionHelpers.durationConverter(duration);}
    public void setConvertedDuration(double d) { this.convertedDuration = d; }

    /* Methods to handle conversion to xunit */
    public TestCase getTestCase(HashMap<String,String> classNameMap) {
        String name = this.testName;
        String classname = classNameMap.containsKey(testId) ? classNameMap.get(testId) : "Not Found";
        String status = this.outcome;

        List<Error> errorTests = new ArrayList<Error>();
        List<SysOut> sysOuts = new ArrayList<SysOut>();

        if(this.output != null) {
            if (this.output.getErrorInfo() != null)
                errorTests.add(this.output.getErrorInfo().getError());

            if(this.output.getDebugTrace() != null)
                sysOuts.add(this.output.getDebugTrace().getSysout());
        }

        double time = ConversionHelpers.durationConverter(duration);
        double newTime = ConversionHelpers.getDateDifference(startTime, endTime);

        return new TestCase(name, newTime, classname, status, null, null, null, null,null,errorTests, null, sysOuts, null );
    }



    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof UnitTestResult)) return false;

        UnitTestResult that = (UnitTestResult) o;

        if (executionId != null? !executionId.equals(that.executionId) : that.executionId !=null) return false;
        if (testId != null? !testId.equals(that.testId) : that.testId !=null) return false;
        if (testName != null? !testName.equals(that.testName) : that.testName !=null) return false;
        if (computerName != null? !computerName.equals(that.computerName) : that.computerName !=null) return false;
        if (duration != null? !duration.equals(that.duration) : that.duration !=null) return false;
        if (startTime != null? !startTime.equals(that.startTime) : that.startTime !=null) return false;
        if (endTime != null? !endTime.equals(that.endTime) : that.endTime !=null) return false;
        if (testType != null? !testType.equals(that.testType) : that.testType !=null) return false;
        if (outcome != null? !outcome.equals(that.outcome) : that.outcome !=null) return false;
        if (testListId != null? !testListId.equals(that.testListId) : that.testListId !=null) return false;
        if (relativeResultsDirectory != null? !relativeResultsDirectory.equals(that.relativeResultsDirectory) : that.relativeResultsDirectory !=null) return false;
        if (output != null? !output.equals(that.output) : that.output !=null) return false;
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
        result = 31 * result + (output != null ? output.hashCode() : 0);
        return result;
    }
}
