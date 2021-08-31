package com.github.ukgovlike.ukplugin.tests;

import com.github.ukgovlike.ukplugin.UKPlugin;

public class TestCheck {
  public static boolean isTestMode() {
    return UKPlugin.getInstance() == null;
  }
}
