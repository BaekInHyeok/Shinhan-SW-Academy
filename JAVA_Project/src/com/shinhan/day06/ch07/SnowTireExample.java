package com.shinhan.day06.ch07;

public class SnowTireExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnowTire snowTire = new SnowTire();

		// 자동형변환
		// 부모 - 자식
		Tire tire = snowTire;

		snowTire.run();
		snowTire.run2();
		snowTire.run3();

		// 메서드는 타입을 따른다. Override되어있으면 재정의된 메서드가 호출
		tire.run();//재정의됨
		tire.run2();
		//tire.run3(); >>불가
		
		
		
		//Tire cannot be cast to class SnowTire
		Tire tire2 = new Tire();
		SnowTire ss = (SnowTire)tire2;

	}

}
