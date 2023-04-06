package Practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firofixclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//driver.get("www.gmail.com");
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
	}

}
