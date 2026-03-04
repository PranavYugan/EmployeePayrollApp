package com.seveneleven.EmployePayrollApp.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserAccount {
	private String userName;
	private String password;
	

	
	UserAccount(String userName,String password){
		this.userName=userName;
		this.password=password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
