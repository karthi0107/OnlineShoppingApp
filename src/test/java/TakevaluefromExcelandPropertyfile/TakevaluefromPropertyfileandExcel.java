package TakevaluefromExcelandPropertyfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakevaluefromPropertyfileandExcel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");

		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Ty.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();


		Random r=new Random();
		int random = r.nextInt(10);

//		String ExptResult = "WaterBottel";

		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("inputEmail")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();

		driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();

		HashedMap<String, String> map = new HashedMap<String, String>();
		for(int i=0;i<=sh.getLastRowNum();i++) {

			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);

		}

		for(Entry<String, String> set:map.entrySet()) {

			driver.findElement(By.name(set.getKey())).sendKeys(random+set.getValue());
		}

		driver.findElement(By.name("submit")).click();
	}

}
