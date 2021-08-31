package com.github.ukgovlike.ukplugin.tests;

public class TestLogger {

  public static void logResult(TestResult result, Test test) {
    System.out.println("[TEST] " + test.getClass().getSimpleName() + " ended with result " + result.name());
  }

  public static void logRunning(Test test) {
    System.out.println("[TEST] Running test " + test.getClass().getSimpleName());
  }

  public static void logEnd() {
    System.out.println("[TEST] End of tests reached.");
  }

}
