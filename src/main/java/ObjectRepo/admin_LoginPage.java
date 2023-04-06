package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class admin_LoginPage {


	//declaration
	@FindBy(id="inputEmail")
	private WebElement UsernameEdt;

	@FindBy(name="password")
	private WebElement Pwd;

	@FindBy(name="submit")
	private WebElement lgbt;

	//initialization

	public admin_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPwd() {
		return Pwd;
	}

	public WebElement getLgbt() {
		return lgbt;
	}


	//Business Libraries
	
	public void admin_LoginPage(String USERNAME, String PASSWORD) {
		
		UsernameEdt.sendKeys(USERNAME);
		Pwd.sendKeys(PASSWORD);
		lgbt.click();
		}
	












}


