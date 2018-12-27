package com.excell.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InitialSetUp {

	public static void main(String[] args) throws Exception {
		
		File src = new File ("/Users/HomeMac/Desktop/SeleniumProject/Workbook1.xlsx");
		
		FileInputStream ip = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(ip);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
		
		int rowcount = sheet.getLastRowNum();
		
		//System.out.println(rowcount);
		
		String Value0 = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(Value0);
		
		String value1 = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(value1);
		
		String value2 = sheet.getRow(2).getCell(0).getStringCellValue();
		System.out.println(value2);
		
		String value3 = sheet.getRow(3).getCell(0).getStringCellValue();
		System.out.println(value3);
		
		String value4 = sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(value4);
		
		String value5 = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(value5);
		
		
		for(int i=0; i<rowcount;i++){
			String data0 = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data0);
		}
		
		
	}

}
