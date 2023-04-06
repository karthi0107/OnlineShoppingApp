package Practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.protobuf.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT {

	public static void main(String[] args) {
		
		//notification popups
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notification");

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();

		driver.get("https://www.makemytrip.com/");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//close popup

		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();

		//select from city
		WebElement from = driver.findElement(By.xpath("//input[@id='fromCity']"));

		from.sendKeys("Bengulur");

		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();

		//select to city
		WebElement to = driver.findElement(By.xpath("//input[@id='toCity']"));

		to.sendKeys("coimbatore");

		driver.findElement(By.xpath("//p[text()='Coimbatore, India']")).click();
		
		
		
		//select travelling date example Fri Mar 17 2023

		String day = "Fri";
		String month = "Mar";
		String date = "17";
		String year = "2023";
		String traveldate = day+" "+ month+" "+ date+ " "+ year;
		
		
		driver.findElement(By.xpath("//div[@aria-label='"+traveldate+"']")).click();
		
		//select no of travelers
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom5']")).click();
		
		driver.findElement(By.xpath("//li[@data-cy='adults-2']"));
		
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		//click on search button
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
