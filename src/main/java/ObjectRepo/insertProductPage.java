package ObjectRepo;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class insertProductPage {

	
	@FindBy(name = "category")
	private WebElement categoryNameDropdown;
	
	@FindBy(name = "subcategory")
	private WebElement subcategoryDropdown;
	
	@FindBy(name = "productName")
	private WebElement productNametxt;
	
	@FindBy(name = "productCompany")
	private WebElement productCompany ;
	
	@FindBy(name = "productpricebd")
	private WebElement productpricebd;
	
	@FindBy(name = "productprice")
	private WebElement productprice ;
	
	@FindBy(name = "productDescription")
	private WebElement productDescription;
	
	
	@FindBy(name = "productShippingcharge")
	private WebElement productShippingcharge;
	
	@FindBy(xpath = "//select[@name='productAvailability']")
	private WebElement productAvailability;
	
	@FindBy(xpath = "//input[@name='productimage1']")
	private WebElement productimage1;
	
	@FindBy(xpath = "//input[@name='productimage2']")
	private WebElement productimage2;
	
	@FindBy(xpath = "//input[@name='productimage3']")
	private WebElement productimage3;
	
	
	
	
	public insertProductPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}


	public WebElement getProductNametxt() {
		return productNametxt;
	}


	public WebElement getProductCompany() {
		return productCompany;
	}


	public WebElement getProductpricebd() {
		return productpricebd;
	}


	public WebElement getProductprice() {
		return productprice;
	}


	public WebElement getProductDescription() {
		return productDescription;
	}


	public WebElement getProductShippingcharge() {
		return productShippingcharge;
	}


	public WebElement getProductAvailability() {
		return productAvailability;
	}


	public WebElement getProductimage1() {
		return productimage1;
	}


	public WebElement getProductimage2() {
		return productimage2;
	}


	public WebElement getProductimage3() {
		return productimage3;
	}
	
	
	
	public void insertProduct(WebDriverUtility wLib, JavaUtility jLib, ExcelUtility eLib, WebDriver driver,String categoryname,String subcatname) throws Throwable {
	
		wLib.select(categoryname, categoryNameDropdown);
		wLib.select(subcatname, subcategoryDropdown);
		
		 HashMap<String, String> map = eLib.readMultipleData("InsertProduct");
		
		for(Entry<String, String> set:map.entrySet()) {
			
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		wLib.select("In Stock", productAvailability);
		
		String[] imagePaths = {"./dataImg/img1.png","./dataImg/img2.png","./dataImg/img3.png"};
		int inputNum = 1;
		for(String imagepath:imagePaths) {
			File imagefile = new File(imagepath);
			String absolutepath = imagefile.getAbsolutePath();
			String inputname = "productimage" + inputNum;
			WebElement inputFile = driver.findElement(By.xpath("//input[@name='" + inputname + "']"));
			inputFile.sendKeys(absolutepath);
			inputNum++;
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
