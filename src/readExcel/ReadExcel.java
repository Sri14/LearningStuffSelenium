package readExcel;

import setUpExcel.setUpExcel;

public class ReadExcel {

	public static void main(String[] args) {
		
		setUpExcel obj1 = new setUpExcel("/Users/HomeMac/Desktop/SeleniumProject/Workbook1.xlsx");
		
		System.out.println(obj1.readData(0, 3, 0));
		
		
		
	}

}
