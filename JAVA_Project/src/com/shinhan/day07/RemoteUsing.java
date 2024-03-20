package com.shinhan.day07;

public class RemoteUsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		f1();
//		f2();
//		f3();
//		f4();
		f7();
		f8();

	}

	private static void f8() {
		// TODO Auto-generated method stub
		Television a = new Television();
		RemoteController b = new Television();
		
		a.method4();
		//b.method4(); >> 불가
		
		
		
	}

	private static void f7() {
		// TODO Auto-generated method stub

		// String, Integer 클래스는 Comparable interface를 구현했음
		// Comparable interface : 추상메서드 public abstract compareTo()'
		// String class가 Comparable interface 구현
		String s1 = "A";
		String s2 = "B";

		Integer i1 = 100;
		Integer i2 = 20;

		int result = s1.compareTo(s2);// 문자 사이의 차이
		System.out.println(result);

		result = i1.compareTo(i2);// -1,0,1
		System.out.println(result);
	}

	private static void f4() {
		// TODO Auto-generated method stub
		SmartTelevision a = new SmartTelevision();
		RemoteController b = new SmartTelevision();
		Searchable c = new SmartTelevision();
		Object d = new SmartTelevision();

		f5(a);
		// f5(b); >> 상위가 하위에 들어갈 수 없음
		f6(a);// 하위이므로 상위에 접근 가능
		f6(new Audio());
	}

	private static void f6(Object smart) {
		// TODO Auto-generated method stub
		// ((SmartTelevision)smart).search("http://youtube");

		if (smart instanceof SmartTelevision ss)
			ss.search("http://youtube");
	}

	private static void f5(SmartTelevision a) {
		// TODO Auto-generated method stub

	}

	private static void f3() {
		// TODO Auto-generated method stub
		action(new Television());
		action(new Audio());
	}

	private static void action(RemoteController remote) {
		// TODO Auto-generated method stub

		// 사용할 변수, 메서드는 타입을 따른다.
		System.out.println(remote.CHANNEL);// 상수접근

		// 추상(abstract)
		remote.turnOn();
		remote.turnOff();
		remote.method1();
		remote.method2();

		// default
		remote.method3();

		// static
		RemoteController.method4();

	}

	private static void f2() {
		// TODO Auto-generated method stub
		Audio audio = new Audio();

		audio.method1();
		audio.method2();
		audio.method3();
		audio.turnOn();
		audio.turnOff();
		RemoteController.method4();

	}

	private static void f1() {
		// TODO Auto-generated method stub
		Television t1 = new Television();
		t1.method1();// 추상구현
		t1.method2();// 추상구현
		t1.method3();// 재정의된 depfautlt 메서드;
		t1.method4();// class에서 추가한 메서드

		RemoteController.method4();
		System.out.println("Remote");
		System.out.println(RemoteController.CHANNEL);
	}

}
