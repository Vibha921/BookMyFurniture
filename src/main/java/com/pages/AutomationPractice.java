package com.pages;



	import org.junit.Assert;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import com.utils.Utilities;

	public class AutomationPractice extends Utilities {

		@FindBy(id = "sex-1")
		WebElement radioButton;
		
		@FindBy(id = "profession-1")
		WebElement checkBox;
		
		@FindBy(id = "continentsmultiple")
		WebElement continents;
		
		@FindBy(partialLinkText = "Partial Link Test")
		WebElement partialText;
		
		@FindBy(linkText = "Link Test")
		WebElement linkTest;
		
		@FindBy(id = "photo")
		WebElement uploadFile;
		
		@FindBy(linkText = "Test File to Download")
		WebElement downloadFile;
		
		
		public void verifyRadioButtonIsSelected() {
			Assert.assertTrue(verifyElementSelected(radioButton));
		}
		
		public void clickOnRadioButton() {
			clickOnElement(radioButton);
		}
		
		public void clickOnCheckBox() {
			clickOnElement(checkBox);
		}
		
		public void verifyCheckBoxIsChecked() {
			Assert.assertTrue(verifyElementSelected(checkBox));
		}
		
		public void selectMultipleElementsFromDropDrowm() {
			selectMultipleElementsByVisibleText(continents, "North America",  "Antarctica");
		}
		
		public void uplaodTextFile() {
			sendKeysToElement(uploadFile, "C:/Users/M1037414/Desktop/SampleText.txt");
		}
		
		public void launchForm(String url) {
			getUrl(url);
		}
		
		
		
		
		
	}

