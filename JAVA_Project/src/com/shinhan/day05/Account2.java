package com.shinhan.day05;

public class Account2 {

	private String account;
	private String name;
	private int balance;

	Account2(String account, String name, int balance) {
		this.account = account;
		this.name = name;
		this.balance = balance;
		System.out.println("결과:계좌가 생성되었습니다");
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	void deposit(int ammount) {
		this.balance += ammount;
	}

	void withdraw(int ammount) {
		if (ammount <= balance) {
			this.balance -= ammount;
			System.out.println("결과:출금이 성공되었습니다");
		} else {
			System.out.println("잔고 부족");
		}

	}

}
