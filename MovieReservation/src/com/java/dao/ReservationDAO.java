package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.dto.Reservation;


public class ReservationDAO {

	private ReservationDAO() {}
	private static ReservationDAO instance = new ReservationDAO();
	public static ReservationDAO getInstance() {
		return instance;
	}
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 예매 완료시 DB저장
	public int save(Reservation reserve) {
		con = DBConnection.getConnection();
		
		try {
			pstmt = con.prepareStatement("insert into mr_reservation (rsv_id, rsv_name, rsv_poster, rsv_startDay, rsv_startTime, rsv_theater, rsv_seat, rsv_price) values(?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, reserve.getRsv_id());
			pstmt.setString(2, reserve.getRsv_name());
			pstmt.setString(3, reserve.getRsv_poster());
			pstmt.setString(4, reserve.getRsv_startDay());
			pstmt.setString(5, reserve.getRsv_startTime());
			pstmt.setString(6, reserve.getRsv_theater());
			pstmt.setString(7, reserve.getRsv_seat());
			pstmt.setInt(8, reserve.getRsv_price());
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public String getReservationName(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_reservation where rsv_id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("rsv_id").equals(id)) {
					String rsvName = rs.getString("rsv_name");
					return rsvName;
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
	
	public String getReservationPoster(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_reservation where rsv_id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("rsv_id").equals(id)) {
					String rsvName = rs.getString("rsv_poster");
					return rsvName;
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
	
	public String getReservationStartDay(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_reservation where rsv_id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("rsv_id").equals(id)) {
					String rsvName = rs.getString("rsv_startDay");
					return rsvName;
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
	
	public String getReservationStartTime(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_reservation where rsv_id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("rsv_id").equals(id)) {
					String rsvName = rs.getString("rsv_startTime");
					return rsvName;
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
	
	public String getReservationTheater(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_reservation where rsv_id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("rsv_id").equals(id)) {
					String rsvName = rs.getString("rsv_theater");
					return rsvName;
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
	
	public String getReservationSeat(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_reservation where rsv_id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("rsv_id").equals(id)) {
					String rsvName = rs.getString("rsv_seat");
					return rsvName;
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
	
	public int getReservationPrice(String id) {
		con = DBConnection.getConnection();
		try {
			pstmt = con.prepareStatement("select * from mr_reservation where rsv_id = ?");		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("rsv_id").equals(id)) {
					int rsvName = rs.getInt("rsv_price");
					return rsvName;
				}
				else {
					return 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return 0;
	}
}
