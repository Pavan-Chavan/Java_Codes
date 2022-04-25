package com.service;

import com.bo.EmployeeBO;
import com.dao.IEmployeeDAO;
import com.dto.EmployeeDTO;

public class EmployeeService implements IEmployeeService {

	private IEmployeeDAO  dao;  //HAS-A property
	 
	 public EmployeeService(IEmployeeDAO dao) {
		 System.out.println("CustomerMgmtServiceImpl.1-param constructor");
		 this.dao=dao;
	 }
	@Override
	public String calculateEmpSaraly(EmployeeDTO edto) throws Exception {
		EmployeeBO bo = new EmployeeBO();
		
		bo.setEmpName(edto.getEmpName());
		bo.setEmpSalary(edto.getEmpSalary());
		bo.setEmpGrossSalary(edto.getEmpSalary() * 1.40);
		bo.setEmpNetSalary((edto.getEmpSalary() * 1.40) - (edto.getEmpSalary() * 1.40) * 0.20);
		int count = dao.insert(bo);
		return count==1?"Employee registered sucessfully--->":"Emplyee registration failed";
	}

}
