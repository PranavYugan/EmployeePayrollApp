package com.seveneleven.EmployePayrollApp.main;
import java.io.IOException;
import java.util.*;
/**
 * Goal of this use case:
 * - Introduce inheritance and polymorphism
 * - Show how different user types share common behaviour
 * - Demonstrate a simple authentication flow
 * 
 */
import com.seveneleven.EmployePayrollApp.Validation.*;
public class EmployeePayrollApp {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		try {
			System.out.println("USE CASE 1 : EMPLOYEE REGISTRATION");
			System.out.println();
			System.out.println("Enter your email :" );
			String email=sc.nextLine();
			Validator.validateEmail(email);
			System.out.println("Enter your Employee ID :" );
			String empId=sc.nextLine();
			Validator.validateEmpId(empId);
			System.out.println("Enter your Phone number :" );
			String phone=sc.nextLine();
			Validator.validatePhone(phone);
			System.out.println("Enter your Name :" );
			String name=sc.nextLine();
			System.out.println("Enter your User Name :" );
			String userName=sc.nextLine();
			System.out.println("Enter your Password :" );
			String password=sc.nextLine();
			
			UserAccount userAccount=new UserAccount(userName,password);
			Employee employee=new Employee(empId,email,name,phone,userAccount);
			
			System.out.println(employee.toString());
			employee.persist();
		}
		catch(ValidationException e) {
			System.out.println("Validation failed: " + e.getMessage());
		}
		catch(IOException e) {
			System.out.println("Error saving employee data.");
		}
		
		
		
	}
}
