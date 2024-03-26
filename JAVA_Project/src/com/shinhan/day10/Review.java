package com.shinhan.day10;

import java.io.FileNotFoundException;

//변수(data)+기능(메서드)
class Machine extends Object {
	Machine() {
		super();
		System.out.println("Machine 기본 생성자");
	}

}

//규격서 : 상수+추상메서드+default,static,private 메서드
interface MyInterface {
	public abstract void method1();
}

//상속 : 보모의 private를 제외한 모든 변수(data)+기능(메서드) 접근 가능
//수정(override) 가능, 추가 가능(이름 같고 매개변수가 다르면 Overloading), 추가(이름 다름)
class CoffeeMachine extends Machine implements MyInterface, AutoCloseable {

	CoffeeMachine() {
		super();
		System.out.println("CoffeeMachine 기본생성자");
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AutoClosable interface의 close() 재정의");

	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("method1....구현class가 interface에서 정의한 추상메서드를 구현");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoffeeMachine []...field가 있다면 field에 있는 정보로 문자열 만듬");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return "Coffee".hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return "Coffee".equals("Coffee");
	}

}

public class Review {

	public static void main(String[] args) {

//		//CoffeeMachine coffee1 = new CoffeeMachine();
//		//coffee1.method1();
//		
//		//AutoClose 구현
//		try(CoffeeMachine coffee1 = new CoffeeMachine()) {
//			coffee1.method1();
//			//coffee1.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			
//		}

		try (CoffeeMachine coffee1 = new CoffeeMachine(); CoffeeMachine coffee2 = new CoffeeMachine();) {
			coffee1.method1();
			coffee2.method1();

			System.out.println(coffee1);
			System.out.println(coffee2);
			System.out.println(coffee1 == coffee2);
			System.out.println(coffee1.equals(coffee2));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
