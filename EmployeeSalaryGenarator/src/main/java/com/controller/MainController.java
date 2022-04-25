package com.controller;

import com.dto.EmployeeDTO;
import com.service.IEmployeeService;
import com.vo.EmployeeVO;

public class MainController {
private IEmployeeService service;
	
	public MainController(IEmployeeService service) {
		System.out.println("MainController: 1-param constructor");
		  this.service=service;
	}
	public  String  processEmployee(EmployeeVO vo)throws Exception {
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpName(vo.getEmpName());
		dto.setEmpSalary(Double.parseDouble(vo.getEmpSalary()));
		return service.calculateEmpSaraly(dto);
	}
	
}
