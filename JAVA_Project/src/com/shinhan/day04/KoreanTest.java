package com.shinhan.day04;

public class KoreanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();

	}

	private static void method1() {
		// TODO Auto-generated method stub
		//1.객체참조변수선언
		//2.객체생성
		Korean k1 = new Korean("신현상","12345");
		Korean k2 = new Korean("가영");
		
		//3.객체사용
//		System.out.println(k1.nation);
//		System.out.println(k1.name);
//		System.out.println(k1.ssn);
		k1.print();
		k2.print();
		
		System.out.println(k1);
		
	}

}
