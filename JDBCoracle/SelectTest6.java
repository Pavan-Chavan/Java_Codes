//Title :- JDBC app that get highest salary using query inside query
// Coder Name:- pavan chavan
//email:- pavan.21920161@viit.ac.in



package VIIT.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest6 
{
	public static void main(String[] args) {
		
		//Declaration part 
		Connection con=null;
		Statement st= null;
		ResultSet rs=null;
		
		
		try{
			//creating object for connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			if(con!=null)
			{
				//creating object for statement
				st=con.createStatement();
				if(st!=null)
				{
									//SELECT EMPID,EMPNAME,EMPDESG,SALARY FROM EMPLOY WHERE SALARY=(SELECT MAX(SALARY) FROM EMPLOY);
					String QUERY = "SELECT EMPID,EMPNAME,EMPDESG,SALARY FROM EMPLOY WHERE SALARY=(SELECT MAX(SALARY) FROM EMPLOY)";
					
					//creating result set
					rs=st.executeQuery(QUERY);
					if(rs!=null)
					{
						System.out.println("Highest salary person is:");
						while(rs.next()!=false)
						{
							//printing output of query
							System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));

						}//while
					}//if
				}//if
			}//if
		}//if
		//to handle known exception
		catch(SQLException se ){
			se.printStackTrace();	//gives information about raised exception
		}//catch
		//to handle unKnown exception
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		//closing jdbc and stream objects 
		finally {
			try {
				if(rs!=null)
					rs.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}//catch
			try {
				if(st!=null)
					st.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}//catch
			try {
				if(con!=null)
					con.close();
			}//try
			catch(SQLException se)
			{
				se.printStackTrace();
			}//catch
		}//finally
	}//main
}//SelectTest






















