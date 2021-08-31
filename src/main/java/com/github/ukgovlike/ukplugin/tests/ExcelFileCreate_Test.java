package com.github.ukgovlike.ukplugin.tests;

import com.github.ukgovlike.ukplugin.UKPlugin;
import com.github.ukgovlike.ukplugin.excel.ExcelFileCreate;

public class ExcelFileCreate_Test extends Test {
  @Override
  public TestResult execute() {
    try {
      System.out.println("[TEST] Creating test file object");
      ExcelFileCreate excelFileCreate = new ExcelFileCreate(System.currentTimeMillis() + ".xls");

      System.out.println("[TEST] Creating excel file");
      excelFileCreate.createExcelFile();

      System.out.println("[TEST] Setting up workbook");
      excelFileCreate.setupWorkbook();

      int cells = 100;
      System.out.println("[TEST] Inserting 100 cells to file");
      UKPlugin.col = 1;

      while(cells != 0) {
        cells--;
        excelFileCreate.insertCell("Testing " + cells, 1);
      }

      return TestResult.SUCCESS;
    }catch (Exception e) {
      e.printStackTrace();
      return TestResult.ERROR;
    }
  }
}
