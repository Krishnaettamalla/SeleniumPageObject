package org.hcl.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMathods extends BasePage {

	public static Logger logger = Logger.getLogger(ReusableMathods.class);

//	public static void highlightElement(WebElement ele) {
//		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].style.border=3px solid red",ele);
//	}
	public static void highlightElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", ele,
				"color: black; border: 4px solid red;");

	}

	public static void waitForElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}

	public static void setText(By by, String data) {
		WebElement ele = driver.findElement(by);
		highlightElement(ele);
		waitForElement(by);
		if (ele.isDisplayed()) {
			ele.sendKeys(data);
			logger.info("Data entered in :" + by);
		} else {
			logger.error("unable to enter data in:" + by);
		}
	}

	public static void click(By by) {
		WebElement ele = driver.findElement(by);
		highlightElement(ele);
		waitForElement(by);
		if (ele.isEnabled()) {
			ele.click();
			logger.info("Clicked element :" + by);
		} else {
			logger.error("unable to click element:" + by);
		}
	}

	public static void selectDropDownByID(By by, int index) {
		WebElement ele = driver.findElement(by);
		highlightElement(ele);
		waitForElement(by);
		if (ele.isDisplayed()) {
			Select select = new Select(ele);
			select.selectByIndex(index);
			logger.info("Selected Dropdown option from" + by);
		} else {
			logger.info("Unable to select DropDwon option" + by);
		}
	}

	public static void selectDropDownByValue(By by, String data) {
		WebElement ele = driver.findElement(by);
		highlightElement(ele);
		waitForElement(by);
		if (ele.isDisplayed()) {
			Select select = new Select(ele);
			select.selectByValue(data);
			logger.info("Selected Dropdown option from" + by);
		} else {
			logger.info("Unable to select DropDwon option" + by);
		}

	}

	public static void selectDropDownByVisibleText(By by, String data) {
		WebElement ele = driver.findElement(by);
		highlightElement(ele);
		waitForElement(by);
		if (ele.isDisplayed()) {
			Select select = new Select(ele);
			select.selectByVisibleText(data);
			logger.info("Selected Dropdown option from" + by);
		} else {
			logger.info("Unable to select DropDwon option" + by);
		}
	}
}
