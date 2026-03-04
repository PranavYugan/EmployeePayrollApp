package com.seveneleven.EmployePayrollApp.auth;

public abstract class User {
	protected String userName;
	protected String passwordHash;
	protected String role;
	
	public User(String userName,String password,String role) {
		this.userName=userName;
		this.passwordHash=PasswordUtil.hash(password);
		this.role=role;
				
	}
	
	public abstract boolean authenticate(String userName,String password);
	
	public String getRole() {
		return role;
	}
}
