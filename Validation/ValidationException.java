package com.seveneleven.EmployePayrollApp.Validation;

/**
 * This class represents a validation-related problem.
 * 
 *  why this exists:
 *  Instead of stopping the program abruptly,
 *  we clearly communicate what went wrong
 */
public class ValidationException extends Exception {
	public ValidationException(String message) {
		super(message);
	}
}
