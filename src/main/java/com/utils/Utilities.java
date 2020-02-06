package com.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities extends BasePage {

	Select select;
	public static long DEFAULT_TIMEOUT = 30;

	public WebElement waitForElement(WebElement element, long timeout) {
		WebElement webElement = null;

		try {
			webElement = new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
			moveToElement(webElement);
		}
		catch(Exception e){
			if(webElement == null) {
				log.error("Element not found");
				return null;
			}
		}

		return webElement;

	}

	public void sendKeysToElement(WebElement element, String textToBeEntered) {
		try {
			waitForElement(element, DEFAULT_TIMEOUT);
			element.sendKeys(textToBeEntered);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnElement(WebElement element) {
		try {
			waitForElement(element, DEFAULT_TIMEOUT);
			element.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyElementFound(WebElement element) {
		try {
			waitForElement(element, DEFAULT_TIMEOUT); 
			if(element.isDisplayed())
				return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}


		return false;
	}

	public void initializeSelectObject(WebElement element) {
		try {
			waitForElement(element, DEFAULT_TIMEOUT);
			select = new Select(element);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void selectElementByValue(WebElement element, String value) {
		initializeSelectObject(element);
		select.selectByValue(value);
	}

	public void selectElementByVisibleText(WebElement element, String text) {
		initializeSelectObject(element);
		select.selectByVisibleText(text);
	}

	public void selectMultipleElementsByVisibleText(WebElement element, String text, String textTwo) {
		initializeSelectObject(element);
		if(select.isMultiple()) {
			select.selectByVisibleText(text);
			select.selectByVisibleText(textTwo);
		}
		else {
			log.info("Multiple elements canot be selected in a dropdown");
		}

	}

	public Boolean verifyElementSelected(WebElement element) {
		waitForElement(element, DEFAULT_TIMEOUT);
		return (element.isSelected());
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void moveToElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element);
	}






}
