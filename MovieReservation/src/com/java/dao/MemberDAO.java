package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.java.dto.Member;

public class MemberDAO {
	private MemberDAO() {}
		private static MemberDAO instance = new MemberDAO();
		public static MemberDAO getInstance() {
			return instance;
		}
		
		private Connection con;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		// 로그인
		public int findByUsernameAndPassword(String id, String pwd) {
			con = DBConnection.getConnection();
			
			System.out.println(id);
			System.out.println(pwd);
			try {
				pstmt = con.prepareStatement("select * from mr_member where id = ? and pwd = ?");
				
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					if(rs.getString("id").equals("admin")) {
						return 2;
					}
					else {
						return 1;
					}// 로그인 성공
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;	// 로그인 실패
		}
		
		// 회원가입
		
		public int save(Member member) {
			con = DBConnection.getConnection();
			
			try {
				//pstmt = con.prepareStatement("insert into member values(member_seq.nextval, ?,?,?,?,?, sysdate)");

				pstmt = con.prepareStatement("insert into mr_member (id, pwd, name, tel, addr, birth, gender, date) values(?,?,?,?,?,?,?,?)");
				
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPwd());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getTel());
				pstmt.setString(5, member.getAddr());
				pstmt.setString(6, member.getBirth());
				pstmt.setString(7, member.getGender());
				pstmt.setTimestamp(8, member.getCreateDate());
				pstmt.executeUpdate();
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		}
		
		public int delete(Member member) {
			con = DBConnection.getConnection();
			
			try {
				pstmt = con.prepareStatement("delete from mr_member where id = ? ");
				
				pstmt.setString(1, member.getId());
				pstmt.executeUpdate();
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		}
		
		// 회원정보 확인
		public Vector<Member> findByAll() {
			con = DBConnection.getConnection();
			Vector<Member> members = new Vector<>();
			
			try {
				pstmt = con.prepareStatement("select * from mr_member");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Member member = new Member();
					member.setId(rs.getString("id"));
					member.setPwd(rs.getString("pwd"));
					member.setName(rs.getString("name"));
					member.setTel(rs.getString("tel"));
					member.setAddr(rs.getString("addr"));
					member.setBirth(rs.getString("birth"));
					member.setGender(rs.getString("gender"));
					member.setCreateDate(rs.getTimestamp("date"));
					members.add(member);
				}
				return members;
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("findByAll 에러");
			}
			return null;
		}
		
		public Vector<String> getMemberName() {
			Vector<String> memberName = new Vector<>();
			
			memberName.add("ID");
			memberName.add("PASSWORD");
			memberName.add("NAME");
			memberName.add("PHONE");
			memberName.add("ADDRESS");
			memberName.add("BIRTH");
			memberName.add("GENDER");
			memberName.add("CREATE_DATE");
			
			return memberName;
		}
}


