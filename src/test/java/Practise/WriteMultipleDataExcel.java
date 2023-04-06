package Practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataExcel {
	
public static void main(String[] args) throws Throwable {
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Ty.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Ty.xlsx");
		wb.write(fos);
		wb.close();

}
}
