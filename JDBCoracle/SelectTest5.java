//Title :- JDBC app that get no of record in tha table
// Coder Name:- pavan chavan
//email:- pavan.21920161@viit.ac.in



package VIIT.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest5 
{
	public static void main(String[] args) {
		
		//Declaration part 
		Scanner sc=null;
		String table=null;
		Connection con=null;
		Statement st= null;
		ResultSet rs=null;
		
		
		try{
			sc=new Scanner(System.in);
			if(sc!=null)
			{
				//reading input from user
				System.out.println("Enter a letter :");
				table=sc.nextLine();
			}//if

			//creating object for connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			if(con!=null)
			{
				//creating object for statement
				st=con.createStatement();
				if(st!=null)
				{
									//SELECT COUNT(*) FROM employ;
					String QUERY = "select count(*) from "+table;
					
					//creating result set
					rs=st.executeQuery(QUERY);
					if(rs!=null)
					{
						while(rs.next()!=false)
						{
							//printing output of query
								int count = rs.getInt(1);
								System.out.println("No of record in "+table+" is :"+count);
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






















