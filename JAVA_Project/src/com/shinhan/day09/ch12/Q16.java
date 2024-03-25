package com.shinhan.day09.ch12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Q16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
		
		System.out.println(sdf.format(now));
	}

}
