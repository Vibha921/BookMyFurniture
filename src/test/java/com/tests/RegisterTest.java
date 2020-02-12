package com.tests;


import org.testng.annotations.Test;
import com.utils.BasePage;
public class RegisterTest extends BasePage{
  
  
  @Test
  public void regiister() {
	  //driver.findElement(By.cssSelector("#navbarSupportedContent > form > button.mat-button.mat-button-base.ng-star-inserted > span")).click();
	  test = extent.createTest("Register Test");
	  registerPage.clickOnSignInButton();
	  takeScreenShot("Clicked on sign in button");
	  registerPage.clickOnCreateAccount();
	  takeScreenShot("Clicked on create account");
	  registerPage.enterFullName(propertyReader.getProperty("NAME"));
	  takeScreenShot("Entered name");
	  registerPage.enterMobileNumber(propertyReader.getProperty("MOBILENUMBER"));
	  takeScreenShot("Entered mobile number");
	  registerPage.enterEmailId(propertyReader.getProperty("EMAILID"));
	  takeScreenShot("Entered email ID");
	  registerPage.enterPassword(propertyReader.getProperty("PASSWORD"));
	  takeScreenShot("Entered password");
	  registerPage.clickOnRegisterButton();
	  takeScreenShot("Registered successfully");		
	  
  }
   
}
