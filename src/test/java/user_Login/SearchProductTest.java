package user_Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchProductTest {

	public static void main(String[] args) throws Throwable {
		DataBaseUtility dLib = new DataBaseUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		String EProductname ="Aquva";

		String USERURL = fLib.readDataFromPropertyFile("Userurl");
		String USERUSERNAME = fLib.readDataFromPropertyFile("Userusername");
		String USERPASSWORD = fLib.readDataFromPropertyFile("Userpassword");

		int Random = jLib.random();

		driver.get(USERURL);
		wLib.MaxmizeWindow(driver);
		wLib.waitForPageLoad(driver);

		driver.findElement(By.id("inputEmail")).sendKeys(USERUSERNAME);
		driver.findElement(By.name("password")).sendKeys(USERPASSWORD);
		driver.findElement(By.name("submit")).click();
		
		WebElement Searchproduct = driver.findElement(By.name("product"));
		Searchproduct.sendKeys(EProductname);
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		
		
		String AProductname = driver.findElement(By.xpath("//a[text()='"+EProductname+"']")).getText();
		 if(AProductname.contains(EProductname)) {
			 System.out.println("Product is Displayed");
		 }
		 else {
			 System.out.println("Product is Not Displayed ");
		 }				
	}
}
