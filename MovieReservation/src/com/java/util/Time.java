package com.java.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Time {

	// DB에 LocalDateTime을 insert
	public static Timestamp localDateTimeToTimeStamp(LocalDateTime ldt) {
		return Timestamp.valueOf(ldt);
	}
	
	// DB의 Timestamp를 Java로 select하여 가져옮
	public static LocalDateTime timeStampToLocalDateTime(Timestamp ts) {
		return ts.toLocalDateTime();
	}
	
	public static void main(String[] args) {
		Timestamp ts = localDateTimeToTimeStamp(LocalDateTime.now());
		System.out.println("ts : " + ts);
		
		LocalDateTime ldt = timeStampToLocalDateTime(ts);
		System.out.println("ldt : " + ldt);
	}

}
