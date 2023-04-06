package Practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.IpathConstants;

public class dataprovider {

	//	@DataProvider
	//	public Object[][] data() {
	//		
	//		Object[][] obj = new Object[2][2];
	//		
	//		obj[0][0] = "karthi";
	//		obj[0][1] = "keyan";
	//		obj[1][0] = "Vaniyambadi";
	//		obj[1][1] = "Tirupathur District";
	//		
	//		return obj;
	//				
	//	}

//	@DataProvider
//	public Object[][] data() throws Throwable {
//
//		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("DataProviderdetails");
//		int lastrow = sh.getLastRowNum()+1;
//		short lastcell = sh.getRow(0).getLastCellNum();
//
//		Object[][] obj = new Object[lastrow][lastcell];
//		for(int i=0;i<lastrow;i++) {
//			for(int j=0;j<lastcell;j++) {
//				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
//			}
//		}
//
//		return obj;
//	}
}
