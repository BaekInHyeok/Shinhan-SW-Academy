package com.shinhan.day11;

public class Synchroniazedxample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calculator = new Calculator();
		
		User1thread user1thread = new User1thread();
		user1thread.setCalculator(calculator);
		user1thread.start();
		
		User2thread user2thread = new User2thread();
		user2thread.setCalculator(calculator);
		user2thread.start();
	}

}
