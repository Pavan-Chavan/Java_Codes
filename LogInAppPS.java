//Title :- Log in application using prepare statement to avoid SQL injectin problem
//coder:- Pavan Chavan
//Email:- pavan.21920161@viit.ac.in


package VIIT.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class LogInAppPS {
	
	public static final String LOGIN_QUERY = "SELECT COUNT(*) FROM IRCTC_TAB WHERE UNAME=? AND PASSWORD=?";
	
	public static void main(String[] args) {

		//declreration part
		
		Scanner sc= new Scanner(System.in);
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String userName=null;
		String passWord=null;
		
		try
		{						
			if(sc!=null)
			{
				System.out.println("Enter UserName:");
				userName=sc.next();
				System.out.println("Enter Password:");
				passWord=sc.next();
			}//if
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			
			if(con!=null)
			{
				//prepare statement  object
				ps=con.prepareStatement(LOGIN_QUERY);
				
				if (ps!=null) 
				{
					//set each student details as pre compiled SQL query 
					ps.setString(1, userName);
					ps.setString(2, passWord);
						
					rs=ps.executeQuery();
					rs.next();
					int count=rs.getInt(1);
					//execute pre compiled query each time
						if (count==1) {
							System.out.println("LogIn succefull...");
						}//if
						else
						{
							System.out.println("LogIn failed please check your credietial...");
						}//else
					}//for
				}//if
		}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
	
}
