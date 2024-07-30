package com.comcast.CRM.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	public String getdatafromexcel(String sheetname, int rownum, int celnum) throws Exception
	{
		//read test 
		//script data from excel file
				FileInputStream file =new FileInputStream("./Testscriptdata/Book2.xlsx");
			      Workbook wb= WorkbookFactory.create(file);
				String data = wb.getSheet(sheetname).getRow(rownum).getCell(celnum).getStringCellValue();
				wb.close();
				return data;

	}
	
	public int getrow(String sheetname) throws Exception
	{
		FileInputStream file =new FileInputStream("./Testscriptdata/Book2.xlsx");
	      Workbook wb= WorkbookFactory.create(file);
		int data = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return data;
	}
	
	public void setdatafromexcel(String sheetname, int rownum, int celnum, String value) throws Exception
	{
		FileInputStream file =new FileInputStream("./Testscriptdata/Book2.xlsx");
	      Workbook wb= WorkbookFactory.create(file);
		 wb.getSheet(sheetname).getRow(rownum).createCell(celnum).setCellValue(value);
		FileOutputStream fos =new FileOutputStream("./Testscriptdata/Book2.xlsx");
		wb.write(fos);
		wb.close();
	}

}
