import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.Driver;

public class Test {

	public static void main(String[]args) throws SQLException{
		try {
			Class.forName(" org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test4","sa","");
	Statement stmt = conn.createStatement();
	
	
	ResultSet rs = stmt.executeQuery("select * from employee ");
	//("UPDATE EMPLOYEE SET EMAIL='bharath@gmail.com' WHERE ID=1 ;");
	
	
	while (rs.next()){
		System.out.println(rs.getInt("id"));
		System.out.println(rs.getString("NAME"));
		System.out.println(rs.getString("EMAIL"));
		
	}
	}
}
