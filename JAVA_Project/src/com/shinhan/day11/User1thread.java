package com.shinhan.day11;

public class User1thread extends Thread{

	private Calculator calculator;
	
	public User1thread() {
		setName("User1Thread");
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator=calculator;
	}

	@Override
	public void run() {
		calculator.setMemory1(100);
	}
	
	
	
}
