package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	/**
	 * this method will be used to Max the browser
	 * @param driver
	 */

	public void MaxmizeWindow(WebDriver driver) {

		driver.manage().window().maximize();

	}

	/**
	 * this method will be used to implicity wait
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//OR
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * this method will be used to Explicity wait
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver, WebElement element) {

		WebDriverWait wait =new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This Method will select the data from dropdown using value
	 * @param element
	 * @param value
	 */

	public void select(WebElement element, String value) {

		Select sel= new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This Method will select the data from dropdown using index
	 * @param element
	 * @param Index
	 */
	public void select(WebElement element, int Index) {

		Select sel= new Select(element);
		sel.selectByIndex(Index);
	}
	/**
	 * This Method will select the data from dropdown using visibleText
	 * @param visibleText
	 * @param element
	 */
	public void select(String visibleText, WebElement element ) {

		Select sel= new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	/**
	 * This method will perform mousehover action
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	/**
	 * This method will perform dragAnddrop action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dst) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	/**
	 * This method will perform doubleClick action
	 * @param driver
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perform rightClick action
	 * @param driver
	 */
	public void rightClick(WebDriver driver,WebElement element ) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * this method will press enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * this method will press enter key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 *  this method will release enter key
	 * @param driver
	 * @throws Throwable
	 */

	public void enterReleasekey(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * this method will switch the frame based on index
	 * @param driver
	 * @param address
	 */

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this method will switch the frame based on nameorid
	 * @param driver
	 * @param address
	 */

	public void switchToFrame(WebDriver driver, String nameorid) {
		driver.switchTo().frame(nameorid);
	}

	/**
	 * this method will switch the frame based on address
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}

	/*
	 *this method is used to accept alert popup 
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method is used to cancel alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}


	public void switchTowindow(WebDriver driver, String partialTitle) {

		//step 1: use getwindowhandels to capture all window id's
		Set<String> windows = driver.getWindowHandles();

		//step 2: iterator through the windows
		Iterator<String> it = windows.iterator();

		//step3: check whether ther is next window
		while(it.hasNext()) {
			//step4: capture current window id
			String winId = it.next();

			//step5: switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();

			//step 6:check wheather current window is expected
			if(currentWinTitle.contains(partialTitle)) {
				break;
			}
		}
	}


	/**
	 * this method will take screenshot and store it in folder called as screenshot
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */

	public static String getScreenshot(WebDriver driver, String screenShotName) throws Throwable {

		TakesScreenshot ts=(TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenShotName+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return path;	
	}


	/**
	 * this method will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)", "");
	}


	/**
	 * this method will scroll untill specified element is found 
	 * @param driver
	 * @param element
	 */

	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		//jse.executeScript("argument[0],.scrollIntoView()", element);

	}
}
