package com.seveneleven.EmployePayrollApp.salaryservice;

import com.seveneleven.EmployePayrollApp.main.Employee;

public class PayrollService {
	public PaySlip generatePayslip(Employee employee,String month,double basic,double hra,double da,double allowances) {
		SalaryComponents sc=new SalaryComponents(basic,hra,da,allowances);
		
		double gross=basic+hra+da+allowances;
		
		sc.pf=basic*0.12;
		sc.tax=gross*0.10;
		
		sc.netPay=gross - (sc.pf+sc.tax);
		return new PaySlip(employee.getEmpID(),employee.getName(),month,sc.netPay,employee,sc);
	}
}
