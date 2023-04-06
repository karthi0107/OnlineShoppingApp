package createcategory_Module;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

import ObjectRepo.adminHomePage;
import ObjectRepo.admin_LoginPage;
import ObjectRepo.createcategoryPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_CategoryTest {

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
		
//		driver.manage().window().maximize();
//		Random r=new Random();
//		int random = r.nextInt(10);

		//String ExptResult = "WaterBottel";
		
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
		
		adminHomePage hp=new adminHomePage(driver);
		hp.CreateCategorylink();

		//driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
		
//		String categoryName = eLib.readDataFromExcel("CreateCategory", 0, 0);
//		String description = eLib.readDataFromExcel("CreateCategory", 0, 1);

//		driver.findElement(By.name("category")).sendKeys(RANDOM+categoryName);
//		driver.findElement(By.name("description")).sendKeys(description);
//
//		driver.findElement(By.name("submit")).click();
		
		createcategoryPage createcategory = new createcategoryPage(driver);
		createcategory.createcategory(jLib, eLib, driver);
		

//		String confMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
//
//		System.out.println(confMsg);
//
//
//		for(; ;) {
//			try {
//				String verify = driver.findElement(By.xpath("//td[text()='"+RANDOM+categoryName+"']")).getText();
//				System.out.println(verify);
//				break;
//			}
//			catch (Exception e) {
//				// TODO: handle exception
//				driver.findElement(By.xpath("//a[@class='paginate_enabled_next']")).click();
//
//			}
//		}
//		String ActualResult = confMsg;
//		 
//		 if(ActualResult.contains(categoryName)) {
//			 System.out.println("Category created sucessfully");
//		 }
//		 else {
//			 System.out.println("Category not created ");
//		 }
//
}
}
