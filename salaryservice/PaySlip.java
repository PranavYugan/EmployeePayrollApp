package com.seveneleven.EmployePayrollApp.salaryservice;

import com.seveneleven.EmployePayrollApp.main.Employee;


public final class PaySlip implements Cloneable {
	private final String empId;
	private final String empName;
	private final String month;
	private final double netPay;
	private Employee employee;
	private SalaryComponents components;

	public PaySlip(String empId,String empName,String month,double netPay,Employee employee,SalaryComponents components) {
		this.empId=empId;
		this.empName=empName;
		this.month=month;
		this.netPay=netPay;
		this.employee=employee;
		this.components=components;
		
	}

	public String getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public double getNetPay() {
		return netPay;
	}

	public Object clone() {
		return new PaySlip(empId,empName,month,netPay,employee,components);
	}

	public boolean equals(Object o) {
		PaySlip other=(PaySlip) o;
		if(empId.equals(other.empId) && month.equals(other.month)) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		int result =17;
		result=31*result+empId.hashCode();
		result=31*result+month.hashCode();

		return result;
	}

	public String toString() {
		return "PAYSLIP\n"
				+ "Employee ID : " + empId + "\n"
				+ "Employee Name : " + empName + "\n"
				+ "Month : " + month + "\n"
				+ "Net Pay : " + netPay + "\n";
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
