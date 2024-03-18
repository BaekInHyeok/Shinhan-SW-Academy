package com.shinhan.day05;

public class Account {

	private int balance;
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		
		//방법1
		if(balance<MIN_BALANCE||balance>MAX_BALANCE)
			return;
		this.balance = balance;
		
		//방법2
		if(balance>=MIN_BALANCE&&balance<=MAX_BALANCE) {
			this.balance=balance;
		}
	}
	
	
	
}
