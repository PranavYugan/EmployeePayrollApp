package com.seveneleven.EmployePayrollApp.main;

import java.io.IOException;
import java.util.Scanner;

import com.seveneleven.EmployePayrollApp.Validation.*;
import com.seveneleven.EmployePayrollApp.auth.*;
import com.seveneleven.EmployePayrollApp.salaryservice.*;

public class EmployeePayrollApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee registeredEmployee = null;
        boolean exit = false;

        while (!exit) {
            System.out.println("=====================================");
            System.out.println("EMPLOYEE PAYROLL APPLICATION");
            System.out.println("=====================================");
            System.out.println("1. Employee Registration");
            System.out.println("2. Employee Login");
            System.out.println("3. Generate Payslip");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.println("USE CASE 1 : EMPLOYEE REGISTRATION");
                        System.out.println();

                        System.out.print("Enter your email: ");
                        String email = sc.nextLine();
                        Validator.validateEmail(email);

                        System.out.print("Enter your Employee ID: ");
                        String empId = sc.nextLine();
                        Validator.validateEmpId(empId);

                        System.out.print("Enter your Phone number: ");
                        String phone = sc.nextLine();
                        Validator.validatePhone(phone);

                        System.out.print("Enter your Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter your User Name: ");
                        String userName = sc.nextLine();

                        System.out.print("Enter your Password: ");
                        String password = sc.nextLine();

                        UserAccount userAccount = new UserAccount(userName, password);
                        registeredEmployee = new Employee(empId, email, name, phone, userAccount);

                        System.out.println(registeredEmployee.toString());
                        registeredEmployee.persist();
                    } catch (ValidationException e) {
                        System.out.println("Validation failed: " + e.getMessage());
                    } catch (IOException e) {
                        System.out.println("Error saving employee data.");
                    }
                    break;

                case 2:
                    System.out.println("USE CASE 2 : EMPLOYEE AUTHENTICATION AND LOGIN");
                    AuthenticationService authentication = new AuthenticationService();
                    Session session = authentication.login();

                    if (session != null) {
                        System.out.println("\n" + session);
                        if (!session.isExpired()) {
                            System.out.println("Session active and valid");
                        }
                    }
                    break;

                case 3:
                    if (registeredEmployee == null) {
                        System.out.println("No employee registered. Please register first.");
                    } else {
                        System.out.println("USE CASE 3 : GENERATE PAYSLIP");
                        System.out.print("Enter Month: ");
                        String month = sc.nextLine();

                        System.out.print("Enter Basic Salary: ");
                        double basic = sc.nextDouble();

                        System.out.print("Enter HRA: ");
                        double hra = sc.nextDouble();

                        System.out.print("Enter DA: ");
                        double da = sc.nextDouble();

                        System.out.print("Enter Allowances: ");
                        double allowances = sc.nextDouble();
                        sc.nextLine();

                        PayrollService payrollService = new PayrollService();
                        PaySlip payslip = payrollService.generatePayslip(registeredEmployee, month, basic, hra, da, allowances);

                        System.out.println(payslip.toString());
                    }
                    break;

                case 4:
                    System.out.println("Exiting application...");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }

        sc.close();
    }
}