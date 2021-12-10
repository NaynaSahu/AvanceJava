package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {

	public static Integer nextPK() throws SQLException {
		Connection conn = null;
		int pk = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raysapp", "root", "root");

			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM studentinfo");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return pk + 1;
	}
	public static void add(StudentBean bean) throws Exception {
         int pk = 0;
         pk = nextPK();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raysapp", "root", "root");
		conn.setAutoCommit(false);
		try {
			PreparedStatement ps = conn.prepareStatement("insert into studentinfo values(?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bean.getRollNo());
			ps.setString(3, bean.getFirstName());
			ps.setString(4, bean.getLastName());
			ps.setString(5, bean.getSession());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			conn.rollback();
		}
		conn.commit();

		System.out.println("Record(s) Inserted");

		conn.close();

	
		
	}
	public static void update(StudentBean bean ) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raysapp", "root", "root");
		conn.setAutoCommit(false);
		try {
			PreparedStatement ps = conn.prepareStatement("update studentinfo set FirstName = ? , LastName = ? , Session =? where RollNo = ?");
			ps.setString(1, bean.getFirstName());
			ps.setString(2, bean.getLastName());
			ps.setString(3, bean.getSession());
			ps.setString(4, bean.getRollNo());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			conn.rollback();
		}
		conn.commit();

		System.out.println("Record(s) Updated");

		conn.close();
	}
	public static void delete(String roll) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raysapp", "root", "root");
		conn.setAutoCommit(false);
		try {
			PreparedStatement ps = conn.prepareStatement("delete from studentinfo where RollNo = ?");
			ps.setString(1 , roll );
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			conn.rollback();
		}
		conn.commit();

		System.out.println("Record(s) Deleted");

		conn.close();
	}
	public static StudentBean get(String roll) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raysapp", "root", "root");
		conn.setAutoCommit(false);
		StudentBean bean = new StudentBean();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM  studentinfo where RollNo = ?");
			ps.setString(1 , roll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				bean.setId(rs.getInt(1));
				bean.setRollNo(rs.getString(2));
				bean.setFirstName(rs.getString(3));
				bean.setLastName(rs.getString(4));
				bean.setSession(rs.getString(5));
				
				
			}
			
			ps.close();
		} catch (SQLException e) {
			conn.rollback();
		}
		
		
		conn.commit();

		System.out.println("Record(s) Selected");

		conn.close();
		return bean;
	}
	public static ArrayList search(StudentBean bean1) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raysapp", "root", "root");
		conn.setAutoCommit(false);
		ArrayList list = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM  studentinfo ");
			//ps.setString(1 , roll );
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setId(rs.getInt(1));
				bean.setRollNo(rs.getString(2));
				bean.setFirstName(rs.getString(3));
				bean.setLastName(rs.getString(4));
				bean.setSession(rs.getString(5));
				list.add(bean);
			}
			
			ps.close();
		} catch (SQLException e) {
			conn.rollback();
		}
		
		conn.commit();
		
		System.out.println("Record(s) Selected");

		conn.close();
		return list;
	}
	
	
	

}
