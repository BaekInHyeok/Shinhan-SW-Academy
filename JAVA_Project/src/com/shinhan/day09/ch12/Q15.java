package com.shinhan.day09.ch12;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Q15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDateTime today = LocalDateTime.now();
		LocalDateTime lastday = LocalDateTime.of(today.getYear(), 12,31,0,0,0);
		
		long remainDay = today.until(lastday, ChronoUnit.DAYS);
		
		System.out.println("남은 일자:"+remainDay);
		
		

	}

}
