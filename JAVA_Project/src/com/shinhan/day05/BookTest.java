package com.shinhan.day05;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method1();
		//method2();
		method3();

	}

	private static void method3() {
		// TODO Auto-generated method stub
		int a = Integer.MAX_VALUE;

		System.out.println(a);

		int b = Integer.compare(10, 30);
		System.out.println(b);
		
		int c = Integer.compare(30, 20);
		System.out.println(c);
	}

	private static void method2() {
		// TODO Auto-generated method stub
		// Book.ISBN2="8888"; >>상수는 변경 불가
		System.out.println(Book.ISBN);
		System.out.println(Book.ISBN2);

		Book b1 = new Book();
		// 올바른 사용법은 아님(클래스 단위 변수들이기 때문임)
		System.out.println(b1.ISBN);
		System.out.println(b1.ISBN2);
	}

	private static void method1() {
		// TODO Auto-generated method stub
		System.out.println(Book.bookCount);

		Book b1 = new Book();
		System.out.println(b1.title);
		System.out.println(b1.price);
		System.out.println(b1.publish);
		System.out.println(b1.publish2);
		System.out.println(b1.publish3);

	}

}
