package setUpExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GiffgaffExcelSetUp {

	File src;
	FileInputStream ip;
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public GiffgaffExcelSetUp(String excelPath) {

		try {
			src = new File(excelPath);
			ip = new FileInputStream(src);
			wb = new XSSFWorkbook(ip);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getData(int sheetNum, int row, int column) {
		sheet1 = wb.getSheetAt(sheetNum);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;

	}

}
