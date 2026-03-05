package com.seveneleven.EmployePayrollApp.salaryservice;

public class SalaryComponents {
	double basicSalary;
	double hra;
	double da;
	double allowances;
	double pf;
	double tax;
	public double netPay;
	
	public SalaryComponents(double basicSalary,double hra,double da,double allowances) {
		this.basicSalary=basicSalary;
		this.hra=hra;
		this.da=da;
		this.allowances=allowances;
	}
	
}
