package com.shinhan.day02;

//자바 프로그램은 class들로 이루어짐
//gkskdml .java 파일에 여러 개의 class 존재 가능
//public class이면 반드시 독립적인 파일로 저장한다
public class Review {
	
	//1.멤버변수
	//2.생성자
	//3.메서드
	//4.block
	//5.inner class

	/*main 메서드*/
	//static이 붙어있으면 java 파일 실행 시 메모리에 올라간다
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1.main 시작");
		
		f1();
		System.out.println("4.main 끝");

	}

	private static void f1() {
		// TODO Auto-generated method stub
		System.out.println("2.f1 함수 시작");
		
		//변수 :  하나의 값을 저장하기 위한 기억 장소의 이름
		//1.변수 선언 : data 성격에 따라 8가지 기본형과 그 외 참조형들
		//기본형 : byte(1), short(2), char(2,음수 X), int(4), long(4), float(4), double(8),boolean(1, true & false) >> 자바의 예약어는 모두 소문자
		//기본형은 값저장, 연산, 비교만 가능하고, 기능은 없다. >> Wrapper class로 기능 추가
		
		//Wrapper Class
		//Byte, Short, Character, Integer, Long, Float, Double, Boolean
		
		int var1;//var1은 변수는 int를 저장하고자 한다.
		Integer var2=100;
		
		//2.변수 초기화
		var1=Integer.MAX_VALUE;// =는 할당 연산자
		
		
		//3.변수 사용 ... 반드시 초기화 한 후에 사용
		
		System.out.println(var1);
		System.out.println(var2.floatValue());
		System.out.println("3.f1 함수 끝");
		
	}

}

class Review2{
	
}
