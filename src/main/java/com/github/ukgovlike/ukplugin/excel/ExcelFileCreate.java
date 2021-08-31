package com.github.ukgovlike.ukplugin.excel;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class ExcelFileCreate {
  private String fileName;

  public ExcelFileCreate(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public WritableWorkbook createExcelFile() throws IOException, WriteException {
    WorkbookSettings settings = new WorkbookSettings();
    settings.setLocale(new Locale("pt", "BR"));
    WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName), settings);
    WritableSheet sheet = workbook.createSheet("BankAccounts", 0);

    WritableFont writableFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD);
    WritableCellFormat writableCellFormat = new WritableCellFormat(writableFont);

    writableCellFormat.setWrap(true);

    return workbook;
  }

  // TODO
  public void insertCell() {}
}
