package com.tests;

import org.testng.annotations.Test;

import com.services.SignUpData;
import com.services.SignUpRequest;
import com.utils.BasePage;

public class RegisterService extends BasePage{

	SignUpRequest request = new SignUpRequest();
	public SignUpData signUp = new SignUpData();
	
	@Test
	public void signUpServiceRequest() {
		test = extent.createTest("rigister");
		signUp.setName(propertyReader.getProperty("NAME"));
		signUp.setPassword(propertyReader.getProperty("PASSWORD"));
		signUp.setEmailId(propertyReader.getProperty("EMAILID"));
		signUp.setMobileNumber(propertyReader.getProperty("MOBILENUMBER"));
		request.signUpService(signUp);
		request.verifyStatusCode();
	}
}
