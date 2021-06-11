package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.dto.Member;

public class MemberInfoDAO {
	private MemberInfoDAO() {}
	private static MemberInfoDAO instance = new MemberInfoDAO();
	public static MemberInfoDAO getInstance() {
		return instance;
	}
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public String getMemberInfoId(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_member where id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("id").equals(id)) {
					String memberId = rs.getString("id");
					return memberId;
				} 
				else {
					return null;
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public String getMemberInfoPwd(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_member where id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("id").equals(id)) {
					String memberPwd = rs.getString("pwd");
					return memberPwd;
				}
				else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public String getMemberInfoName(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_member where id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("id").equals(id)) {
					String memberName = rs.getString("name");
					return memberName;
				}
				else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public String getMemberInfoTel(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_member where id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("id").equals(id)) {
					String memberTel = rs.getString("tel");
					return memberTel;
				}
				else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public String getMemberInfoAddr(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_member where id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("id").equals(id)) {
					String memberAddr = rs.getString("addr");
					return memberAddr;
				}
				else {
					System.out.println("MemberInfo 오류");
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public String getMemberInfoBirth(String id) {
		con = DBConnection.getConnection();
		try {
			
			pstmt = con.prepareStatement("select * from mr_member where id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("id").equals(id)) {
					String memberBirth = rs.getString("birth");
					return memberBirth;
				}
				else {
					System.out.println("MemberInfo 오류");
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public String getMemberInfoGender(String id) {
		con = DBConnection.getConnection();
		try {													
			pstmt = con.prepareStatement("select * from mr_member where id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("id").equals(id)) {
					String memberGender = rs.getString("gender");
					return memberGender;
				}
				else {
					System.out.println("MemberInfo 오류");
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public int update(String id, String pwd, String tel, String addr) {
		con = DBConnection.getConnection();
		
		try {
			
			pstmt = con.prepareStatement("update mr_member SET pwd = ?, tel = ?, addr = ? where id = ?");
			
			pstmt.setString(1, pwd);
			pstmt.setString(2, tel);
			pstmt.setString(3, addr);
			pstmt.setString(4, id);
			
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			System.out.println("update문 오류");
			e.printStackTrace();
		}
		return -1;
	}
}
