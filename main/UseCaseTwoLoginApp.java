package com.seveneleven.EmployePayrollApp.main;

import com.seveneleven.EmployePayrollApp.auth.*;

public class UseCaseTwoLoginApp {
	public static void main(String[] args) {
		System.out.println("USE CASE 2 : EMPLOYEE AUTHENTICATION AND LOGIN");
		
		AuthenticationService authentication=new AuthenticationService();
		Session session = authentication.login();
		
		if(session != null) {
			System.out.println("\n" + session);
			
			if(!session.isExpired()) {
				System.out.println("Session active and valid");
			}
		}
	}
}
