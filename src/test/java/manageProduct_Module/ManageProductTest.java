package manageProduct_Module;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageProductTest {

	public static void main(String[] args) {
		
		DataBaseUtility dLib = new DataBaseUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
//		Random r=new Random();
//		int random = r.nextInt(10);
				
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[text()='Manage Products ']")).click();
		
		
		for(; ;) {
			try {
				String verify = driver.findElement(By.xpath("//td[text()='Aquva']")).getText();
				System.out.println(verify);
				break;
			}
			catch (Exception e) {
				// TODO: handle exception
				driver.findElement(By.xpath("//a[@class='paginate_enabled_next']")).click();
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
