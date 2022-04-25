package com.bo;

public class EmployeeBO {
	private String empName;
	private Double empSalary;
	private Double empGrossSalary;
	private Double empNetSalary;
	
	public Double getEmpGrossSalary() {
		return empGrossSalary;
	}
	public void setEmpGrossSalary(Double empGrossSalary) {
		this.empGrossSalary = empGrossSalary;
	}
	public Double getEmpNetSalary() {
		return empNetSalary;
	}
	public void setEmpNetSalary(Double empNetSalary) {
		this.empNetSalary = empNetSalary;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}
	

	@Override
	public String toString() {
		return "EmployeeBO [empName=" + empName + ", empSalary=" + empSalary + "]";
	}
}
