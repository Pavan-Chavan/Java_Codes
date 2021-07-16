//Title :- This application check the credential of IRCTC user
// Coder Name:- pavan chavan
//email:- pavan.21920161@viit.ac.in

//Login application using simple statement leads to SQL injection problem
// in real time we avoid this technique for login


package VIIT.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AuthenticationApp 
{
	public static void main(String[] args) {
		
		//Declaration part 
		Scanner sc=null;
		String userName=null;
		String passWord=null;
		Connection con=null;
		Statement st= null;
		ResultSet rs=null;
		
		
		try{
			sc=new Scanner(System.in);
			if(sc!=null)
			{
				//reading input from user
				System.out.println("Table will create with default coloume value such as SrNo FirstName LastName");
				System.out.println("Enter username:");
				userName=sc.nextLine();
				System.out.println("Enter the password:");
				passWord=sc.nextLine();
			}//if
			
			userName = "'"+userName+"'";
			passWord = "'"+passWord+"'";
			//creating object for connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			if(con!=null)
			{
				//creating object for statement
				st=con.createStatement();
				
								//select count(*) from IRCTC_TAB where UNAME='Raja' and PASSWORD='Pavan';
				String QUERY = "SELECT COUNT(*) FROM IRCTC_TAB WHERE UNAME="+userName+" AND PASSWORD="+passWord;
				
				if(st!=null)
				{
					//Using executeUpdate to update the record in DB which return the how many record affected
					//System.out.println(QUERY);
					rs=st.executeQuery(QUERY);
					//this return 0 for successfully creation of table
					rs.next();
					if(rs.getInt(1)==1)
						System.out.println("Login succefull....");
					else
					{
						System.out.println("Login failed please check your crediantials...");
					}
				}//if
			}//if
		}//if
		//to handle known exception
		catch(SQLException se ){
			se.printStackTrace();	//gives information about raised exception
			if(se.getErrorCode()==955)
				System.out.println("Table is already created....");
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

