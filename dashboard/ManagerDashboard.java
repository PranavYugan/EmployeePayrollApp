package com.seveneleven.EmployePayrollApp.dashboard;
import java.util.*;
import com.seveneleven.EmployePayrollApp.salaryservice.PaySlip;
import com.seveneleven.EmployePayrollApp.main.Employee;

public class ManagerDashboard implements Dashboard {

    public void display(ArrayList<PaySlip> paySlips, Employee employee) {

        System.out.println("\nMANAGER DASHBOARD");
        System.out.println("Manager: " + employee.getName());
        System.out.println("Dashboard Type: " + this.getClass().getName());

        double total = 0;
        for (PaySlip p : paySlips) {
            total += p.getComponents().netPay;
        }

        System.out.println("\nTeam Total YTD Earnings: " + total);
    }
}