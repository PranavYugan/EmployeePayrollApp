package com.seveneleven.EmployePayrollApp.auth;

public class Manager extends User {
	
	public Manager(String userName,String password) {
		super(userName,password,"MANAGER");
	}
	
	public boolean authenticate(String userName,String password) {
		if(!this.userName.equals(userName)) {
			return false;
		}
		
		String hash=PasswordUtil.hash(password);
		return this.passwordHash.equals(hash);
	}
}
