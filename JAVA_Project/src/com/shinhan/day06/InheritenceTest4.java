package com.shinhan.day06;

//구현 : {}
//추상 : 정의는 있지만 구현은 없다({} 부분이 없다). 구현은 자식클래스에서 한다(재정의)

//abstract method : 정의만 하고 구현은 하지 않음
//abstract class : class 안에 추상메서드가 하나라도 존재하는 경우 >> 객체 생성 불가

//추상 메서드를 상속받은 자식은 반드시 추상메서드를 구현해야 할 의무가 있다.
abstract class Vehicle {
	// 추상 메서드
	abstract void run();

	void print() {
		System.out.println("일반메서드");
	}
}

abstract class Truck extends Vehicle {
	abstract void run();
	void print2() {
		System.out.println("구현메서드");
	}

}

class Truck2 extends Truck{
	void run() {
		System.out.println("추상메서드는 반드시 자식이 구현해야 할 의무가 있음");
	}
}

class Bus extends Vehicle {
	void run() {
		System.out.println("(Bus)자식 override.. run 메서드");
	}
}

class Taxi extends Vehicle {
	void run() {
		System.out.println("(Taxi)자식 override.. run 메서드");
	}
}

class Driver {
	void drive(Vehicle vv) {
		vv.run();
	}
}

class Car {
	Tire tire;

	Car(Tire tire) {
		this.tire = tire;
	}

	void go() {
		tire.roll();
	}
}

class Tire {
	void roll() {
		System.out.println("부모가 정의 roll()");
	}
}

class HankookTire extends Tire {
	void roll() {
		System.out.println("HankookTire 정의 roll()");
	}
}

class KumhoTire extends Tire {
	void roll() {
		System.out.println("KumhoTire 정의 roll()");
	}
}

public class InheritenceTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------------매개변수의 다형성------------");
		Driver driver = new Driver();
		driver.drive(new Bus());
		driver.drive(new Taxi());
//		driver.drive(new Vechicle());>>불가능

		System.out.println("------------필드의 다형성------------");
		Car car1 = new Car(new HankookTire());
		Car car2 = new Car(new KumhoTire());
		car1.go();
		car2.go();

	}

}
