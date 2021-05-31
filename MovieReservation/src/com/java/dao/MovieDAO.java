package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.java.dto.Movie;

public class MovieDAO {

	private MovieDAO() {}
	private static MovieDAO instance = new MovieDAO();
	public static MovieDAO getInstance() {
		return instance;
	}
	
	private Connection con;
	private PreparedStatement pstmt;
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
				movie.setM_startTime(rs.getString("m_startTime"));
				movie.setM_endTime(rs.getString("m_endTime"));
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
		movieList.add("포스터");
		movieList.add("상영 시작 기간");
		movieList.add("상영 종료 기간");
		movieList.add("영화 상영 시간(분)");
		movieList.add("가격");
		
		return movieList;
	}
	
	public int movieUpload(Movie movie) {
		con = DBConnection.getConnection();
		
		try {

			pstmt = con.prepareStatement("insert into mr_movielist (m_name, m_poster, m_price, m_runningTime, m_startTime, m_endTime) values(?,?,?,?,?,?)");
			
			pstmt.setString(1, movie.getM_name());
			pstmt.setString(2, movie.getM_poster());
			pstmt.setInt(3, movie.getM_price());
			pstmt.setInt(4, movie.getM_runningTime());
			pstmt.setString(5, movie.getM_startTime());
			pstmt.setString(6, movie.getM_endTime());
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
