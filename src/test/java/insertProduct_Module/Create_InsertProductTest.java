package insertProduct_Module;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_InsertProductTest {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		//	Random r=new Random();
		//	int random = r.nextInt(10);

		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.name("submit")).click();
		
		
		String expres = "Well done! Product Inserted Successfully !!";
		

		driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();

		WebElement categoryDropdown = driver.findElement(By.name("category"));

		categoryDropdown.click();

		Select s=new Select(categoryDropdown);

		s.selectByVisibleText("1WaterBottel");

		WebElement subcategoryDropdown = driver.findElement(By.id("subcategory"));

		subcategoryDropdown.click();

		Select s1=new Select(subcategoryDropdown);

		s1.selectByVisibleText("Stainless Steel Temp");

		
		
		driver.findElement(By.name("productName")).sendKeys("Aquva");

		driver.findElement(By.name("productCompany")).sendKeys("VK Group");

		driver.findElement(By.name("productpricebd")).sendKeys("1000Rs");

		driver.findElement(By.name("productprice")).sendKeys("850Rs");

		driver.findElement(By.name("productDescription")).sendKeys("WaterBottel are container used to hold water,liquids");

		driver.findElement(By.name("productShippingcharge")).sendKeys("50Rs");

	
		WebElement Productavailable = driver.findElement(By.xpath("//select[@name='productAvailability']"));
				
		Select s2=new Select(Productavailable);

		s2.selectByValue("In Stock");
		
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





