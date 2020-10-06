package com.github.ukgovlike.ukplugin.api;

import com.github.ukgovlike.ukplugin.api.file.ExcelFileAPI;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelAPI {
   private FileInputStream fileInputStream;
   { try {     fileInputStream = new FileInputStream(ExcelFileAPI.file);} catch (FileNotFoundException e) {
       try {ExcelFileAPI.createFile();} catch (IOException ioException) {ioException.printStackTrace();}}}
   private XSSFWorkbook workbook;
   {try {workbook = new XSSFWorkbook(fileInputStream);} catch (IOException e) {e.printStackTrace();} }

    public ExcelAPI() {}

    public Sheet createSheet(String name) {
        if(hasSheet(name)) {return null;}
        return (Sheet) workbook.createSheet(name);
    }
    public boolean hasSheet(String name) {
        return workbook.getSheet(name) != null;
    }
    public void deleteSheet(String name) {
       if(!hasSheet(name)) {return;}
        workbook.removeSheetAt(workbook.getSheetIndex(name));
    }
    public Sheet getSheet(String name) {
       if(!hasSheet(name)) {return null;}
       return (Sheet) workbook.getSheet(name);
    }
    public Cell getCell(Sheet sheet, int x, int y) {
        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : (XSSFSheet)sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
             if(cell.getAddress().getColumn() == x && cell.getAddress().getRow() == y) {
                 return cell;
             }
            }
            i++;
        }
        return null;
    }
    public Object readCell(Cell cell) {
       switch (cell.getCellTypeEnum()) {
           case BOOLEAN: return cell.getBooleanCellValue();
           case NUMERIC: return cell.getNumericCellValue();
           default: return cell.getStringCellValue();
       }
    }
    public void writeCell(Cell cell, Object toWrite) {
       switch (toWrite.getClass().getSimpleName().toLowerCase()) {
           case "boolean": cell.setCellValue((boolean) toWrite);break;
           case "string": cell.setCellValue((String)toWrite);break;
           case "double": cell.setCellValue(Double.parseDouble((String) toWrite));break;
           case "integer": cell.setCellValue(Integer.parseInt((String) toWrite));break;
           case "date": cell.setCellValue(Date.parse((String) toWrite)); break;
       }
    }


}
