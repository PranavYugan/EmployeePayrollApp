package com.seveneleven.EmployePayrollApp.dashboard;

import java.util.*;

import com.seveneleven.EmployePayrollApp.salaryservice.PaySlip;
import com.seveneleven.EmployePayrollApp.main.Employee;

public class EmployeeDashboard implements Dashboard {

    public void display(ArrayList<PaySlip> paySlips, Employee employee) {

        System.out.println("EMPLOYEE DASHBOARD");
        System.out.println("Welcome, " + employee.getName());
        System.out.println("Dashboard Type: " + this.getClass().getName());
        
        Collections.sort(paySlips, new Comparator<PaySlip>() {

            public int compare(PaySlip p1, PaySlip p2) {
                double diff = p2.getComponents().netPay - p1.getComponents().netPay;
                return (int) diff;
            }
        });
        System.out.println("\nRecent Payslips (Top 3):");

        int count = 0;
        for (PaySlip p : paySlips) {
            if (count >= 3) break;
            System.out.println(p);
            count++;
        }
        double total = 0;
        for (PaySlip p : paySlips) {
            total += p.getComponents().netPay;
        }
        System.out.println("\nYear-To-Date Earnings: " + total);
    }
}