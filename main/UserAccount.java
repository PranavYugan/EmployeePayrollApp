package com.seveneleven.EmployePayrollApp.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserAccount {
	private String userName;
	private String hashPassword;
	
	public static String hash(String password) throws RuntimeException {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			byte[] hashBytes = digest.digest(password.getBytes());

			StringBuilder hexString = new StringBuilder();
			for(byte b : hashBytes) {
				String hex = Integer.toHexString(0xff & b);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Issue in Hashing");
		}
	}
	
	UserAccount(String userName,String password){
		this.userName=userName;
		this.hashPassword=hash(password);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
