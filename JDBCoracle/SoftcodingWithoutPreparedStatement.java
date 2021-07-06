package Oracle_Practic;

import java.util.Scanner;
import java.lang.System;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class SoftcodingWithoutPreparedStatement {
	
		public static void main(String[] args) throws SQLException {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the upper range of salary");
			int upperLimit=sc.nextInt();
			System.out.println("Enter the lower range of salary");
			int lowerLimit = sc.nextInt();
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			if (con!=null) 
			{
				Statement st = con.createStatement();
				if(st!=null)
				{
					ResultSet rs = st.executeQuery("select EMPID,EMPNAME,EMPDESG,SALARY from employ where SALARY>="+lowerLimit+" and SALARY<="+upperLimit);

					if (rs!=null) 
					{
						while(rs.next()!=false)
						{
							System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
						}
					}
				}
			}
			sc.close();
			//st.close();
			con.close();
		}
		

}
