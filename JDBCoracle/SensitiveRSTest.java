//title:- Test of sensitive objects 
//coder:- pavan prakash chavan
//email:- pavan.21920161@viit.ac.in
//data:- 26/07/2021

package VIIT.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SensitiveRSTest {
	
	public static final String SELECT_ALL_FROM_STUDENT_QUERY="SELECT * FROM STUDENT";	//Query
	
	public static void main(String[] args) {
		
		//try with resource 
		try (	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery(SELECT_ALL_FROM_STUDENT_QUERY);
			){
				if(rs!=null)
				{			
					//first row before updation
					System.out.println("----------------------------------------");
					System.out.println("Result set first record:");
					rs.first();
					System.out.println(rs.getRow()+"-->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					
					Thread.sleep(30000);	//update first row in this time period 	
					rs.refreshRow();
					
					//first row after updation
					System.out.println("----------------------------------------");
					System.out.println("Result set first record:");
					rs.first();
					System.out.println(rs.getRow()+"-->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					
				}//if
			
		}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}//main
}//scrollableRSTest
