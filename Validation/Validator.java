package com.seveneleven.EmployePayrollApp.Validation;

public class Validator {

    private static String sanitize(String input) {
        if (input == null) {
            return "";
        }
        return input.trim();
    }

    public static void validateEmail(String email) throws EmailValidationException {

        email = sanitize(email);
        String email_regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!email.matches(email_regex)) {
            throw new EmailValidationException("Invalid email entered.");
        }
    }

    public static void validatePhone(String phone) throws PhoneValidationException {
        phone = sanitize(phone);
        String phone_regex = "^[6-9]\\d{9}$";

        if (!phone.matches(phone_regex)) {
            throw new PhoneValidationException("Invalid phone number entered.");
        }
    }

    public static void validatePassword(String password) throws PasswordValidationException {
        password = sanitize(password);
        if (password.length() < 6) {
            throw new PasswordValidationException("Password must be at least 6 characters.");
        }
    }

    public static void validateEmpId(String empId) throws EmployeeIdValidationException {
        empId = sanitize(empId);
        String empId_regex = "^EMP-\\d{4}$";
        if (!empId.matches(empId_regex)) {
            throw new EmployeeIdValidationException("Invalid Employee ID entered.");
        }
    }
}