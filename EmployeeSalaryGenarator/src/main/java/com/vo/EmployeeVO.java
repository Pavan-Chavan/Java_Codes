package com.vo;

public class EmployeeVO {
	private String empName;
	private String empSalary;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "EmployeeVO [empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	
}
