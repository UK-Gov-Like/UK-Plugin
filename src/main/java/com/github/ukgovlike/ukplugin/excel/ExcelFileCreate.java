package com.github.ukgovlike.ukplugin.excel;

import com.github.ukgovlike.ukplugin.UKPlugin;
import com.github.ukgovlike.ukplugin.tests.TestCheck;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import static com.github.ukgovlike.ukplugin.UKPlugin.col;

/**
 *
 * @author plugner
 * @since August, 30, 2021
 *
 */

public class ExcelFileCreate {
  private String fileName;


  /**
   * @implNote fileName needs to end with .xls
   * @param fileName
   */

  public ExcelFileCreate(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  private File file = new File(fileName);
  private WorkbookSettings settings = new WorkbookSettings();
  private WritableWorkbook workbook;
  private WritableSheet sheet;
  private WritableFont writableFont;
  private WritableCellFormat writableCellFormat;

  public WritableWorkbook createExcelFile() throws IOException, WriteException, BiffException {

    if(file.exists()) {
      return null;
    }else{
      settings.setLocale(new Locale("pt", "BR"));
      workbook = Workbook.createWorkbook(file, settings);
      sheet = workbook.createSheet("BankAccounts", 0);
    }


    writableFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD);
    writableCellFormat = new WritableCellFormat(writableFont);

    writableCellFormat.setWrap(true);

    if(TestCheck.isTestMode()) {
      System.out.println("Running in test mode, will not save!");
    }else{
      workbook.write();
    }

    return workbook;
  }

  public Workbook setupWorkbook() throws BiffException, IOException, WriteException {
    if(!file.exists()) {
      return null;
    }

    Workbook workbook = Workbook.getWorkbook(file);
    sheet = (WritableSheet) workbook.getSheet(0);

    writableFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD);
    writableCellFormat = new WritableCellFormat(writableFont);

    writableCellFormat.setWrap(true);

    if(TestCheck.isTestMode()) {
      System.out.println("[ExcelFileCreate] Running in test mode.");
    }

    return workbook;
  }

  public void insertCell(String value, int row) throws WriteException, IOException {
    Label label = new Label(col, row, value);
    sheet.addCell(label);

    col++;
    if(TestCheck.isTestMode()) {
      System.out.println("[ExcelFileCreate] Running in test mode, don't saving in config.");
    }else{
      workbook.write();
      UKPlugin.config.set("LastCol", col);
      UKPlugin.getInstance().saveConfig();
      UKPlugin.getInstance().reloadConfig();
    }
  }
}
