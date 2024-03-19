package com.shinhan.day06;

class Parent {
	// 자동으로 부모의 default 생성자 호출ㄴ
	String title = "부모에서 정의함";
	private String title2 = "부모에서 정의함";// 자식클래스에서도 접근 불가

	Parent() {
		System.out.println("부모의 default 생성자");
	}

	void show() {
		System.out.println("부모에셔 정의한 메소드");
	}

	private void print() {
		System.out.println("부모에서 정의한 print 메소드");
	}
}

class Child extends Parent {
	// 자동으로 부모의 default 생성자 호출
	int title = 200;
	int score = 100;

	Child() {
		System.out.println("자식의 default 생성자");
	}

	void show2() {
		System.out.println("자식에셔 정의한 메소드");
		System.out.println("자식에서 출력함");
		System.out.println("부모 private로 정의됨.");
	}

}

public class InheritenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		f1();
	}

	private static void f1() {
		// TODO Auto-generated method stub
		Child ch1 = new Child();

		System.out.println(ch1.score);
		ch1.show();
		ch1.show2();

	}

}
