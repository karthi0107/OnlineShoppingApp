package Practise;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.JavaUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgCreateProject  {
	
	DataBaseUtility dLib = new DataBaseUtility(); 

	public static void main(String[] args) throws Throwable {
		
		String EResult = "Online Shop App";
		Connection con=null;
		
		try {
		WebDriverManager.chromedriver().setup();
		
//		Random r=new Random();
//		int random = r.nextInt(10);
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://rmgtestingserver:8084/");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();

		driver.findElement(By.name("projectName")).sendKeys(EResult);
		driver.findElement(By.name("createdBy")).sendKeys("Karthikeyan");

		WebElement Status = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s=new Select(Status);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		

		Driver	driver1=new Driver();
		DriverManager.registerDriver(driver1);
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query = "select * from project;";
		ResultSet result = state.executeQuery(query);

		boolean flag=false;
		while(result.next()) {
			String AResult = result.getString(4);
			System.out.println(AResult);
			if(AResult.equalsIgnoreCase(EResult)) {
				flag=true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("Project is created");
		}
		else {
			System.out.println("Project is not Created");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {
			con.close();
		}
	}
}
