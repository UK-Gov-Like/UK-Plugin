package com.github.ukgovlike.ukplugin.tests;

import java.util.ArrayList;

/**
 *
 * @author plugner
 * @since August, 30, 2021
 * @apiNote Test only package, do not implement in the code.
 *
 */

public class TestRunner {

  public static ArrayList<Test> tests = new ArrayList<>();

  public static void main(String[] args) {

    tests.add(new ExcelFileCreate_Test());

    for(Test test : tests) {
      TestLogger.logRunning(test);
      TestResult testResult = test.execute();

      TestLogger.logResult(testResult, test);
    }

    TestLogger.logEnd();

  }

}
