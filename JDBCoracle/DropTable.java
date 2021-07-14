//Title :- Drop table, name given by user
// Coder Name:- pavan chavan
//email:- pavan.21920161@viit.ac.in



package VIIT.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DropTable 
{
	public static void main(String[] args) {
		
		//Declaration part 
		Scanner sc=null;
		String tableName=null;
		Connection con=null;
		Statement st= null;
		ResultSet rs=null;
		
		
		try{
			sc=new Scanner(System.in);
			if(sc!=null)
			{
				//reading input from user
				System.out.println("Enter table name:");
				tableName=sc.nextLine();
			}//if

			//creating object for connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			if(con!=null)
			{
				//creating object for statement
				st=con.createStatement();
				
								//DROP TABLE TEMP_STUDENT;
				String QUERY = "DROP TABLE "+tableName;
				int count=0;
				
				if(st!=null)
				{
					//Using executeUpdate to update the record in DB which return the how many record affected
					//System.out.println(QUERY);
					count=st.executeUpdate(QUERY);
					//this return 0 for succesfull creation of table
					if(count==0)
						System.out.println("Table drop succefully");
					else
					{
						System.out.println("Table drop Failed");
					}
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

