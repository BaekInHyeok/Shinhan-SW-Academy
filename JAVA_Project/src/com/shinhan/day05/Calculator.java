package com.shinhan.day05;

public class Calculator {
	// 1.static field
	static double pi = 3.141592;
	static String company = "퍼스트존";
	static String company2;

	String color;//->객체 생성 후에 호출할 수 있다.
	
	// 2.static block
	static {
		System.out.println("class load시에 1회 수행");
		company2 = "상공회의소";
		//color="red";
	}

	// static method
	static double plus(int a, int b){
		Calculator cal=new Calculator();
		cal.color="red";
		return a+b+pi;
	}
	double minus(int a, int b){
		color="red";
		return a-b+pi;
	}

}
