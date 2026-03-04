package com.seveneleven.EmployePayrollApp.auth;

public class Session {
	private String userName;
	private long loginTime;
	private long timeoutMillis;
	
	public Session(String userName) {
		this.userName=userName;
		this.loginTime=System.currentTimeMillis();
		this.timeoutMillis=300000;
	}
	
	public boolean isExpired() {
		long current=System.currentTimeMillis();
		return (current-loginTime) > timeoutMillis;
	}
	
	public String toString() {
		return "Session active for user: " + userName;
	}
}
