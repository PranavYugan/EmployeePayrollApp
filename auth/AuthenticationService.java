package com.seveneleven.EmployePayrollApp.auth;

import java.util.Map;
import java.util.*;

public class AuthenticationService {
	private Map<String,User> users=new HashMap<>();
	private int maxAttempts=3;
	
	public AuthenticationService() {
		users.put("emp1", new RegularEmployee("emp1","Emp@1234"));
		users.put("manager1", new Manager("manager1","Mng@1234"));
	}
	
	private void showDashboard(String role) {
		System.out.println("DashBoard");
		System.out.println();
		if(role.equals("EMPLOYEE")){
			System.out.println("Employee Dashboard");
			System.out.println("View Payslip | Update Profile");
		}
		else {
			System.out.println("Manager Dashboard");
			System.out.println("Approve Payroll | View Reports");
		}
	}
	public Session login() {
		Scanner sc=new Scanner(System.in);
		
		int attempts=0;
		while(attempts<maxAttempts) {
			System.out.println("Enter Username: ");
			String userName=sc.nextLine();
			System.out.println("Enter Password: ");
			String password=sc.nextLine();
			
			User user=users.get(userName);
			
			if(user != null && user.authenticate(userName, password)) {
				System.out.println("Login successful");
				System.out.println("Role : " + user.getRole());
				showDashboard(user.getRole());
				return new Session(userName);
			}
			
			attempts++;
			System.out.println("Invalid credentials . " + (maxAttempts-attempts) + " attempts left");
		}
		System.out.println("Maximum attempts exceeded");
		
		return null;
	}
}
