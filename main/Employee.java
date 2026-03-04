package com.seveneleven.EmployePayrollApp.main;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Employee {
	private String empID;
	private String email;
	private String name;
	private String phone;
	
	
	private UserAccount useraccount;
	
	public Employee(String empID,String email,String name,String phone,UserAccount useraccount) {
		this.empID=empID;
		this.email=email;
		this.phone=phone;
		this.name=name;
		this.useraccount=useraccount;
	}
	
	public String toString() {
		return "Employee Registered Successfully\n" +
				"Employee ID : " + empID + "\n" +
				"Name :" + name + "\n" +
				"Email ID : " + email + "\n" +
				"Phone Number : " + phone + "\n" +
				"User Name : " + useraccount.getUserName();		
	}
	
	
	public void persist() throws IOException{
		
		try (FileWriter writer = new FileWriter(empID + ".txt")) {
	        writer.write("Employee ID: " + empID + "\n");
	        writer.write("Name: " + name + "\n");
	        writer.write("Email: " + email + "\n");
	        writer.write("Phone Number: " + phone + "\n");
	        System.out.println("Successfully written to file.");
	    } catch (IOException e) {
	        System.out.println("Error writting into file: " + e.getMessage());
	    }

	}
}
