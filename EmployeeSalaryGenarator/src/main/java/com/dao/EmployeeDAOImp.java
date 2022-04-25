package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.bo.EmployeeBO;

public class EmployeeDAOImp implements IEmployeeDAO {
	private  static final String  REALTIMEDI_EMPLOYEE_INSERT_QUERY="INSERT INTO EMP_DETAILS VALUES(sequence_1.NEXTVAL,?,?,?,?)";
	private DataSource ds;

	 // alt+shift+s ,o
	public EmployeeDAOImp(DataSource ds) {
		System.out.println("EmployeeDAOImp.EmployeeDAOImp()");
		this.ds = ds;
	}
	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			//get pooled jdbc con object
			con=ds.getConnection();
			//create PreparedStaement object having pre-compiled SQL query
			ps=con.prepareStatement(REALTIMEDI_EMPLOYEE_INSERT_QUERY);
			//set query param values
			ps.setString(1, bo.getEmpName());
			ps.setDouble(2, bo.getEmpSalary());
			ps.setDouble(3,bo.getEmpGrossSalary());
			ps.setDouble(4,bo.getEmpNetSalary());
			//execute the Query
			count=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}

}
