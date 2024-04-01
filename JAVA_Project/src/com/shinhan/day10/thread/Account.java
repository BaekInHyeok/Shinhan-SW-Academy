package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Account {

	String accuntNo;
	String ownerName;
	int balance = 0;

	public void deposit(int amount) {
		balance += amount;
	}

	public int withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			return amount;

		} else {
			System.out.println("잔고 부족");
			return 0;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accuntNo=").append(accuntNo).append(", ownerName=").append(ownerName)
				.append(", balance=").append(balance).append("]");
		return builder.toString();
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
}
