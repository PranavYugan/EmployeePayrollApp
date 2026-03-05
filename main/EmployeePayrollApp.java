package com.seveneleven.EmployePayrollApp.main;

import com.seveneleven.EmployePayrollApp.payslipdownload.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import com.seveneleven.EmployePayrollApp.Validation.*;
import com.seveneleven.EmployePayrollApp.auth.*;
import com.seveneleven.EmployePayrollApp.salaryservice.*;
import com.seveneleven.EmployePayrollApp.dashboard.*;

public class EmployeePayrollApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Employee registeredEmployee = null;
            PaySlip generatedSlip = null;
            ArrayList<PaySlip> paySliphistory = new ArrayList<>();
            boolean exit = false;

            while (!exit) {
                System.out.println("=====================================");
                System.out.println("EMPLOYEE PAYROLL APPLICATION");
                System.out.println("=====================================");
                System.out.println("1. Employee Registration");
                System.out.println("2. Employee Login");
                System.out.println("3. Generate Payslip");
                System.out.println("4. Download Payslip");
                System.out.println("5. View Dashboard");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            System.out.println("USE CASE 1 : EMPLOYEE REGISTRATION\n");

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
                            generatedSlip = payrollService.generatePayslip(
                                    registeredEmployee, month, basic, hra, da, allowances);

                            paySliphistory.add(generatedSlip);

                            System.out.println(generatedSlip.toString());
                        }
                        break;

                    case 4:
                        if (generatedSlip == null) {
                            System.out.println("Generate payslip first.");
                            break;
                        }

                        System.out.println("USE CASE 4 : DOWNLOAD PAYSLIP");

                        try {
                            PaySlip copy = (PaySlip) generatedSlip.clone();
                            System.out.println("Pay slip quality check : " + generatedSlip.equals(copy));

                            DownloadToken token = new DownloadToken();
                            if (!token.isExpired()) { 
                                FileService fs = new FileService();
                                String txt = fs.savePayslipAsText(copy);
                                String pdf = fs.savePayslipAsPdf(copy);

                                System.out.println("Saved TXT : " + txt);
                                System.out.println("Saved PDF : " + pdf);
                            } else {
                                System.out.println("Download token expired");
                            }
                        } catch (Exception e) {
                            System.out.println("Error downloading payslip.");
                        }
                        break;

                    case 5:
                        if (registeredEmployee == null) {
                            System.out.println("No employee registered.");
                            break;
                        }

                        if (paySliphistory.isEmpty()) {
                            System.out.println("No payslips generated yet.");
                            break;
                        }

                        System.out.println("USE CASE 5 : DASHBOARD");
                        System.out.print("Enter role (EMPLOYEE / MANAGER): ");
                        String role = sc.nextLine();

                        Dashboard dashboard = DashboardFactory.getDashboard(role);

                        if (dashboard != null) {
                            dashboard.display(paySliphistory, registeredEmployee);
                        } else {
                            System.out.println("Invalid role.");
                        }

                        break;

                    case 6:
                        System.out.println("Exiting...");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println();
            }
        }
    }
}