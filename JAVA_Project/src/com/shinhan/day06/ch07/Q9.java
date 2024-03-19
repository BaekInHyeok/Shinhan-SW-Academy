package com.shinhan.day06.ch07;

class A {
}

class B extends A {
}

class C extends A {
}

class D extends B {
}

class E extends B {
}

class F extends C {
}


public class Q9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		B b1 = new B();
		method(new B());
		
//		B b2 = (B) new A();
//		method((B) new A());
		
		B b3 = new D();
		method(new D());
		
		B b4 = new E();
		method(new E());
	}

	static void method(B b) {
		
	}
}
