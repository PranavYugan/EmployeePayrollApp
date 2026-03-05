package com.seveneleven.EmployePayrollApp.payslipdownload;

public final class DownlodablePaySlip implements Cloneable {
	private final String empId;
	private final String empName;
	private final String month;
	private final double netPay;
	
	public DownlodablePaySlip(String empId,String empName,String month,double netPay) {
		this.empId=empId;
		this.empName=empName;
		this.month=month;
		this.netPay=netPay;
	}

	public String getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getMonth() {
		return month;
	}

	public double getNetPay() {
		return netPay;
	}
	
	public Object clone() {
		return new DownlodablePaySlip(empId,empName,month,netPay);
	}
	
	public boolean equals(Object o) {
		DownlodablePaySlip other=(DownlodablePaySlip) o;
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

}
