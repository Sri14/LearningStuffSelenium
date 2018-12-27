package com.excell.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws Exception {
		File src = new File ("/Users/HomeMac/Desktop/SeleniumProject/Workbook1.xlsx");
		
		//Users/HomeMac/Desktop/SeleniumProject/Workbook1.xlsx
		FileInputStream ip = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(ip);
		
		XSSFSheet sheet1 = wb.getSheetAt(1); // sheet number
		
		sheet1.getRow(0).createCell(2).setCellValue("Super");
		
		FileOutputStream os = new FileOutputStream(src);
		
		wb.write(os);
		
		
	}

}
