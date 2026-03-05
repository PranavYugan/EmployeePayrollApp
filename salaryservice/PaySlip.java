package com.seveneleven.EmployePayrollApp.salaryservice;

import com.seveneleven.EmployePayrollApp.main.Employee;

public class PaySlip {
	private Employee employee;
	private SalaryComponents components;
	private String month;
	
	public PaySlip(Employee employee,SalaryComponents components,String month) {
		this.employee=employee;
		this.components=components;
		this.month=month;
	}
	
	public String toString() {
		return "\n  PAYSLIP   \n"
				+ "Month : " + month + "\n"
				+"Employee ID : " + employee.getEmpID() + "\n"
				+"Employee Name : " + employee.getName() + "\n\n"
				+"---Earnings---\n"
				+"Basic Salary : " + components.basicSalary + "\n"
				+"HRA : " + components.hra + "\n"
				+"DA : " + components.da + "\n"
				+"Allowances : " + components.allowances + "\n\n"
				+ "---Deductions---\n"
				+"PF : " + components.pf + "\n"
				+"Tax : " + components.tax + "\n"
				+"Net Pay : " + components.netPay + "\n";
				
	}

	public Employee getEmployee() {
		return employee;
	}

	public SalaryComponents getComponents() {
		return components;
	}

	public String getMonth() {
		return month;
	}
	
	
}
