import java.sql.*;
import java.util.Scanner;
public class Test2 {
	
	   public static void main(String[] args) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("org.h2.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test4","sa","");
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			      
			      
			      String query = "update EMPLOYEE set name = ? where id = ?";
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString(1, "BJ");
			      preparedStmt.setInt   (2, 1);
			      preparedStmt.executeUpdate();
			      
			      String query1 = "update EMPLOYEE set name = ? where id = ?";
			      PreparedStatement preparedStmt1 = conn.prepareStatement(query1);
			      preparedStmt1.setString(1, "REDDY A");
			      preparedStmt1.setInt   (2, 2);
			      preparedStmt1.executeUpdate();
			      
			      
			      String query4 = "update EMPLOYEE set name = ? where id = ?";
			      PreparedStatement preparedStmt4 = conn.prepareStatement(query4);
			      preparedStmt4.setString(1, "B.BHAGYA");
			      preparedStmt4.setInt   (2, 7);
			      preparedStmt4.executeUpdate();
			      
			      /*
			       String query2 = "insert into EMPLOYEE values(8 , 'NAGENDRA', 'Nagabuubu69')" ;
			       PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
				     
			      preparedStmt2.execute();
			      */
			      
			      String query3 = "delete from EMPLOYEE where ID = 8 " ;
			       PreparedStatement preparedStmt3 = conn.prepareStatement(query3);
				     
			      preparedStmt3.execute();
			      
			      String query2 = "insert into EMPLOYEE values(8 ,'NAGENDRA','Nagabuubu69')" ;
			       PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
				     
			      preparedStmt2.execute();
			      
			      String query5 = " update EMPLOYEE set email = ? where id = ? " ;
			      PreparedStatement preparedStmt5 = conn.prepareStatement(query5);
			      preparedStmt5.setString(1, "mnbabu@gmail.com");
			      preparedStmt5.setInt   (2, 8);
			      preparedStmt5.executeUpdate();
			      
			     
			      String sql;
			      sql = "SELECT * FROM EMPLOYEE";
			      
			     ResultSet rs = stmt.executeQuery(sql);
			      while(rs.next()){
			          //Retrieve by column name
			          int id  = rs.getInt("id");
			          String name = rs.getString("name");
			          String email = rs.getString("email");

			          //Display values
			          System.out.print("ID: " + id);
			          System.out.print(", Name: " + name);
			          System.out.println(", Email: " + email);
			       }
			      rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");
			}//end main

	
	
}
