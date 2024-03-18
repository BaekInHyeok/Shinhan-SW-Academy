package com.shinhan.day05;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Calculator.company);
		System.out.println(Calculator.company2);
		System.out.println(Calculator.plus(1, 2));
		//System.out.println(Calculator.minus(1, 2));

		Calculator cal1=new Calculator();
		System.out.println(cal1.minus(1, 2));
		double result=new Calculator().minus(1, 2);
		System.out.println(result);

	}

}
