package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminHomePage {
	
	
	@FindBy(xpath="//a[text()=' Create Category ']")
	private WebElement CreateCategorylink;
	
	@FindBy(xpath="//a[text()='Sub Category ']")
	private WebElement subcategorylink;
	
	@FindBy(xpath="//a[text()='Insert Product ']")
	private WebElement insertproductlink;
	
	
	@FindBy(xpath="//a[text()='Manage Products ']")
	private WebElement manageproductlink;
	
	@FindBy(xpath="//a[text()='User Login Log ']")
	private WebElement userloglink;
	
	@FindBy(xpath="//a[contains(.,'Manage users')]")
	private WebElement manageuserslink;
	
	@FindBy(xpath="//a[contains(.,'Order Management')]")
	private WebElement ordermanagementlink;
	
	@FindBy(xpath="//a[@href='todays-orders.php']")
	private WebElement todayorderlink;
	
	@FindBy(xpath="//a[text()='Sub Category ']")
	private WebElement pendingorderlink;
	
	@FindBy(xpath="//a[text()='Sub Category ']")
	private WebElement deliveredlink;
	
	@FindBy(xpath="(//a[contains(.,'Logout')])[2]")
	private WebElement logoutlink;
	

	
	public adminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateCategorylink() {
		return CreateCategorylink;
	}

	public WebElement getSubcategorylink() {
		return subcategorylink;
	}

	public WebElement getInsertproductlink() {
		return insertproductlink;
	}

	public WebElement getManageproductlink() {
		return manageproductlink;
	}

	public WebElement getUserloglink() {
		return userloglink;
	}

	public WebElement getManageuserslink() {
		return manageuserslink;
	}

	public WebElement getOrdermanagementlink() {
		return ordermanagementlink;
	}

	public WebElement getTodayorderlink() {
		return todayorderlink;
	}

	public WebElement getPendingorderlink() {
		return pendingorderlink;
	}
	
	public WebElement getDeliveredlink() {
		return deliveredlink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}

	
//business 
	public void CreateCategorylink() {
		CreateCategorylink.click();
	}
	
	public void subcategorylink() {
		subcategorylink.click();
	}
	
	public void insertproductlink() {
		insertproductlink.click();
	}
	
	public void manageproductlink() {
		manageproductlink.click();
	}
	
	public void userloglink() {
		userloglink.click();
	}
	
	public void manageuserlink() {
		manageuserslink.click();
	}
	
	public void ordermanagementlink() {
		ordermanagementlink.click();
	}
	
	public void todayorderlink() {
		todayorderlink.click();
	}
	
	public void pendingorderlink() {
		pendingorderlink.click();
	}
	
	public void deliveredlink() {
		deliveredlink.click();
	}
	
	public void logoutlink() {
		logoutlink.click();
	}
	
	
	
}
