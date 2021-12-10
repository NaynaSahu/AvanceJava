package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationModel {

	public static Integer nextPK() throws SQLException {
		Connection conn = null;
		int pk = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raysapp", "root", "root");

			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM userinfo");
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

	public void add(RegistrationBean bean) throws Exception {

		int pk = 0;
		pk = nextPK();

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raysapp", "root", "root");
		conn.setAutoCommit(false);
		try {
			PreparedStatement ps = conn.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, pk);
			ps.setString(2, bean.getFname());
			ps.setString(3, bean.getLname());
			ps.setString(4, bean.getEmail());
			ps.setString(5, bean.getPass());
			ps.setString(6, bean.getDob());
			ps.setString(7, bean.getGender());
			ps.setString(8, bean.getUsername());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			conn.rollback();
		}
		conn.commit();

		System.out.println("Record(s) Inserted");

		conn.close();

	}

	public RegistrationBean Authentication(String Username, String Password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raysapp", "root", "root");
		RegistrationBean bean = null;
		PreparedStatement ps = conn.prepareStatement("Select * from userinfo where UserName=? and Password =?");
		ps.setString(1, Username);
		ps.setString(2, Password);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new RegistrationBean();
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPass(rs.getString(5));
			bean.setDob(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setUsername(rs.getString(8));

		}
		ps.close();
		System.out.println("Found the user");
		conn.close();
		return bean;

	}

	public RegistrationBean ForgetPassword(String email) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raysapp", "root", "root");
		RegistrationBean bean = null;
		PreparedStatement ps = conn.prepareStatement("Select * from userinfo where Email= ?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bean = new RegistrationBean();
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPass(rs.getString(5));
			bean.setDob(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setUsername(rs.getString(8));

		}
		ps.close();
		System.out.println("Found the user");
		System.out.println(bean+"<PPPPPPPP");
		conn.close();
		

		return bean;

	}

}
