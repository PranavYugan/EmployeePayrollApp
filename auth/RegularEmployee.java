package com.seveneleven.EmployePayrollApp.auth;

public class RegularEmployee extends User {
	
	public RegularEmployee(String userName,String password) {
		super(userName,password,"EMPLOYEE");
	}
	
	public boolean authenticate(String userName,String password) {
		if(!this.userName.equals(userName)) {
			return false;
		}
		
		String hash=PasswordUtil.hash(password);
		return this.passwordHash.equals(hash);
	}
}
