//title:- Test of scrollable result test for simple statement 
//coder:- pavan prakash chavan
//email:- pavan.21920161@viit.ac.in
//data:- 24/07/2021

package VIIT.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableRSTest {
	
	public static final String SELECT_ALL_FROM_STUDENT_QUERY="SELECT * FROM STUDENT";	//Query
	
	public static void main(String[] args) {
		
		//try with resource 
		try (	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery(SELECT_ALL_FROM_STUDENT_QUERY);
			){
				if(rs!=null)
				{
					//result set from top to bottom
					System.out.println("Result set top to bottam:");
					while(rs.next())
					{
						System.out.println(rs.getRow()+"-->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					}
					System.out.println("----------------------------------------");
					
					//result set from bottom to top
					System.out.println("Result set bottom to top:");
					while(rs.previous())
					{
						System.out.println(rs.getRow()+"-->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					}
					
					//first record
					System.out.println("----------------------------------------");
					System.out.println("Result set first record:");
					rs.first();
					System.out.println(rs.getRow()+"-->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					
					//last record
					System.out.println("----------------------------------------");
					System.out.println("Result set last record:");
					rs.last();
					System.out.println(rs.getRow()+"-->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					
					//output at absolute at 3
					System.out.println("----------------------------------------");
					System.out.println("Result set absolute at 3:");
					rs.absolute(3);
					System.out.println(rs.getRow()+"-->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					
					//output at absolute at -3
					System.out.println("----------------------------------------");
					System.out.println("Result set absolute at -3:");
					rs.absolute(-3);
					System.out.println(rs.getRow()+"-->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					
					//output at relative 2
					System.out.println("----------------------------------------");
					System.out.println("Result set relative at 2:");
					rs.relative(2);
					System.out.println(rs.getRow()+"-->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					
					//output at relative -2
					System.out.println("----------------------------------------");
					System.out.println("Result set relative at -2:");
					rs.relative(-2);
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
