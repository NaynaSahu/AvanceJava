package Revision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

		

public class RevPreparedStatement {
	public static void main(String[] args) throws Exception {
		//SelectRecord();
		//TestUpdate();
		TestInsert();
		//Select();
		//TestDelete();
	}
	public static void Select() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
        
        PreparedStatement ps =  conn.prepareStatement("Select * from employee");
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
        	System.out.print(rs.getString(1));
        	System.out.print("\t"+"\t"+rs.getString(2));
        	System.out.print("\t"+"\t"+rs.getString(3));
        	System.out.print("\t"+"\t"+rs.getString(4));
        	System.out.println("\t"+"\t"+rs.getString(5));
			
		}
        ps.close();
        conn.close();
		
	}
	public static void SelectRecord() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
        int id = 23;
        PreparedStatement ps =  conn.prepareStatement("Select * from employee where Id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
        	System.out.print(rs.getString(1));
        	System.out.print("\t"+"\t"+rs.getString(2));
        	System.out.print("\t"+"\t"+rs.getString(3));
        	System.out.print("\t"+"\t"+rs.getString(4));
        	System.out.println("\t"+"\t"+rs.getString(5));
			
		}
        ps.close();
        conn.close();
		
	}
	public static void TestInsert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
		int id = 23;
		String fn = "BHURA";
		String ln = "SINGH";
		int salary = 60000;
		int did = 3;
	    try {
	    	PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?,?)");
		    ps.setInt(1, id);
		    ps.setString(2, fn);
		    ps.setString(3, ln);
		    ps.setInt(4, salary);
		    ps.setInt(5, did);
		    ps.executeUpdate();
		    ps.close();
			
		} catch (SQLException e) {
			conn.rollback();
			System.err.println("Not Inserted");
		}
	    conn.commit();
	    
	    System.out.println("Record(s) Inserted");
	    
	    conn.close();
	    
		
	}
	public static void TestUpdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
		int id = 24;
		String fn = "BHURA";
		String ln = "MAHAJAN";
		int salary = 60000;
		int did = 3;
		 try {
			 PreparedStatement ps =  conn.prepareStatement("update employee set FNAME = ? , LNAME = ? ,SALARY = ? ,DEP_ID= ? where ID = ?");
	         ps.setString(1, fn);
	         ps.setString(2, ln);
	         ps.setInt(3,salary);
	         ps.setInt(4, did);
	         ps.setInt(5, id);
	         ps.executeUpdate();
	         ps.close();
				
			} catch (SQLException e) {
				conn.rollback();
				System.err.println("Not Updated");
			}
		 conn.commit();
		
         System.out.println("Record(s) Updated");
         

         conn.close();
         
		
	}
	public static void TestDelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
		int id = 24;
		 try {
			 PreparedStatement ps =  conn.prepareStatement("Delete from employee where ID = ?");
				ps.setInt(1, id);
				ps.executeUpdate();
				ps.close();
				
			} catch (SQLException e) {
				conn.rollback();
				System.err.println("Not Deleted");
			}
		 conn.commit();
		
		System.out.println("Record(s) Deleted");
		
		conn.close();
		
	}
	
}
