package com.tests;


import org.testng.annotations.Test;
import com.utils.BasePage;
public class RegisterTest extends BasePage{
  
  
  @Test
  public void regiister() {
	  //driver.findElement(By.cssSelector("#navbarSupportedContent > form > button.mat-button.mat-button-base.ng-star-inserted > span")).click();
	  /*registerPage.clickOnSignInButton();
	  registerPage.clickOnCreateAccount();
	  registerPage.enterFullName("Chandler Bing");
	  registerPage.enterMobileNumber("7829233260");
	  registerPage.enterEmailId("Chandler.Bing@friends.com");
	  registerPage.enterPassword("ChandlerBing@2020!");
	  registerPage.clickOnRegisterButton();*/
	  
	  test = extent.createTest("PracticeTest");
//		auotmationPracticePage.uplaodTextFile();
//		takeScreenShot("Uploaded");
		auotmationPracticePage.selectMultipleElementsFromDropDrowm();
		takeScreenShot("Selected multiple elements");
		auotmationPracticePage.clickOnRadioButton();
		takeScreenShot("Clicked on radio button");
		auotmationPracticePage.verifyRadioButtonIsSelected();
		takeScreenShot("Verified radio button");
		auotmationPracticePage.clickOnCheckBox();
		takeScreenShot("Clicked on check box");
		auotmationPracticePage.verifyCheckBoxIsChecked();
		takeScreenShot("Verified check box");
		
	  
  }
   
}
