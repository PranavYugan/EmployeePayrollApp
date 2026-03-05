package com.seveneleven.EmployePayrollApp.dashboard;

import java.util.ArrayList;

import com.seveneleven.EmployePayrollApp.salaryservice.PaySlip;
import com.seveneleven.EmployePayrollApp.main.Employee;

public interface Dashboard {

    void display(ArrayList<PaySlip> payslips, Employee employee);

}