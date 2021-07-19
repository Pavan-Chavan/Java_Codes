package VIIT.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleToMySqlDataTransferTest {
	
	public static final String ORACLE_GET_DATA_FROM_STUDENT="SELECT SNO,SNAME,SADD,AVG FROM student";	//query for oracle to get data
	public static final String MYSQL_PUT_DATA_TO_STUDENT="INSERT INTO STUDENT VALUES(?,?,?,?)";			//query for mysql to put data
	
	public static void main(String[] args) {
		
		//Deceleration part
		Connection oracleCon=null,mysqlCon=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sadd=null,sname=null;
		int sno;
		float avg;
		
		try {
			
			oracleCon= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");	//connection for oracle
			mysqlCon=DriverManager.getConnection("jdbc:mysql:///pavan","root","root");						//connection for mysql
			
			if(oracleCon!=null)
				st=oracleCon.createStatement();								//simple statement object for oracle
			if(mysqlCon!=null)									
				ps=mysqlCon.prepareStatement(MYSQL_PUT_DATA_TO_STUDENT);	//prepare statement object for mysql
			
			if(st!=null)
				rs=st.executeQuery(ORACLE_GET_DATA_FROM_STUDENT);			//Compiling query for insertion
			
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
		finally
		{									//object closing does not required in we use try with recourse 
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try {
				if(oracleCon!=null)
					oracleCon.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try {
				if(mysqlCon!=null)
					mysqlCon.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}//finally
	}//main
}//OracleToMySqlDataTransferTest
