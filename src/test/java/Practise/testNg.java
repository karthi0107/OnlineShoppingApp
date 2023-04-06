package Practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNg {
	
//	@Test
//	public void createName() {
//		System.out.println("createname");
//	}
//	
//	@Test
//	public void editName() {
//		System.out.println("EDITNAME");
//	}
//	
//	@Test
//	public void deleteName() {
//		System.out.println("DELETENAME");
//	}
	
	@BeforeSuite
	public void connectDB() {
		System.out.println("Connecting DB");
	}
	
	@BeforeTest
	public void parllelExecution() {
		System.out.println("parllelExecution");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("launchBrowser");
	}

	@BeforeMethod
	public void loginApp() {
		System.out.println("loginApp");
	}

	
	@Test
	public void testScript() {
		System.out.println("testScript");
	}

	@AfterMethod
	public void logoutApp() {
		System.out.println("logoutApp");
	}
	
	@AfterClass
	
	public void closeBrowser() {
		System.out.println("closeBrowser");
	}
	
	@AfterTest
	public void test() {
		System.out.println("AfterTest");
	}
	
	@AfterSuite
	
	public void closeDB() {
		System.out.println("closeDB");
	}

	
}
