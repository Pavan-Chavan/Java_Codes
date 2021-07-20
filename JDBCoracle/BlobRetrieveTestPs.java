//Title:- Retrieve photo from database and store in given location
//coder:- Pavan Chavan
//Email:- pavan.21920161@viit.ac.in
//date:- 20/07/2021

package VIIT.jdbc.oracle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;



public class BlobRetrieveTestPs {
			public static final String BLOB_INSERT_QUERY="SELECT NAME,ADDRESS,PHOTO FROM PERSON_INFO WHERE NAME=?"; 	//query to insert picture into database
			
			public static void main(String[] args)
			{
				String name=null,address=null;
				
				try(Scanner sc= new Scanner(System.in);)
				{	
					//collecting input from user
					System.out.println("Enter person name:");
					name=sc.next();
				}
				try(
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
						PreparedStatement ps = con.prepareStatement(BLOB_INSERT_QUERY);		//try with resource for connection inoutstream and 
						)																		
				{
					
					if(ps!=null)
					{
						ps.setString(1, name);
					}
					try(ResultSet rs = ps.executeQuery();)
					{
						if(rs!=null && rs.next())
						{
							name=rs.getString(1);
							address=rs.getString(2);
							System.out.println(name+" "+address+" ");
							try(InputStream is=rs.getBinaryStream(3);
								OutputStream os = new FileOutputStream("Retrivev_file.jpg");
								)
							{
								IOUtils.copy(is,os);
								System.out.println("Photo retieve and save sucefully...");
							}
						}
						else
							System.out.println("File not found...");
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
