package com.shinhan.day04;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
		method2();

	}

	private static void method2() {
		// TODO Auto-generated method stub
		//Book이 5개 있다 가정?
		Book[] arr = new Book[6];
		arr[0]=new Book();
		arr[1]=new Book();
		arr[2]=new Book("Javascript",30000);
		arr[3]=new Book("HTML,CSS",20000);
		arr[4]=new Book("SpringFramework");
		arr[5]=new Book(50000);
		
		arr[0].title="이것이 자바다";
		arr[0].price=36000;
		
		arr[1].title="Oracle";
		arr[1].price=25000;
		
		//확장for문으로 출력
		for(Book b:arr) {
			b.bookInfoPrint();
		}
	}

	private static void method1() {
		// TODO Auto-generated method stub
		// 1.객체 참조 변수 선언
		Book b1 = null, b2 = null, b3,b4,b5,b6;
		// 2.객체 생성
		b1 = new Book();//기본 생성자
		b2 = new Book();
		b3 = new Book("Javascript",30000);
		b4 = new Book("HTML,CSS",20000);
		b5 = new Book("SpringFramework");
		b6 = new Book(50000);
		
		// 3.객체 사용
		b1.title="이것이 자바다";
		b1.price=36000;
		
		b2.title="Oracle";
		b2.price=25000;
		
//		System.out.println(b1.title+" "+b1.price);
//		System.out.println(b2.title+" "+b2.price);
//		System.out.println(b3.title+" "+b3.price);
//		System.out.println(b4.title+" "+b4.price);
//		System.out.println(b5.title+" "+b5.price);
//		System.out.println(b6.title+" "+b6.price);
		
		b1.bookInfoPrint();
		b2.bookInfoPrint();
		b3.bookInfoPrint();
		b4.bookInfoPrint();
		b5.bookInfoPrint();
		b6.bookInfoPrint();
	}

}
