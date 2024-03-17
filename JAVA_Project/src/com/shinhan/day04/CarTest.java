package com.shinhan.day04;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//method1();
		method2();
	}

	private static void method2() {
		// TODO Auto-generated method stub
		Car c1=new Car("ABC","black",300);
		System.out.println(c1);
	}

	private static void method1() {
		// TODO Auto-generated method stub
		Car c1=new Car("ABC","black",300);
		String result=c1.carInfoPrint("***");
		System.out.println(result);
		
		c1.powerOn();//객체참조변수를 통해서 호출
	}

}
