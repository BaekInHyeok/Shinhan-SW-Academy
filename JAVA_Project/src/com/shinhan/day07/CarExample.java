package com.shinhan.day07;

class Car{
	class Tire{}
	static class Engine{}
	
	void method() {
		class Chair{
			void f1() {}
		}
		Chair cc = new Chair();
		cc.f1();
	}
}

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car myCar = new Car();
		//instance
		Car.Tire tire = myCar.new Tire();
		//static
		Car.Engine engine = new Car.Engine(); 
		
		//local class는 method 내에서만 접근. 외부접근 불가
		myCar.method();
	}

}
