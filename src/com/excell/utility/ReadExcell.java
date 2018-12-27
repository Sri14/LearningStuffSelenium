package com.excell.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcell {
	
	public static String sheetValue() throws Exception{

	File src = new File ("/Users/HomeMac/Desktop/SeleniumProject/Workbook1.xlsx");
	
	//Users/HomeMac/Desktop/SeleniumProject/Workbook1.xlsx
	FileInputStream ip = new FileInputStream(src);
	
	XSSFWorkbook wb = new XSSFWorkbook(ip);
	
	XSSFSheet sheet1 = wb.getSheetAt(0); // sheet number
	
	String value1 = sheet1.getRow(1).getCell(0).getStringCellValue();
	wb.close();
	
	
	
	return value1;
	
	
	
	
	
	}
	
	

}

