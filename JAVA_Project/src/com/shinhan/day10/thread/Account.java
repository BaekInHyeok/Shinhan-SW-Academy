package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Account {

	String accuntNo;
	String ownerName;
	int balance = 0;

	void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			return amount;

		} else {
			System.out.println("잔고 부족");
			return 0;
		}
	}
}
