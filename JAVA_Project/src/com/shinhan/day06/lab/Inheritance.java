package com.shinhan.day06.lab;

class C extends B {
	int meth() {
		return 100;
	}

	static int sMeth() {
		return 100;
	}
}

class B extends A {
	int meth() {
		return 10;
	}

	static int sMeth() {
		return 10;
	}
}

class A {
	int meth() {
		return 1;
	}

	static int sMeth() {
		return 1;
	}
}

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		C c = new C();// 객체생성은 C, 자식 생성 시 부모도 생성된다. 부모는 자식을 담을 수 있다. >> A,B가 부모임
		B b = (B) c;// c
		A a = (A) c;// c

		// C -> B -> A, C -> A -> B 둘 다 가능함

		if (a instanceof A) {
			System.out.println("a는 A의 인스턴스 이다.");
		}
		if (a instanceof B) {
			System.out.println("a는 B의 인스턴스 이다.");
		}
		if (a instanceof C) {
			System.out.println("a는 C의 인스턴스 이다.");
		}

		System.out.println(
				a.meth() + " " + b.meth() + " " + c.meth() + " " + a.sMeth() + " " + b.sMeth() + " " + c.sMeth());

	}

}
