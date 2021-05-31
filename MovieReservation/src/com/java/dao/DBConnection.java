package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() {
		Connection con = null;
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/moviereservation";
		String uid = "root";
		String pwd = "suho1999";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB연결 실패");
		} catch (Exception e) {
				e.printStackTrace();
			}
		
		return con;
	}
	
	public static void close(Connection c, PreparedStatement psmt, ResultSet rs) {
		try {
			if(c != null) c.close();
			if(psmt != null) psmt.close();
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(Connection c, PreparedStatement psmt) {
		try {
			if(c != null) c.close();
			if(psmt != null) psmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		getConnection();
	}

}
