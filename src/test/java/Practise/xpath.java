package Practise;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpath {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
 		WebDriver driver=new ChromeDriver();
 		driver.manage().window().maximize();
 		
 		//driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
 		
 		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
 		
 		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 		
 		//all team gold.silver,browen.etc
 		List<WebElement> team = driver.findElements(By.xpath("//span[text()='Argentina']/../.."));
 		
 		//all team rankings, matches,rating..etc
 		// List<WebElement> team = driver.findElements(By.xpath("//span[text()='India']/../.."));
 		
 		//to get team name oly
 		//List<WebElement> team = driver.findElements(By.xpath("//tbody/tr/td[2]"));
 		 
 		 int count=team.size();
 		for(int i=0;i<count;i++) {
 			String ranking = team.get(i).getText();
 			System.out.println(ranking);
 		}
 		 		
	}

}




















