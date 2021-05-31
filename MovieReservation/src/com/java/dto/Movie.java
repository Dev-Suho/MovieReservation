package com.java.dto;

public class Movie {
	private String m_name;
	private String m_poster;
	private int m_price;
	private int m_runningTime;
	private String m_startTime;
	private String m_endTime;
	
	public Movie() {}
	
	public Movie(String m_name,String m_poster, int m_price, int m_runningTime, String m_startTime, String m_endTime ) {
		this.m_name = m_name;
		this.m_poster = m_poster;
		this.m_price = m_price;
		this.m_runningTime = m_runningTime;
		this.m_startTime = m_startTime;
		this.m_endTime = m_endTime;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_poster() {
		return m_poster;
	}

	public void setM_poster(String m_poster) {
		this.m_poster = m_poster;
	}

	public int getM_price() {
		return m_price;
	}

	public void setM_price(int m_price) {
		this.m_price = m_price;
	}

	public int getM_runningTime() {
		return m_runningTime;
	}

	public void setM_runningTime(int m_runningTime) {
		this.m_runningTime = m_runningTime;
	}

	public String getM_startTime() {
		return m_startTime;
	}

	public void setM_startTime(String m_startTime) {
		this.m_startTime = m_startTime;
	}

	public String getM_endTime() {
		return m_endTime;
	}

	public void setM_endTime(String m_endTime) {
		this.m_endTime = m_endTime;
	}
}
