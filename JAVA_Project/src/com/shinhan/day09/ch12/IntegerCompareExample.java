package com.shinhan.day09.ch12;

import java.util.Random;

import com.shinhan.day09.ComputerVO;

public class IntegerCompareExample {
	
	public static void main(String[] args) throws Exception {
		Class a = ComputerVO.class;
		Class b = new ComputerVO().getClass();
		Class c = Class.forName("com.shinhan.day09.ComputerVO");
		
		a.getResource("");//클래스 경로
	}

	public static void f2(String[] args) {
		double d= Math.random();
		System.out.println(d);
		
		Random r = new Random();
		
		double d2 = r.nextDouble(10);
		
		int i = r.nextInt();
		System.out.println(i);
		
		
	}
	public static void f1(String[] args) {

		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;

		// == : 값의 범위가 -128~127이면 값을 비교, 그 위는 주소를 비교함

		System.out.println(obj1 == obj2);
		System.out.println(obj3 == obj4);

		System.out.println(obj1.equals(obj2));
		System.out.println(obj3.equals(obj4));
		
		
		

	}

}
