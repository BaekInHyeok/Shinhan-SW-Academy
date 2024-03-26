package com.shinhan.day10;

public class CoffeeAgency implements Rentable<CoffeeMachine> {

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CoffeeMachine rent() {
		// TODO Auto-generated method stub
		return new CoffeeMachine();
	}
	
	void method1(CoffeeMachine coffee) {
		coffee.method1();
	}

}
