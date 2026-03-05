package com.seveneleven.EmployePayrollApp.payslipdownload;

import java.io.*;

import com.seveneleven.EmployePayrollApp.salaryservice.PaySlip;

public class FileService {
	public String savePayslipAsText(PaySlip payslip) throws IOException{
		String filename="Payslip_" + payslip.getEmpId() + "_" + System.currentTimeMillis() + ".txt";
		FileWriter fw = new FileWriter(filename);
		fw.write(payslip.toString());
		fw.close();
		return filename;
 	}
	
	public String savePayslipAsPdf(PaySlip payslip) throws IOException{
		String filename="Payslip_" + payslip.getEmpId() + "_" + System.currentTimeMillis() + ".pdf";
		FileWriter fw = new FileWriter(filename);
		fw.write(payslip.toString());
		fw.close();
		return filename;
 	}
}
