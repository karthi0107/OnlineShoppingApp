package TakevaluefromExcelandPropertyfile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Insert {

	public static void main(String[] args) throws Throwable {


		DataBaseUtility dLib = new DataBaseUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		//FROM PROPERTY FILE
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");


		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		int Random = jLib.random();

		driver.get(URL);
		wLib.MaxmizeWindow(driver);
		wLib.waitForPageLoad(driver);

		driver.findElement(By.id("inputEmail")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();

		String expres = "Well done! Product Inserted Successfully !!";		
		driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();

		WebElement categoryDropdown = driver.findElement(By.name("category"));
		categoryDropdown.click();
		wLib.select("1WaterBottel", categoryDropdown);

		WebElement subcategoryDropdown = driver.findElement(By.id("subcategory"));
		subcategoryDropdown.click();
		wLib.select("Stainless Steel Temp", subcategoryDropdown);


		HashMap<String, String> map = eLib.readMultipleData("Sheet1");

		for(Entry<String, String> set:map.entrySet()) {

			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}

		WebElement Productavailable = driver.findElement(By.xpath("//select[@name='productAvailability']"));

		wLib.select(Productavailable, "In Stock");
		Thread.sleep(3000);

		File f1=new File("./dataImg/img1.png");
		String path1 = f1.getAbsolutePath();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='productimage1']")).sendKeys(path1);

		File f2=new File("./dataImg/img2.png");
		String path2 = f2.getAbsolutePath();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='productimage2']")).sendKeys(path2);

		File f3=new File("./dataImg/img3.png");
		String path3 = f3.getAbsolutePath();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys(path3);
		driver.findElement(By.name("submit")).click();
		
		String confMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(confMsg);
		
		String ActualResult = confMsg;

		if(ActualResult.contains(expres)) {
			System.out.println("Insert Product done sucessfully");
		}
		else {
			System.out.println("Insert Product not done");
		}

	}		
}


