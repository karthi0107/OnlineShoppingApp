package user_Login;

import java.util.Scanner;
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

public class Mycart_ModuleTest {
	static Scanner sc=new Scanner(System.in);

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



		//
		//		String AProductname = driver.findElement(By.xpath("//a[text()='"+EProductname+"']")).getText();
		//
		//
		//		if(AProductname.contains(EProductname)) {
		//			System.out.println("Product is Displayed");
		//		}
		//		else {
		//			System.out.println("Product is Not Displayed ");
		//		}

		//adding the product to cart
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();


		//handling Alert Exception
		//driver.switchTo().alert().accept();
		wLib.acceptAlert(driver);


		//Clicking MYCart Module
		driver.findElement(By.xpath("//a[text()='My Cart']")).click();


		//		//Entering Shipping/Billing Address
		//		
		//		driver.findElement(By.name("billingaddress")).sendKeys("VNB");




		//click on Procced to check out
		driver.findElement(By.name("ordersubmit")).click();

		//select payment option ----->COD/InternetBAnking/Debit/CreditCard

		System.out.println("Enter the payment option");
		String paymentoption = sc.nextLine();

		if(paymentoption.equals("COD")) {
			driver.findElement(By.xpath("//input[@value='COD']")).click();
		}

		else if(paymentoption.equals("Internet Banking")) {
			driver.findElement(By.xpath("//input[@value='Internet Banking']")).click();
		}
		else if(paymentoption.equals("Debit/Creditcard")){
			driver.findElement(By.xpath("//input[@value='Debit / Credit card']")).click();
		}


		//click on submit button
		driver.findElement(By.name("submit")).click();


		//Verifying product is order or not 
		String ETitle = "Order History";
		String actualTitle = driver.getTitle();

		if(actualTitle.contains(ETitle)) {
			System.out.println("Product ordered Sucessfully ");
		}
		else {
			System.out.println("Product Not Ordered");
		}



	}

}
