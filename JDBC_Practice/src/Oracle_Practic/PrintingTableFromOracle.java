package Oracle_Practic;
import java.sql.*;

public class PrintingTableFromOracle {
	public static void main(String[] args) {
		Connection con;
		Statement st;
		ResultSet rs;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			if (con!=null) {
				st = con.createStatement();
				if (st!=null) {
					rs = st.executeQuery("select * from student");
					while(rs.next()!=false)
					{
						System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
					}
					rs.close();
				}
				st.close();
			}
			con.close();
		}
	catch(SQLException e) {
			e.printStackTrace();
		}
	}								
}
