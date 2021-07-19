//Title:- This will transfer the data of one data base to other database with try with resource
//coder:- Pavan Chavan
//Email:- pavan.21920161@viit.ac.in
//date:- 19/07/2021


package VIIT.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleToMySqlDataTransferTestTryWithResource {
	
	public static final String ORACLE_GET_DATA_FROM_STUDENT="SELECT SNO,SNAME,SADD,AVG FROM student";	//query for oracle to get data
	public static final String MYSQL_PUT_DATA_TO_STUDENT="INSERT INTO STUDENT VALUES(?,?,?,?)";			//query for mysql to put data
	
	public static void main(String[] args) {
		
		//Deceleration part
		String sadd=null,sname=null;
		int sno;
		float avg;
		
		try(	//try with resource this will close the object after try block ends
				Connection oracleCon= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");	//connection for oracle
				Connection mysqlCon=DriverManager.getConnection("jdbc:mysql:///pavan","root","root");						//connection for mysql
				Statement st =oracleCon.createStatement();																	//simple statement object for oracle
				PreparedStatement ps=mysqlCon.prepareStatement(MYSQL_PUT_DATA_TO_STUDENT);									//prepare statement object for mysql	
				ResultSet rs=st.executeQuery(ORACLE_GET_DATA_FROM_STUDENT);)												//Compiling query for insertion
			{
	
			if(rs!=null && ps!=null)
			{
				while(rs.next())
				{					
					sno=rs.getInt(1);				//Getting data from rs to local variable
					sname=rs.getString(2);
					sadd=rs.getString(3);
					avg=rs.getFloat(4);
					
					ps.setInt(1, sno);				//setting data for prepared statement query
					ps.setString(2, sname);
					ps.setString(3, sadd);
					ps.setFloat(4, avg);
					
					ps.executeUpdate();				//inseting data in mysql datbase
				}//while
				System.out.println("Data coiped succefully...");
			}//if
		}//try
		catch (SQLException e) {			//sql exception 
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();			//other exception
		}
	}//main
}//OracleToMySqlDataTransferTest
