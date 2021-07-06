//Title :- JDBC app that get deatils of employ base on designaiton
// Coder Name:- pavan chavan
//email:- pavan.21920161@viit.ac.in



package VIIT.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest 
{
	public static void main(String[] args) {
		
		//Declaration part 
		Scanner sc=null;
		String desg1=null,desg2=null,desg3=null;
		Connection con=null;
		Statement st= null;
		ResultSet rs=null;
		
		
		try{
			sc=new Scanner(System.in);
			if(sc!=null)
			{
				//reading input from user
				System.out.println("Enter designation 1:");
				desg1=sc.nextLine();
				System.out.println("Enter designation 2:");
				desg2=sc.nextLine();
				System.out.println("Enter designation 3:");
				desg3=sc.nextLine();
			}//if
			//prering string to use in sql query
			desg1="'"+desg1+"'";	//makes MNGR as 'MNGR'
			desg2="'"+desg2+"'";
			desg3="'"+desg3+"'";

			//creating object for connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			if(con!=null)
			{
				//creating object for statement
				st=con.createStatement();
				if(st!=null)
				{
					String QUERY = "SELECT EMPID,EMPNAME,EMPDESG,SALARY FROM EMPLOY WHERE "
									+ "EMPDESG IN ("+desg1+","+desg2+","+desg3+") ORDER BY EMPDESG" ;
					
					//creating result set
					rs=st.executeQuery(QUERY);
					if(rs!=null)
					{
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
			try {
				if(sc!=null)
					sc.close();
			}//tyr
			catch(Exception e){
				e.printStackTrace();
			}//catch
		}//finally
	}//main
}//SelectTest






















