package Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Arraylist {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
	
		
 		WebDriver driver=new ChromeDriver();
 		driver.manage().window().maximize();
 		
 		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
 		
 		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 		
 		 List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
 		ArrayList<String> list = new ArrayList<String>();
	
 		for(int i=0;i<teams.size();i++) {
		list.add(teams.get(i).getText());
	}
	
 		for(String myteams:list) {
		
 			String rating = "//span[text()='"+myteams+"']/../following-sibling::td[3]";
 			String Rating = driver.findElement(By.xpath(rating)).getText();
 			System.out.println(myteams + " " + Rating);
	}
 		
	
}
}
