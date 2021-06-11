package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.java.dto.Member;
import com.java.dto.Movie;
import com.java.dto.Reservation;

public class MovieDAO {

	private MovieDAO() {}
	private static MovieDAO instance = new MovieDAO();
	public static MovieDAO getInstance() {
		return instance;
	}
	
	private Connection con;
	private PreparedStatement pstmt;
	private PreparedStatement pstmt2;
	private ResultSet rs;
	
	public Vector<Movie> findByAllMovie() {
		con = DBConnection.getConnection();
		Vector<Movie> movies = new Vector<>();
		
		try {
			pstmt = con.prepareStatement("select * from mr_movielist");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie();
				movie.setM_name(rs.getString("m_name"));
				movie.setM_poster(rs.getString("m_poster"));
				movie.setM_price(rs.getInt("m_price"));
				movie.setM_runningTime(rs.getInt("m_runningTime"));
				movie.setM_startDay(rs.getString("m_startDay"));
				movie.setM_startTime(rs.getString("m_startTime"));
				movie.setM_theater(rs.getString("m_theater"));
				movie.setM_count(rs.getInt("m_count"));
				movies.add(movie);
			}
			return movies;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("findByAll 에러");
		}
		return null;
	}
	
	public Vector<String> getMovieList() {
		Vector<String> movieList = new Vector<>();
		
		movieList.add("영화 제목");
		movieList.add("상영관");
		movieList.add("상영 시작 날짜");
		movieList.add("상영 시작 시간");
		movieList.add("영화 상영 시간(분)");
		movieList.add("가격");
		movieList.add("포스터");
		movieList.add("누적 예매수");
		return movieList;
	}
	
	public Vector<String> getMovieReserveList() {
		Vector<String> movieList = new Vector<>();
		
		movieList.add("영화 제목");
		movieList.add("상영관");
		movieList.add("상영 날짜");
		movieList.add("상영 시작 시간");
		movieList.add("영화 상영 시간(분)");
		movieList.add("가격");
		movieList.add("포스터");
		
		return movieList;
	}
	
	public int movieUpload(Movie movie) {
		con = DBConnection.getConnection();
		
		try {

			pstmt = con.prepareStatement("insert into mr_movielist (m_name, m_poster, m_price, m_runningTime, m_startDay, m_startTime, m_theater, m_count) values(?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, movie.getM_name());
			pstmt.setString(2, movie.getM_poster());
			pstmt.setInt(3, movie.getM_price());
			pstmt.setInt(4, movie.getM_runningTime());
			pstmt.setString(5, movie.getM_startDay());
			pstmt.setString(6, movie.getM_startTime());
			pstmt.setString(7, movie.getM_theater());
			pstmt.setInt(8, movie.getM_count());
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delete(Movie movie) {
		con = DBConnection.getConnection();
		
		try {
			pstmt = con.prepareStatement("delete from mr_movielist where m_name = ? ");
			
			pstmt.setString(1, movie.getM_name());
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int count(Movie movie) {
		con = DBConnection.getConnection();
		
		try {
			pstmt = con.prepareStatement("update mr_movielist SET m_count = m_count + ? where m_name = ?");
			
			pstmt.setInt(1, movie.getM_count());
			pstmt.setString(2, movie.getM_name());
			
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("count 오류");
		}
		return -1;
	}
	
	public String recomRate1() {
		con = DBConnection.getConnection();
		
		try {
			// distinct 중복제거
			pstmt = con.prepareStatement("SELECT DISTINCT m_poster from mr_movielist order by m_count DESC LIMIT 1");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				String m_poster = rs.getString("m_poster");
				return m_poster;
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("recom() 오류");
		}
		return null;
	}
	
	public String recomRate2() {
		con = DBConnection.getConnection();
		
		try {
			// distinct 중복제거, limit 가져올 레코드 수, offset 컬럼의 n번째 값 
			pstmt = con.prepareStatement("SELECT DISTINCT m_poster from mr_movielist order by m_count DESC LIMIT 1 offset 1");
			
			rs = pstmt.executeQuery();
			if(rs.next()) { 
			String m_poster = rs.getString("m_poster");
			return m_poster;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("recom() 오류");
		}
		return null;
	}
	public String recomRate3() {
		con = DBConnection.getConnection();
		
		try {
			// distinct 중복제거
			pstmt = con.prepareStatement("SELECT DISTINCT m_poster from mr_movielist order by m_count DESC LIMIT 1 offset 2");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				String m_poster = rs.getString("m_poster");
				return m_poster;
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("recom() 오류");
		}
		return null;
	}
}
