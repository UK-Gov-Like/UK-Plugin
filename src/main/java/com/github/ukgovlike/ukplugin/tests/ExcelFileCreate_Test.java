package com.github.ukgovlike.ukplugin.tests;

import com.github.ukgovlike.ukplugin.UKPlugin;
import com.github.ukgovlike.ukplugin.excel.ExcelFileCreate;
import jxl.read.biff.BiffException;

public class ExcelFileCreate_Test extends Test {
  @Override
  public TestResult execute() {
    try {
      System.out.println("[TEST] Creating test file object");
      ExcelFileCreate excelFileCreate = new ExcelFileCreate("test1" + ".xls");

      System.out.println("[TEST] Creating excel file");
      excelFileCreate.createExcelFile();

      System.out.println("[TEST] Setting up workbook, without input file");
      try {
        excelFileCreate.setupWorkbook();
      }catch (BiffException e) {
        System.out.println("[TEST] Returned BiffException as expected.");
      }catch (Exception e2) {
        System.out.println("[TEST] Returned other exception!");
        e2.printStackTrace();
        return TestResult.ERROR;
      }


      int cells = 100;
      System.out.println("[TEST] Inserting 100 cells to file");
      int col = 0;

      while(cells != 0) {
        cells--;
        excelFileCreate.insertCell("Testing " + cells, 1, col);
        col++;
      }

      return TestResult.SUCCESS;
    }catch (Exception e) {
      e.printStackTrace();
      return TestResult.ERROR;
    }
  }
}
