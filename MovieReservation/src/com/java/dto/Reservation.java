package com.java.dto;

public class Reservation {
	private String rsv_id;
	private String rsv_name;
	private String rsv_poster;
	private String rsv_startDay;
	private String rsv_startTime;
	private String rsv_theater;
	private String rsv_seat;
	private int rsv_price;
	
	public Reservation() {}
	
	public Reservation(String rsv_id, String rsv_name,String rsv_poster,String rsv_startDay,String rsv_startTime, String rsv_theater, String rsv_seat, int rsv_price) {
		this.rsv_id = rsv_id;
		this.rsv_name = rsv_name;
		this.rsv_poster = rsv_poster;
		this.rsv_startDay = rsv_startDay;
		this.rsv_startTime = rsv_startTime;
		this.rsv_theater = rsv_theater;
		this.rsv_seat = rsv_seat;
		this.rsv_price = rsv_price;
	}

	public String getRsv_id() {
		return rsv_id;
	}

	public void setRsv_id(String rsv_id) {
		this.rsv_id = rsv_id;
	}

	public String getRsv_name() {
		return rsv_name;
	}

	public void setRsv_name(String rsv_name) {
		this.rsv_name = rsv_name;
	}

	public String getRsv_poster() {
		return rsv_poster;
	}

	public void setRsv_poster(String rsv_poster) {
		this.rsv_poster = rsv_poster;
	}

	public String getRsv_startDay() {
		return rsv_startDay;
	}

	public void setRsv_startDay(String rsv_startDay) {
		this.rsv_startDay = rsv_startDay;
	}

	public String getRsv_startTime() {
		return rsv_startTime;
	}

	public void setRsv_startTime(String rsv_startTime) {
		this.rsv_startTime = rsv_startTime;
	}

	public String getRsv_theater() {
		return rsv_theater;
	}

	public void setRsv_theater(String rsv_theater) {
		this.rsv_theater = rsv_theater;
	}

	public String getRsv_seat() {
		return rsv_seat;
	}

	public void setRsv_seat(String rsv_seat) {
		this.rsv_seat = rsv_seat;
	}

	public int getRsv_price() {
		return rsv_price;
	}

	public void setRsv_price(int rsv_price) {
		this.rsv_price = rsv_price;
	}
}
