package RevMarksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksheetModel {
	public void add(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
		
	    try {
	    	PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");
		    ps.setInt(1, bean.getId());
		    ps.setString(2, bean.getRollNo());
		    ps.setString(3, bean.getFname());
		    ps.setString(4, bean.getLname());
		    ps.setInt(5, bean.getPhy());
		    ps.setInt(6, bean.getChem());
		    ps.setInt(7, bean.getMath());
		    ps.executeUpdate();
		    ps.close();
			
		} catch (SQLException e) {
			conn.rollback();
		
		}
	    conn.commit();
	    
	    System.out.println("Record(s) Inserted");
	    
	    conn.close();
	    
		
	}
	public void Update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
		
		 try {
			 PreparedStatement ps =  conn.prepareStatement("update Marksheet set Roll_NO =? ,FNAME = ? , LNAME = ? ,Physics =? , Chemistry = ? ,Maths = ? where ID = ?");
	         ps.setString(1, bean.getRollNo());
	         ps.setString(2,bean.getFname());
	         ps.setString(3,bean.getLname());
	         ps.setInt(4, bean.getPhy());
	         ps.setInt(5, bean.getChem());
	         ps.setInt(6, bean.getMath());
	         ps.setInt(6, bean.getId());
	         ps.executeUpdate();
	         ps.close();
				
			} catch (SQLException e) {
				conn.rollback();
				
			}
		 conn.commit();
		
         System.out.println("Record(s) Updated");
         

         conn.close();
         
		
	}
	public void Delete(String rollno) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
	
		 try {
			 PreparedStatement ps =  conn.prepareStatement("Delete from Marksheet where Roll_NO = ?");
				ps.setString(1, rollno);
				ps.executeUpdate();
				ps.close();
				
			} catch (SQLException e) {
				conn.rollback();
				
			}
		 conn.commit();
		
		System.out.println("Record(s) Deleted");
		
		conn.close();
		
		
	}
	public void Select() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
        
        PreparedStatement ps =  conn.prepareStatement("Select * from marksheet");
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
        	System.out.print(rs.getString(1));
        	System.out.print("\t"+rs.getString(2));
        	System.out.print("\t"+rs.getString(3));
        	System.out.print("\t"+rs.getString(4));
        	System.out.println("\t"+rs.getString(5));
			
		}
        ps.close();
        conn.close();
		
		
	}
	public void getMeritList() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
        
        PreparedStatement ps =  conn.prepareStatement("Select * , ((Physics+Maths+Chemistry)/300)*100 as percentage from marksheet order by percentage Desc");
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
        	System.out.print(rs.getString(1));
        	System.out.print("\t"+rs.getString(2));
        	System.out.print("\t"+rs.getString(3));
        	System.out.print("\t"+rs.getString(4));
        	System.out.print("\t"+rs.getString(5));
        	System.out.print("\t"+rs.getString(6));
        	System.out.println("\t"+rs.getString(7));
			
		}
        ps.close();
        conn.close();
		
		
	}
	public void get(String rollNo) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
        
        PreparedStatement ps =  conn.prepareStatement("Select * from employee where ROLL_NO = ?");
        ps.setString(1, rollNo);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
        	System.out.print(rs.getString(1));
        	System.out.print("\t"+"\t"+rs.getString(2));
        	System.out.print("\t"+"\t"+rs.getString(3));
        	System.out.print("\t"+"\t"+rs.getString(4));
        	System.out.print("\t"+rs.getString(5));
        	System.out.print("\t"+rs.getString(6));
        	System.out.println("\t"+rs.getString(7));
			
		}
        ps.close();
        conn.close();
		
	}
	
	

}
