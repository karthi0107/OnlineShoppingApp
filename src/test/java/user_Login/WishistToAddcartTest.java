package user_Login;

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

public class WishistToAddcartTest {

	public static void main(String[] args) throws Throwable {
		
		DataBaseUtility dLib = new DataBaseUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		String EProductname ="Aquva";

		String ETitle = "Order History";

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

		//click Wishlist Module
		driver.findElement(By.xpath("//a[text()='Wishlist']")).click();


		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();


		//Clicking MYCart Module
		driver.findElement(By.xpath("//a[text()='My Cart']")).click();



		//				String EPname = "AQUVA";
		//				
		//				String APname = driver.findElement(By.xpath("(//a[text()='Aquva'])[2]")).getText();
		//				
		//				//System.out.println(APname);
		//				
		//				 if(APname.contains(EPname)) {
		//					 System.out.println("Product is Moved Sucessfully from WishList to Mycart Page");
		//				 }
		//				 else {
		//					 System.out.println("Product is Not Moved from WishList to Mycart Page ");
		//				 }
	}

}
