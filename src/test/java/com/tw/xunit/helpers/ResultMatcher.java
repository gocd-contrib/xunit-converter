package com.tw.xunit.helpers;

import com.tw.xunit.model.Error;
import com.tw.xunit.model.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ResultMatcher {
    public static void assertTestSuitesCorrectness(TestSuites testSuites, int testSuiteCount) {
        assertThat(testSuites.getTestSuites().size(), is(testSuiteCount));
    }

    public static void assertTestSuiteCorrectness(TestSuite testSuite, String name, int tests, int errors, int failures, int skipped, double time, int testCaseCount) {
        assertThat(testSuite.getErrors(), is(errors));
        assertThat(testSuite.getFailures(), is(failures));
        assertThat(testSuite.getName(), is(name));
        assertThat(testSuite.getSkipped(), is(skipped));
        assertThat(testSuite.getTests(), is(tests));
        assertThat(testSuite.getTime(), is(time));
        //assertThat(testSuite.getTimestamp(), is(nullValue()));
        if (testCaseCount > 0)
            assertThat(testSuite.getTestCases().size(), is(testCaseCount));
    }

    public static void assertPropertyCorrectness(Property property, String name, String value) {
        assertThat(property.getName(), is(name));
        assertThat(property.getValue(), is(value));
    }

    public static void assertTestCaseCorrectness(TestCase testCase, String name, String className, double time) {
        assertThat(testCase.getClassName(), is(className));
        assertThat(testCase.getName(), is(name));
        assertThat(testCase.getTime(), is(time));
    }

    public static void assertFailureCorrectness(Failure failure, String type, String message, String value) {
        //assertThat(failure.getType(), is(type));
        assertThat(failure.getMessage(), is(message));
        assertThat(failure.getValue(), is(value));
    }

    public static void assertErrorCorrectness(Error error, String type, String message, String value) {
        //assertThat(failure.getType(), is(type));
        assertThat(error.getMessage(), is(message));
        assertThat(error.getValue(), is(value));
    }
}
