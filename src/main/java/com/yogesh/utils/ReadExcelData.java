package com.yogesh.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadExcelData {

    public static String readExcel(int sheetIndex, int rowIndex, int cellIndex) {

        XSSFWorkbook workBook = null;
        String value=null;

        try {
            String path = System.getProperty("user.dir") + File.separator + "src\\main\\resources\\Sheets\\TestData.xlsx";
            //To get File path
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            workBook = new XSSFWorkbook(fis);
            Sheet sheet = workBook.getSheetAt(sheetIndex);
            DataFormatter formatter = new DataFormatter();
           value=formatter.formatCellValue(sheet.getRow(rowIndex).getCell(cellIndex));
           return value;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (workBook != null) {
                    workBook.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "File Not found on expected path.";


    }
}
