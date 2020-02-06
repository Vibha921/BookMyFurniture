package com.services;

public class SignUpData {

	public String name, emailId, password, mobileNumber;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setMobileNumber(String mobile) {
		this.mobileNumber = mobile;
	}

	public void setEmailId(String email) {
		this.emailId = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public String getPassword() {
		return this.password;
	}


}
