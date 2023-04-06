package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class subCategoryPage {
	
	
	@FindBy(name = "category")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "//input[@name='subcategory']")
	private WebElement subcategorytxt;
	
	@FindBy(name = "submit")
	private WebElement subcreatebtn;
	
//	@FindBy(xpath = "//div[@class='alert alert-success']")
//	private WebElement subcategoryconfMsg;
	
	
	
	public subCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}

	public WebElement getSubcategorytxt() {
		return subcategorytxt;
	}

	public WebElement getSubcreatebtn() {
		return subcreatebtn;
	}
	
//	public WebElement getConfMsg() {
//		return subcategoryconfMsg;
//	}
	

	public String createsubCategory(WebDriver driver, ExcelUtility eLib, WebDriverUtility wLib,String categoryname) throws Throwable {
		
		wLib.select(categoryname, categoryDropdown);
		
		String subCatname = eLib.readDataFromExcel("SubCategory", 0, 0);
		subcategorytxt.sendKeys(subCatname);
		subcreatebtn.click();
		
		return subCatname;
		
//		subcategoryconfMsg.getText();
//		System.out.println(subcategoryconfMsg);
		
		
	}
}
