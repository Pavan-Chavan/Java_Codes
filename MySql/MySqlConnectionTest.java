package MySql_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class MySqlConnectionTest 
{
	 public static void main(String[] args) throws Exception {

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan","root","root");
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM student");
	        while (rs.next()!=false){
	                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
	        }
	            rs.close();
	            conn.close();
	    }
}
