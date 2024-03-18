package com.shinhan.day05;

//java.lang 아래에 있는 class는 import 없이 사용 가능
//그 외는 반드시 import하여 사용
//외부에 있는 class를 이용하는 경우 반드시 import 후 사용한다.


public class Book {
	// 1.field
	//class 변수
	static int bookCount;
	//instance 변수
	String title;
	int price;
	
	//final(최종):1회만 값을 할당, 이후 수정 불가
	//1)선언시 초기화, 2)생성자로 초기화 3)instance block{}으로 초기화
	final String publish="한빛미디어";
	final String publish2;
	final String publish3;
	
	//상수(불변)
	//1)선언 시 초기화 2)static block 초기화
	static final String ISBN="1234-5678";
	static final String ISBN2;
	static {
		ISBN2="8888-9999";
	}
	
	// 2.constructor
	Book(){
		System.out.println("default 생성자를 정의");
		this.publish2="default 생성자에서 초기화";
	}
	Book(String publish2){
		this.publish2=publish2;
	}
	
	{
		publish3="한빛미디어3";
	}
	// 3.method
	void test1() {
		//publish="한빛미디어2";수정 불가
	}
	// 4.block
	// 5.inner class
}
