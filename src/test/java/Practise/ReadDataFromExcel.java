package Practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
		DataBaseUtility dLib = new DataBaseUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Ty.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		
//		String value = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
//		
		String value = fLib.readDataFromPropertyFile("Sheet1");
		System.out.println(value);
	}

}
