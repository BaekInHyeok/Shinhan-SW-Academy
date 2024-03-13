package com.shinhan.day01;

public class PrintfExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		f1();
		f2();
		f3();
		f4();

	}

	

	private static void f1() {
		// TODO Auto-generated method stub
		System.out.println("One\t");
		System.out.println("two\t");
		System.out.println("three\t");
	}
	
	private static void f2() {
		// TODO Auto-generated method stub
		System.out.print("One\t");
		System.out.print("two\t");
		System.out.print("three\t");
	}
	
	private static void f3() {
		// TODO Auto-generated method stub
		
		int a =100;
		String b="자바";
		
		System.out.printf("a=%d",a);
		System.out.printf("b=%s",b);
	}
	
	private static void f4() {
		// TODO Auto-generated method stub
		int value=123;
		System.out.printf("%d원\n",value);
		System.out.printf("%6d원\n",value);
		System.out.printf("%-6d원\n",value);
		System.out.printf("%06d원\n",value);
		
		double area = 3.14159 * 10 * 10;
		System.out.printf("반지름이 %d인 원의 넓이 : %10.2f\n", 10, area);
		System.out.printf("반지름이 %d인 원의 넓이 : %-10.2f\n", 10, area);
		

	}
	
	

}
