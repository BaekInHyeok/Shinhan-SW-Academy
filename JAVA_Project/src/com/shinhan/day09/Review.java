package com.shinhan.day09;

import java.io.FileNotFoundException;
import java.io.IOException;

//인터페이스 : 정의만 하고 구현은 안함
//@FunctionalInterface >> 함수가 여러개이므로 람다식 불가
interface MyInterface {
	public abstract void method1();// public abstract는 생략 가능

	void method2() throws IOException;

	void method3() throws Exception;
}

//구현class
//1.부모의 throws Exception이 존재하지 않는 경우 >> 없거나, RuntimeException 가능
//2.자식은 부모의 Exception보다 더 하위이다.
class MyclassImpl implements MyInterface {

	@Override
	public void method1() throws RuntimeException {
		// TODO Auto-generated method stub
		System.out.println("method1()");

	}

	// 자식의 Exception 범위가 더 작으므로 괜찮음
	@Override
	public void method2() throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("method2()");

	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		System.out.println("method3()");

	}

}

public class Review {

	// 1.field
	MyInterface b1 = new MyclassImpl();//생성자로 호출

	MyInterface b2 = new MyInterface() {//익명 구현 class
		public void method1() {
		}

		public void method2() {
		}

		public void method3() {
		}
	};

	public static void main(String[] args) {
		// 2.Local 변수로
		MyInterface a = new MyclassImpl();

		call(new MyclassImpl());

		call(new MyInterface() {
			public void method1() {
			}

			public void method2() {
			}

			public void method3() {
			}
		});

	}

	private static void call(MyInterface c) {
		// TODO Auto-generated method stub

	}

}
