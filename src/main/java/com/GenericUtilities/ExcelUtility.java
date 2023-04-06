package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 * 
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromExcel(String SheetName, int RowNo ,int ColumnNO) throws Throwable {
		
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(RowNo).getCell(ColumnNO).getStringCellValue();
		return value;
	}
	
	/**
	 * 
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */

	public int getLastRowNo(String SheetName) throws Throwable {
		
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count=sh.getLastRowNum();
		return count;
	}

	/**
	 * 
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	
	public void writeDataIntoExcel(String SheetName, int RowNo, int ColumnNO, String data) throws Throwable {

		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		sh.getRow(RowNo).createCell(ColumnNO).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fout);
	}

	/**
	 * 
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	
	public HashMap<String,String> readMultipleData(String SheetName) throws Throwable {

		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);	
		int count=sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=count;i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}


	/**
	 * 
	 * @param Sheetname
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultiplesetofData(String Sheetname) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) {
			for (int j=0;j<lastcell;j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
