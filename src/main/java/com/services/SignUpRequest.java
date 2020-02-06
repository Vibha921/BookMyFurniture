package com.services;

import org.apache.log4j.Category;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.utils.BasePage;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SignUpRequest extends BasePage{

	JSONObject signUpRequest = new JSONObject();
	
	public RequestSpecification request = null;
	Response signUpResponse = null;
	
	@SuppressWarnings("unchecked")
	public JSONObject constructSignUpRequest(SignUpData obj) {
		signUpRequest.put("name", obj.getName());
		signUpRequest.put("mobileNo", obj.getMobileNumber());
		signUpRequest.put("emailId", obj.getEmailId());
		signUpRequest.put("password", obj.getPassword());
		return signUpRequest;	
	}
	
	public void signUpService(SignUpData obj) {
		request = setBaseUri("signup");
		request.body(constructSignUpRequest(obj));
		log.info(signUpRequest);
		signUpResponse = (Response) request.when().post();	
		log.info(signUpResponse.prettyPrint());
	}
	
	public void verifyStatusCode() {
//		Assert.assertEquals(signUpResponse.getStatusCode(), 200);
	}
}
