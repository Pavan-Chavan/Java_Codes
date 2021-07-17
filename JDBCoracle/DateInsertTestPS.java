//this program perform the insertion of data in data base table of oracle
//coder:- Pavan Chavan
//email:-pavan.21920161@viiit.ac.in



package VIIT.jdbc.oracle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

public class DateInsertTestPS {
	public static void main(String[] args) {
		
			//variable deceleration part
			Scanner sc=new Scanner(System.in);
			Connection con=null;
			PreparedStatement ps =null;
			
			String name=null,DOB=null,DOJ=null,DOM=null;
			int pId = 0;
			String INSERT_DATA_QUERY="INSERT INTO Person_Info_Date VALUES(?,?,?,?,?)";
			
			try(sc) {								//scanner class is with try with enhance recourse
				
				//take input from user
				if(sc!=null)
				{
					System.out.println("Enter Person ID:");
					pId=sc.nextInt();
					System.out.println("Enter Name :");
					name=sc.next();
					System.out.println("Enter Date of Birth(DOB)(dd-MM-yyyy):");
					DOB=sc.next();
					System.out.println("Enter Date of Joining(DOJ)(yyyy-mm-dd):");
					DOJ=sc.next();
					System.out.println("Enter Date of Mariage:(DOM)(MMM-dd-yyyy):");
					DOM=sc.next();
				}//if
				
				//converting DOB in sql data format i.e.from dd-mm-yyyy to yyyy-dd-mm
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date udob = sdf1.parse(DOB);
				long ms = udob.getTime();
				java.sql.Date sdob = new java.sql.Date(ms);
				
				//Converting DOJ (yyyy-MM-dd) to SQL date format it is already in sql format
				// we need to covert sting in to SQL
				
				java.sql.Date sdoj =  java.sql.Date.valueOf(DOJ);
				
				
				//converting MMM-dd-yyyy into SQL date format
				
				SimpleDateFormat sdf2 = new SimpleDateFormat("MMM-dd-yyyy");
				java.util.Date udom = sdf2.parse(DOM);
				ms= udom.getTime();
				java.sql.Date sdom = new java.sql.Date(ms);
				
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				
				if(con!=null)
					ps = con.prepareStatement(INSERT_DATA_QUERY);
				
					if(ps!=null)
					{
						ps.setInt(1, pId);
						ps.setString(2, name);
						ps.setDate(3, sdob);
						ps.setDate(4, sdoj);
						ps.setDate(5, sdom);
					}
					int count =0;
					if(ps!=null)
					{
						count=ps.executeUpdate();
					}
					if(count==1)
						System.out.println("Record inseted sucefully..");
					else
						System.out.println("Record not inserted..");
				
			}//try
			catch (SQLException se) {
				se.printStackTrace();
				System.out.println("Problem in insertion of record");
			}
			catch (Exception e) {
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
