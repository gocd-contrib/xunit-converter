package com.tw.xunit.parser;

import com.tw.xunit.model.TestSuite;
import com.tw.xunit.model.TestSuites;
import org.junit.Test;

import static com.tw.xunit.helpers.ResourceHelper.resource;
import static com.tw.xunit.helpers.ResultMatcher.*;

public class XUnitParserTest {
    @Test
    public void testParseXUnitXMLCorrectly1() throws Exception {
        TestSuite testSuite = XUnitParser.parseTestSuiteXUnitXML(resource("/sample-xunit-reports/1.xml"));

        assertTestSuiteCorrectness(testSuite, "nose2-junit", 25, 1, 5, 0, 0.004, 25);

        assertTestCaseCorrectness(testSuite.getTestCases().get(0), "test_gen:1", "pkg1.test.test_things", 0.000141);
        assertTestCaseCorrectness(testSuite.getTestCases().get(1), "test_gen:2", "pkg1.test.test_things", 0.000093);
        assertTestCaseCorrectness(testSuite.getTestCases().get(2), "test_gen:3", "pkg1.test.test_things", 0.000086);
        assertTestCaseCorrectness(testSuite.getTestCases().get(3), "test_gen:4", "pkg1.test.test_things", 0.000086);
        assertTestCaseCorrectness(testSuite.getTestCases().get(4), "test_gen:5", "pkg1.test.test_things", 0.000087);
        assertTestCaseCorrectness(testSuite.getTestCases().get(5), "test_gen_nose_style:1", "pkg1.test.test_things", 0.000085);
        assertTestCaseCorrectness(testSuite.getTestCases().get(6), "test_gen_nose_style:2", "pkg1.test.test_things", 0.000090);
        assertTestCaseCorrectness(testSuite.getTestCases().get(7), "test_gen_nose_style:3", "pkg1.test.test_things", 0.000085);
        assertTestCaseCorrectness(testSuite.getTestCases().get(8), "test_gen_nose_style:4", "pkg1.test.test_things", 0.000087);
        assertTestCaseCorrectness(testSuite.getTestCases().get(9), "test_gen_nose_style:5", "pkg1.test.test_things", 0.000086);
        assertTestCaseCorrectness(testSuite.getTestCases().get(10), "test_params_func:1", "pkg1.test.test_things", 0.000093);
        assertTestCaseCorrectness(testSuite.getTestCases().get(11), "test_params_func:2", "pkg1.test.test_things", 0.000098);
        assertTestCaseCorrectness(testSuite.getTestCases().get(12), "test_params_func_multi_arg:1", "pkg1.test.test_things", 0.000094);
        assertTestCaseCorrectness(testSuite.getTestCases().get(13), "test_params_func_multi_arg:2", "pkg1.test.test_things", 0.000089);
        assertTestCaseCorrectness(testSuite.getTestCases().get(14), "test_params_func_multi_arg:3", "pkg1.test.test_things", 0.000096);
        assertTestCaseCorrectness(testSuite.getTestCases().get(15), "test_fixt", "", 0.000091);
        assertTestCaseCorrectness(testSuite.getTestCases().get(16), "test_func", "", 0.000084);
        assertTestCaseCorrectness(testSuite.getTestCases().get(17), "test_failed", "pkg1.test.test_things.SomeTests", 0.000113);
        assertTestCaseCorrectness(testSuite.getTestCases().get(18), "test_ok", "pkg1.test.test_things.SomeTests", 0.000093);
        assertTestCaseCorrectness(testSuite.getTestCases().get(19), "test_params_method:1", "pkg1.test.test_things.SomeTests", 0.000099);
        assertTestCaseCorrectness(testSuite.getTestCases().get(20), "test_params_method:2", "pkg1.test.test_things.SomeTests", 0.000101);
        assertTestCaseCorrectness(testSuite.getTestCases().get(21), "test_skippy", "pkg1.test.test_things.SomeTests", 0.000104);
        assertTestCaseCorrectness(testSuite.getTestCases().get(22), "test_typeerr", "pkg1.test.test_things.SomeTests", 0.000096);
        assertTestCaseCorrectness(testSuite.getTestCases().get(23), "test_gen_method:1", "pkg1.test.test_things.SomeTests", 0.000094);
        assertTestCaseCorrectness(testSuite.getTestCases().get(24), "test_gen_method:2", "pkg1.test.test_things.SomeTests", 0.000090);

        assertFailureCorrectness(testSuite.getTestCases().get(11).getFailureTests().get(0), null, "test failure", "Traceback (most recent call last):\n" +
                "File \"nose2/plugins/loader/parameters.py\", line 162, in func\n" +
                "return obj(*argSet)\n" +
                "File \"nose2/tests/functional/support/scenario/tests_in_package/pkg1/test/test_things.py\", line 64, in\n" +
                "test_params_func\n" +
                "assert a == 1\n" +
                "AssertionError\n");
        assertFailureCorrectness(testSuite.getTestCases().get(13).getFailureTests().get(0), null, "test failure", "Traceback (most recent call last):\n" +
                "File \"nose2/plugins/loader/parameters.py\", line 162, in func\n" +
                "return obj(*argSet)\n" +
                "File \"nose2/tests/functional/support/scenario/tests_in_package/pkg1/test/test_things.py\", line 69, in\n" +
                "test_params_func_multi_arg\n" +
                "assert a == b\n" +
                "AssertionError\n");
        assertFailureCorrectness(testSuite.getTestCases().get(17).getFailureTests().get(0), null, "test failure", "Traceback (most recent call last):\n" +
                "File \"nose2/tests/functional/support/scenario/tests_in_package/pkg1/test/test_things.py\", line 17, in\n" +
                "test_failed\n" +
                "assert False, \"I failed\"\n" +
                "AssertionError: I failed\n");
        assertFailureCorrectness(testSuite.getTestCases().get(20).getFailureTests().get(0), null, "test failure", "Traceback (most recent call last):\n" +
                "File \"nose2/plugins/loader/parameters.py\", line 144, in _method\n" +
                "return method(self, *argSet)\n" +
                "File \"nose2/tests/functional/support/scenario/tests_in_package/pkg1/test/test_things.py\", line 29, in\n" +
                "test_params_method\n" +
                "self.assertEqual(a, 1)\n" +
                "AssertionError: 2 != 1\n");
        assertFailureCorrectness(testSuite.getTestCases().get(24).getFailureTests().get(0), null, "test failure", "Traceback (most recent call last):\n" +
                "File \"nose2/plugins/loader/generators.py\", line 145, in method\n" +
                "return func(*args)\n" +
                "File \"nose2/tests/functional/support/scenario/tests_in_package/pkg1/test/test_things.py\", line 24, in check\n" +
                "assert x == 1\n" +
                "AssertionError\n");

        assertErrorCorrectness(testSuite.getTestCases().get(22).getErrorTests().get(0), null, "test failure", "Traceback (most recent call last):\n" +
                "File \"nose2/tests/functional/support/scenario/tests_in_package/pkg1/test/test_things.py\", line 13, in\n" +
                "test_typeerr\n" +
                "raise TypeError(\"oops\")\n" +
                "TypeError: oops\n");
    }

    @Test
    public void testParseXUnitXMLCorrectly2() throws Exception {
        TestSuites testSuites = XUnitParser.parseTestSuitesXUnitXML(resource("/sample-xunit-reports/2.xml"));

        assertTestSuitesCorrectness(testSuites, 2);

        assertTestSuiteCorrectness(testSuites.getTestSuites().get(0), "JUnitXmlReporter", 0, 0, 0, 0, 0, 0);

        assertTestSuiteCorrectness(testSuites.getTestSuites().get(1), "JUnitXmlReporter.constructor", 3, 0, 1, 1, 0.006, 3);

        assertPropertyCorrectness(testSuites.getTestSuites().get(1).getProperties().get(0).getProperties().get(0), "java.vendor", "Sun Microsystems Inc.");
        assertPropertyCorrectness(testSuites.getTestSuites().get(1).getProperties().get(0).getProperties().get(1), "compiler.debug", "on");
        assertPropertyCorrectness(testSuites.getTestSuites().get(1).getProperties().get(0).getProperties().get(2), "project.jdk.classpath", "jdk.classpath.1.6");

        assertTestCaseCorrectness(testSuites.getTestSuites().get(1).getTestCases().get(0), "should default path to an empty string", "JUnitXmlReporter.constructor", 0.006);
        assertTestCaseCorrectness(testSuites.getTestSuites().get(1).getTestCases().get(1), "should default consolidate to true", "JUnitXmlReporter.constructor", 0);
        assertTestCaseCorrectness(testSuites.getTestSuites().get(1).getTestCases().get(2), "should default useDotNotation to true", "JUnitXmlReporter.constructor", 0);

        assertFailureCorrectness(testSuites.getTestSuites().get(1).getTestCases().get(0).getFailureTests().get(0), null, "test failure", "Assertion failed");
    }
}