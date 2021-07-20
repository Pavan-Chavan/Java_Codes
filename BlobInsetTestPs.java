//Title:- Insert photo graph of person into database
//coder:- Pavan Chavan
//Email:- pavan.21920161@viit.ac.in
//date:- 20/07/2021

package VIIT.jdbc.oracle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BlobInsetTestPs {
			public static final String BLOB_INSERT_QUERY="INSERT INTO PERSON_INFO VALUES(?,?,?)"; 	//query to insert picture into database
			
			public static void main(String[] args)
			{
				String name=null,address=null,photoLocation=null;
				
				try(Scanner sc= new Scanner(System.in);)
				{	
					//collecting input from user
					System.out.println("Enter person name:");
					name=sc.nextLine();
					System.out.println("Enter person address:");
					address=sc.nextLine();
					System.out.println("Enter photo location:");
					photoLocation=sc.nextLine();
				}
				try(
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
						InputStream is = new FileInputStream(photoLocation);
						PreparedStatement ps = con.prepareStatement(BLOB_INSERT_QUERY);		//try with resource for connection inoutstream and 
					)																		//and prepared statement
				{
					int count=0;
					if(ps!=null)
					{
						ps.setString(1, name);
						ps.setString(2, address);
						ps.setBlob(3, is);				//seting parameter of ps
						
						count=ps.executeUpdate();
					}
					
					if (count==0) {
						System.out.println("Blob failed");
						
					} else {
						System.out.println("Blob succefull...");
					}
					
				}
				catch(FileNotFoundException fnfe)		//file not found for input stream
				{
					fnfe.printStackTrace();
				}
				catch(IOException ioe )					//io exception
				{
					ioe.printStackTrace();
				}
				catch(SQLException se)					//all SQL exception
				{
					se.printStackTrace();
				}
				catch(Exception e)						//other known exception
				{
					e.printStackTrace();
				}
			}
}
