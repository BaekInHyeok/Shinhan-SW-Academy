package com.shinhan.day09;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.shinhan.util.DateUtil;

public class ObjectTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
		f8();
	}

	private static void f8() {
		// TODO Auto-generated method stub
		java.util.Date d = new java.util.Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		System.out.println(d);
		System.out.println(sdf.format(d));

		// 문자 >> 일자
		String s = "2024/03/22";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");

		try {
			java.util.Date d2 = sdf2.parse(s);// Exception 처리를 반드시 해야 함
			System.out.println(d2);

			java.sql.Date d3 = new java.sql.Date(d2.getTime());
			System.out.println(d3);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String s2 = "2024-03-22";
		System.out.println(DateUtil.getUtilDate(s2));
		System.out.println(DateUtil.getSQLDate(s2));

	}

	private static void f7() {
		// TODO Auto-generated method stub
		int a = 1234567890;
		DecimalFormat format = new DecimalFormat("###,###,###");
		System.out.println(a);
		System.out.println(format.format(a));
	}

	private static void f6() {
		// TODO Auto-generated method stub
		LocalDateTime d1 = LocalDateTime.now();
		LocalDate d2 = LocalDate.now();
		System.out.println(d1);
		System.out.println(d2);

		System.out.println(d1.getYear());
		System.out.println(d1.getMonth());
		System.out.println(d1.getDayOfMonth());
		System.out.println(d1.getHour());
		System.out.println(d1.getDayOfWeek());
	}

	private static void f5() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH + 1));// 0월부터 있음
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.HOUR));
	}

	private static void f4() {
		// TODO Auto-generated method stub
		Date d1 = new Date();// 직접 만든 거
		java.util.Date d2 = new java.util.Date();// java에서 제공
		System.out.println(d2);
		System.out.println(1900 + d2.getYear());
		System.out.println(d2.getTime());

		java.sql.Date d3 = new java.sql.Date(d2.getTime());
		java.sql.Date d4 = new java.sql.Date(2024, 3, 22);

		System.out.println(d3);
		System.out.println(d4);

	}

	private static void f3() {
		// TODO Auto-generated method stub
		double a = 5.3;
		System.out.println(Math.ceil(a));// 올림
		System.out.println(Math.floor(a));// 버림
		System.out.println(Math.round(a));// 반올림
	}

	private static void f2() {
		// TODO Auto-generated method stub
		String s = "100";
		int b = Integer.parseInt(s);
		double d = Double.parseDouble(s);
	}

	private static void f1() {
		// TODO Auto-generated method stub
		Integer a = 100;// Auto Boxing
		// Integer a = new Integer(100); // deprecated

		int b = a.intValue() + 200;// unBoxing
	}

}
