package com.rays.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;



public class UserModel {
	public int nextpk() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Application", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from Information");
		ResultSet rs = ps.executeQuery();
		int y = 0;
		while (rs.next()) {
			y = rs.getInt(1);
		}
		return y + 1;

	}

	public void add(UserBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Application", "root", "root");
		conn.setAutoCommit(false);
		try {
			PreparedStatement ps = conn.prepareStatement("insert into Information values(?,?,?,?,?,?,?)");
			ps.setInt(1, nextpk());
			ps.setString(2, bean.getFname());
			ps.setString(3, bean.getLname());
			ps.setString(4, bean.getGender());
			ps.setString(5, bean.getEmail());
			ps.setString(6, bean.getUser());
			ps.setString(7, bean.getPassword());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException E) {

		}
		conn.commit();
		//System.out.println("inserted");
		conn.close();

	}

	public static void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Application", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(
				"update Information set fname = ? , lname =? , email = ?, user = ? ,password = ? WHERE ID = ?");
		try {
			ps.setString(1, bean.getFname());
			ps.setString(2, bean.getLname());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getUser());
			ps.setString(5, bean.getPassword());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			conn.rollback();
		}
		System.out.println("RECORD(S) UPDATED");
		conn.close();

	}

	public UserBean Authentication(String e ,String us, String pa) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Application", "root", "root");
		UserBean bean = null;
		PreparedStatement ps = conn.prepareStatement("select * from Information where Email = ? and UserName = ? and Password = ? ");
		ps.setString(1, e);
		ps.setString(2, us);
		ps.setString(3, pa);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
		    bean = new UserBean(); 	
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setUser(rs.getString(6));
			bean.setPassword(rs.getString(7));
			
			
			
			/*if (us != null && pa != null) {
			System.out.println(rs.getString(1)); 
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getString(7));
			
			*///	System.out.println(us + " " + pa);

		}
		ps.close();

		conn.close();

		
		return bean;		
		
	

	}
	public void select() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Application", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from Information where id = 4 ");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1)); 
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getString(7));
			}

		ps.close();
		conn.close();

	}


}
