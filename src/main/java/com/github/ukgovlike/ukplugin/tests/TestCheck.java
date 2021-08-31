package com.github.ukgovlike.ukplugin.tests;

import com.github.ukgovlike.ukplugin.UKPlugin;

public class TestCheck {
  public static boolean isTestMode() {
    try {
      Class.forName("org.bukkit.plugin.java.JavaPlugin");
    }catch (ClassNotFoundException exception) {
      return false;
    }
    return true;
  }
}
