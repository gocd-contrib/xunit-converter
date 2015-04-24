package com.tw.xunit.converter.mstest;

import com.tw.xunit.converter.jsunit.TestCases;
import com.tw.xunit.model.Properties;
import com.tw.xunit.model.SysOut;
import com.tw.xunit.model.SysErr;
import com.tw.xunit.model.mstest.TestRun;

import java.util.List;

/**
 * Created by nhudacin on 4/23/2015.
 */
public class TestRunConverter {
    private TestRun testRun;
    private String name;
    private double time;
    private int tests;
    private int failures;
    private int errors;
    private int disabled;
    private int skipped;
    private String timestamp;
    private String hostname;
    private String id;
    private String _package;
    private String assertions;
    private String file;
    private List<Properties> properties;
    private List<TestCases> testCases;
    private List<SysOut> sysOuts;
    private List<SysErr> sysErrs;

    public String getName() {
        return this.name;
    }



}
