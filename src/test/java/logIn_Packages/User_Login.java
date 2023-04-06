package logIn_Packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class User_Login {

	public static void main(String[] args) throws Throwable {

		DataBaseUtility dLib = new DataBaseUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		String USERURL = fLib.readDataFromPropertyFile("Userurl");
		String USERUSERNAME = fLib.readDataFromPropertyFile("Userusername");
		String USERPASSWORD = fLib.readDataFromPropertyFile("Userpassword");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		int Random = jLib.random();

		driver.get(USERURL);
		wLib.MaxmizeWindow(driver);
		wLib.waitForPageLoad(driver);

		driver.findElement(By.id("inputEmail")).sendKeys(USERUSERNAME);
		driver.findElement(By.name("password")).sendKeys(USERPASSWORD);
		driver.findElement(By.name("submit")).click();
	}
}
