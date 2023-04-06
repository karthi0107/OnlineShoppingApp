package Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtility;

public class testDataprovider {
	
	

//	@Test(dataProviderClass = dataprovider.class, dataProvider = "data") //class name , method name
//	public void AreaDetail(String name, String Place) {
//		System.out.println(name);
//		System.out.println(Place);
//	}

	
	@Test(dataProvider = "readSetData") 
	public void AreaDetail(String name, String Place) {
		System.out.println(name);
		System.out.println(Place);
	}
	
		@DataProvider
		public Object[][] readSetData() throws Throwable {
			ExcelUtility eLib = new ExcelUtility();
			Object[][] value = eLib.readMultiplesetofData("DataProviderdetails");
			return value;
		}

}
