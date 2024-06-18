package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getDataFromExcel(String SheetName,int rowNum, int cellNum) throws Throwable {
	FileInputStream fis=new FileInputStream("./testdata/testscriptdata.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	 wb.close();
     return data;
	}
 
     public int getRowCount(String SheetName) throws Throwable {
    	 FileInputStream fis =new FileInputStream("./testdata/testscriptdata.xlsx");
    	Workbook wb=WorkbookFactory.create(fis);
    	int rowCount=wb.getSheet(SheetName).getLastRowNum();
   	     wb.close();
        return rowCount;
    }
     
     public void setDataIntoExcel(String SheetName,int rowNum,int CellNum,String data) throws Throwable {
    	 FileInputStream fis=new FileInputStream("./testdata/testscriptdata.xlsx");
    	 Workbook wb=WorkbookFactory.create(fis);
    	 wb.getSheet(SheetName).getRow(rowNum).createCell(CellNum);
    	 
    	 FileOutputStream fos=new FileOutputStream("./testdata/testscriptdata.xlsx");
    	 wb.write(fos);
    	 wb.close();
    	 
     }








}
