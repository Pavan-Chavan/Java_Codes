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

public class UpdatableRSTest {
	
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
					
					//example of insert row
					//this block of code will insert the row at the last of databse table
					/*rs.moveToInsertRow();
					rs.updateInt(1,1010);
					rs.updateString(2, "Prajkata");
					rs.updateString(3,"Anagar");
					rs.updateFloat(4, 89.90f);
					rs.insertRow();
					System.out.println("Insertion succefull..");*/
					//example of update row
					//this will update the 3rd row`s 4th colome values
					rs.absolute(3);
					rs.updateFloat(4, 78.90f);
					rs.updateRow();
					
					System.out.println("Updation succefull..");
					//example of deletion
					//this will delete 4 the row of database
					rs.absolute(4);
					rs.deleteRow();
					System.out.println("Deletion succefull.."); 
					
					System.out.println("Result set top to bottam after makig changes from updatable result set:");
					while(rs.next())
					{
						System.out.println(rs.getRow()+"-->"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					}
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
