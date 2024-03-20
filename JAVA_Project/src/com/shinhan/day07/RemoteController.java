package com.shinhan.day07;

//인터페이스는 두 객체를 연결하는 역할
//정의는 있고 구현은 없다.(default메서드에서 구현 가능)(규격서)
//interface를 구현한 class를 만들어 함수를 구현한다.(

public interface RemoteController {
	// 1.상수
	int CHANNEL = 10;
	public static final int CHANNEL2 = 10;

	// 2.추상메서드(public abstract 생략 가능)
	void method1();
	public abstract void method2();
	void turnOn();
	void turnOff();

	// 3.default 메서드(구현 class가 공통적으로 가지는 기능 구현, 재정의 가능)
	default void method3() {
		System.out.println("default method...재정의 가능");
		method5();
	}

	// 4.static 메서드(interface가 가지는 기능, 구현 class에서 재정의 불가능)
	static void method4() {
		System.out.println("static method...재정의 불가능");
	}

	// 5.private 메서드(interface 내에서 모듈화 또는 재사용을 위해 사용)
	private void method5() {
		System.out.println("private method...외부접근불가, default 메서드가 호출");
	}

	// 일반메서드 불가, 생성자 불가
}
