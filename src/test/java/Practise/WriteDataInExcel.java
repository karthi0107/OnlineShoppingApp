package Practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel {

	public static void main(String[] args) throws Throwable {
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Ty.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("Sheet1").getRow(2).getCell(0).setCellValue("Qspider");
				
		wb.getSheet("Sheet1").getRow(2).getCell(1).setCellValue("BTM");
		
		wb.getSheet("Sheet1").createRow(3).createCell(0).setCellValue("Jspider");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Ty.xlsx");
		
		wb.write(fos);
		wb.close();
		
	}

}
