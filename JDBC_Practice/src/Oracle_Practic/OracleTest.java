package Oracle_Practic;

import java.sql.*;
public class OracleTest {
	public static void main(String[] args) {
		//Class.forName("oracle.jdbc.OracleDriver");
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			if(con==null)
				System.out.println("Connection is not established");
			else
				System.out.println("Connection is established");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}