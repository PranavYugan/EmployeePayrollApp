package com.seveneleven.EmployePayrollApp.Validation;

//Validator class to check phone number , email and employee id entered is of correct format.
public class Validator {
	public static void validatePhone(String phone) throws ValidationException {
		String phone_regex= "^[6-9]\\d{9}$";
		if(!phone.matches(phone_regex)) {
			throw new ValidationException("Invalid Phone number entered.");
		}
		
	}
	
	public static void validateEmail(String email) throws ValidationException {
		String email_regex= "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		if(!email.matches(email_regex)) {
			throw new ValidationException("Invalid email entered.");
		}
		
	}
	
	public static void validateEmpId(String empId) throws ValidationException {
		String empId_regex= "^EMP-\\d{4}$";
		if(!empId.matches(empId_regex)) {
			throw new ValidationException("Invalid Employee ID entered.");
		}
		
	}
	
}
