package com.shinhan.day11;

public class User2thread extends Thread{

	private Calculator calculator;
	
	public User2thread() {
		setName("User2thread");
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator=calculator;
	}

	@Override
	public void run() {
		calculator.setMemory2(50);
	}
	
	
	
}
