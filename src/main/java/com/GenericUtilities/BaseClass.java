package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepo.adminHomePage;
import ObjectRepo.admin_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public DataBaseUtility dLib = new DataBaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite
	public void connectToDB() throws Throwable {
		dLib.connectToDb();
	}
	//@Parameters("Browser")
	@BeforeClass
	public void OpentheBrowser() throws Throwable {

	String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");

		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if(BROWSER.equalsIgnoreCase("internetexplorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		sdriver=driver;
		
		wLib.MaxmizeWindow(driver);
		driver.get(URL);
		wLib.waitForPageLoad(driver);
	}

	@BeforeMethod
	public void Adminlogin() throws Throwable {

		admin_LoginPage aln = new admin_LoginPage(driver);

		String USERNAME = fLib.readDataFromPropertyFile("username");
		
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		aln.admin_LoginPage(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void Adminlogout() {
		adminHomePage hp = new adminHomePage(driver);
		hp.logoutlink();
	}

	@AfterClass
	public void closetheBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void closeDB() throws Throwable {
		dLib.closeDB();

	}

}
