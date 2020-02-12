package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.utils.Utilities;

public class RegisterPage extends Utilities {

	@FindBy(css = "div.sign-up-main > div > form > div:nth-child(3) > input")
	WebElement EMAIL_ID;

	@FindBy(id = "name")
	WebElement FULL_NAME;

	@FindBy(id = "mobileNo")
	WebElement MOBILE_NUMBER;

	@FindBy(css = "div.sign-up-main > div > form > div:nth-child(4)> div > input")
	WebElement PASSWORD;

	@FindBy(css = "body > app-root > bmf-layout > div:nth-child(2) > app-login > div > div > div.row > div.col-md-5.mt-5.ng-star-inserted > form > div.row > div:nth-child(1) > button")
	WebElement LOG_IN;

	@FindBy(css = "#navbarSupportedContent > form > button.mat-button.mat-button-base.ng-star-inserted > span")
	WebElement SIGN_IN;

	@FindBy(css = "body > app-root > bmf-layout > div:nth-child(2) > app-login > div > div > div.row > div.col-md-4 > h3 > div > div:nth-child(2) > button")
	WebElement CREATE_ACCOUNT;

	@FindBy(css = "div.sign-up-main > div > form > div:nth-child(5) > div > button.btn-primary")
	WebElement REGISTER_BUTTON;


	public void clickOnSignInButton() {
		clickOnElement(SIGN_IN);
	}

	public void enterFullName(String fullName) {
		sendKeysToElement(FULL_NAME, fullName);
	}

	public void enterMobileNumber(String mobileNumber) {
		sendKeysToElement(MOBILE_NUMBER, mobileNumber);
	}

	public void enterEmailId(String mailId) {
		sendKeysToElement(EMAIL_ID, mailId);;
	}

	public void enterPassword(String password) {
		sendKeysToElement(PASSWORD, password);
		PASSWORD.sendKeys(Keys.TAB);
	}

	public void clickOnRegisterButton() {
		clickOnElement(REGISTER_BUTTON);
	}

	public void clickOnLoginButton() {
		clickOnElement(LOG_IN);
	}

	public void clickOnCreateAccount() {
		clickOnElement(CREATE_ACCOUNT);
	}

}
