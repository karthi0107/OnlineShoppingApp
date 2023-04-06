package Practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spicejet {

public static void main(String[] args) {
		
		//notification popups
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notification");

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();

		driver.get("https://www.spicejet.com/");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.switchTo().alert().accept();
		//close popup
		//select from city
		
//		WebElement from = driver.findElement(By.xpath("//div[text()='From']"));
//
//		from.sendKeys("Bengulur");
//		
//		driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
//
//		WebElement to = driver.findElement(By.xpath("//div[text()='To']"));
//
//		to.sendKeys("coimbatore");
//		
//		driver.findElement(By.xpath("//div[text()='Coimbatore']")).click();
//		
//		driver.findElement(By.xpath("(//div[text()='18'])[1]"));
















	

}
}
