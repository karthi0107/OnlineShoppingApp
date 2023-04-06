package subCategory_Module;

import java.util.Random;
import java.util.concurrent.TimeUnit;
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

import ObjectRepo.adminHomePage;
import ObjectRepo.admin_LoginPage;
import ObjectRepo.subCategoryPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Create_SubCategoryTest {

	public static void main(String[] args) throws Throwable {

		DataBaseUtility dLib = new DataBaseUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		//		driver.manage().window().maximize();
		//		Random r=new Random();
		//		int random = r.nextInt(10);

		wLib.MaxmizeWindow(driver);
		int RANDOM = jLib.random();
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");

		driver.get(URL);
		wLib.waitForPageLoad(driver);
		
//		driver.findElement(By.id("inputEmail")).sendKeys(USERNAME);
//		driver.findElement(By.name("password")).sendKeys(PASSWORD);
//		driver.findElement(By.name("submit")).click();
		
		admin_LoginPage l=new admin_LoginPage(driver);
		l.admin_LoginPage(USERNAME, PASSWORD);

		//		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		//		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		//		driver.findElement(By.name("password")).sendKeys("Test@123");
		//		driver.findElement(By.name("submit")).click();
		//		driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
		//		driver.findElement(By.name("category")).sendKeys(random+ExptResult);
		//		driver.findElement(By.name("description")).sendKeys("WaterBottel are container used to hold water,liquids,or other beverages for consumption");
		//		driver.findElement(By.name("submit")).click();
		
//		driver.findElement(By.xpath("//a[text()='Sub Category ']")).click();
//		
//		WebElement categoryDropdown = driver.findElement(By.name("category"));
//		categoryDropdown.click();
//
//		//		Select s=new Select(categoryDropdown);
//		//		s.selectByVisibleText("1WaterBottel");
//
//		wLib.select("1WaterBottel", categoryDropdown);
//		driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys("Stainless Steel2");
//		driver.findElement(By.name("submit")).click();
//
//		String confMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
//		System.out.println(confMsg);
		
		
		adminHomePage hp=new adminHomePage(driver);
		hp.subcategorylink();
		subCategoryPage sc = new subCategoryPage(driver);
	//	sc.createsubCategory(driver, eLib, jLib, wLib);
	}
}
