package com.shinhan.day06;

class A {
	int score = 100;

	void print() {
	}
}

class B extends A {
	int score2 = 99;

	void print2() {
	}
}

class C extends A {
	int score2 = 99;

	void print2() {
	}
}

class D extends B {
}

class E extends C {
}

public class InheritenceTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
		method2();

	}

	private static void method2() {
		// 변수의 타입을 따른다. >> A
		A var1 = new B();
		System.out.println(var1.score);
		// System.out.println(var1.score2); >> 접근 불가능
		var1.print();
		// var1.print2(); >> 접근 불가능

		// 모두 정상적으로 접근 가능
		B var2 = (B) var1;// 강제 형변환
		System.out.println(var2.score);
		System.out.println(var2.score2);
		var2.print();
		var2.print2();

		if (var1 instanceof C var3) {
			C var4 = (C) var1;
			System.out.println(var4.score2);
			var4.print2();
		}

	}

	private static void method1() {
		// TODO Auto-generated method stub
		Object obj = new A();

		A a = new A();

		Object b1 = new B();
		B b2 = new B();
		A b3 = new B();

		Object d1 = new D();
		D d2 = new D();
		B d3 = new D();
		A d4 = new D();

	}

}
