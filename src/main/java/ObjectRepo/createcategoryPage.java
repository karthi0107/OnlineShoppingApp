package ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaUtility;

public class createcategoryPage {


	@FindBy(name = "category")
	private WebElement createcategorytxtbx;

	@FindBy(name = "description")
	private WebElement createcategorydesc;

	@FindBy(name = "submit")
	private WebElement createbtn;

//		@FindBy(xpath = "//div[@class='alert alert-success']")
//		private WebElement confMsg;
		
	////	@FindBy(xpath = "//td[text()='"+RANDOM+categoryName+"']")
	////	private WebElement verify;
	//	
	//	@FindBy(xpath = "//a[@class='paginate_enabled_next']")
	//	private WebElement clickbtn;

	//	@FindBy(xpath = "")
	//	private WebElement 

	public createcategoryPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatecategorytxtbx() {
		return createcategorytxtbx;
	}

	public WebElement getCreatecategorydesc() {
		return createcategorydesc;
	}

	public WebElement getCreatebtn() {
		return createbtn;
	}

//		public WebElement getConfMsg() {
//			return confMsg;
//		}
	//
	//	public WebElement getClickbtn() {
	//		return clickbtn;
	//	}
	
	
	public String createcategory( JavaUtility jLib, ExcelUtility eLib, WebDriver driver ) throws Throwable {
		
		HashMap<String, String> map= eLib.readMultipleData("CreateCategory");
		String categoryname = null;

		for(Entry<String, String> set : map.entrySet()) {

			if(set.getKey().equalsIgnoreCase("category")) {  //this category is webelement key
				 categoryname = set.getValue()+jLib.random();
				driver.findElement(By.name(set.getKey())).sendKeys(categoryname);  //this for create category loop code
		
			}
			else {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()); //this is description loop code
			}
		}
		createbtn.click();
		return categoryname;
	}
}
