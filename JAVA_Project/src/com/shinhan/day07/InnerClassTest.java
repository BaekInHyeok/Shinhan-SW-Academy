package com.shinhan.day07;

//외부 class
class OuterClass {

	// instance 변수
	int a = 100;
	int score = 99;

	// class 변수
	static int b = 200;

	// instance method
	void method1() {
	}

	// static method
	static void mehtod2() {
	}

	// instance inner class
	class InnerClass {
		// instance 변수
		int a2 = 100;
		String score = "A학점";

		// class 변수
		static int b2 = 200;

		// instance method
		void method3() {
			System.out.println("inner class의 method3()" + (a + b + a2 + b2));
			System.out.println(score);// String com.shinhan.day07.OuterClass.InnerClass.score
			System.out.println(OuterClass.this.score);// int com.shinhan.day07.OuterClass.score
		}

		// static method...instance 사용 불가
		static void mehtod4() {
			System.out.println("inner class의 method4()" + (b + b2));// a,a2는 static 변수가 아니므로 사용 불가
		}
	}

	static class InnerClass2 {// 시작부터 메모리에 올라옴
		// instance 변수
		int a2 = 100;
		String score = "A학점";

		// class 변수
		static int b2 = 200;

		// instance method
		void method3() {
			System.out.println("inner class의 method3()" + (b + a2 + b2));// a 사용 불가
			System.out.println(score);// String com.shinhan.day07.OuterClass.InnerClass.score
			// System.out.println(OuterClass.this.score); >> 불가
		}

		// static method...instance 사용 불가
		static void mehtod4() {
			System.out.println("inner class의 method4()" + (b + b2));// a,a2는 static 변수가 아니므로 사용 불가
		}
	}

	void call() {
		// 지역변수 : 내부 class에서 접근하면 무조건 변경 불가함(final)
		int price = 1000;
		int price2 = 2000;

		// method call() 내에 있는 클래스. call() 내에서만 접근 가능
		class LocalClass {
			// 1.field
			int price2 = 2000;
			static int price3 = 3000;

			// 2.method
			void show() {
				System.out.println("LocalClass instance method");
				// price=99; >> 지역변수 앞에 final이 생략되어 있다.
				System.out.println("지역변수를 LocalClass에서 사용 >> price :" + price);
			}

			static void show2() {
				System.out.println("LocalClass class method");
			}
		}
		price2 = 3000;//사용하지 않았으면 변경 가능함
		
		// static
		System.out.println(LocalClass.price3);
		LocalClass.show2();

		// instance
		LocalClass local = new LocalClass();
		System.out.println(local.price2);
		local.show();
	}
}

public class InnerClassTest {

	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		outer.call();
	}

	public static void f2(String[] args) {
		System.out.println(OuterClass.InnerClass2.b2);// b2에 접근 가능
		OuterClass.InnerClass2.mehtod4();// method4()에 접근 가능

		OuterClass.InnerClass2 inner = new OuterClass.InnerClass2();
		System.out.println(inner.a2);
		System.out.println(inner.score);
		inner.method3();

	}

	public static void f1(String[] args) {
		// static 사용
		System.out.println(OuterClass.InnerClass.b2);

		// instance 사용
		OuterClass outer = new OuterClass();// 외부 클래스 생성
		OuterClass.InnerClass inner = outer.new InnerClass();// 내부 클래스 생성
		OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();// 내부 클래스 생성
		System.out.println(inner.a2);
		System.out.println(inner.score);
		inner.method3();
	}

}
