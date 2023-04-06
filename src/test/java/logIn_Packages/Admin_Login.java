package logIn_Packages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import ObjectRepo.admin_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin_Login {

	public static void main(String[] args) throws Throwable {
		
		DataBaseUtility dLib = new DataBaseUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		wLib.MaxmizeWindow(driver);
		int RANDOM = jLib.random();
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		driver.get(URL);
		wLib.waitForPageLoad(driver);
		
		
		admin_LoginPage l=new admin_LoginPage(driver);
		l.admin_LoginPage(USERNAME, PASSWORD);
		
//		driver.findElement(By.id("inputEmail")).sendKeys(USERNAME);
//		driver.findElement(By.name("password")).sendKeys(PASSWORD);
//		driver.findElement(By.name("submit")).click();
		
		
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//li[@class='nav-user dropdown']")).click();
		//Actions a=new Actions(driver);
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
		//a.moveToElement(logout).click().perform();
		
		wLib.mousehover(driver, logout);

		
	}

}
