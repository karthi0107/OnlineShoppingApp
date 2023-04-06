package Practise;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataExcel {

public static void main(String[] args) throws Throwable {
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Ty.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
	
	int rowcount = wb.getSheet("Sheet1").getLastRowNum();
	
	for(int i=0;i<=rowcount;i++ ) {
		String Branch = wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
		String Location = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
		
		System.out.println(Branch + " "+ Location);
	}
	
}
}
