package com.shinhan.day04;

public class Account {
	String accNo;
	int balance;
	
	Account(){
		
	}
	Account(String accNo, int balance){
		this.accNo=accNo;
		this.balance=balance;
		
		System.out.println(this.accNo+" 계좌가 개설되었습니다.");
		System.out.println(this.accNo+" 계좌의 잔고는 "+this.balance+"원 입니다.");
	}
	
	void deposit(int balance) {
		this.balance+=balance;
		System.out.println(this.accNo+"에 "+balance+"원이 입금되었습니다.");
		System.out.println(this.accNo+" 계좌의 잔고는 "+this.balance+"원 입니다.");
	}
	
	void withdraw(int balance) {
		this.balance-=balance;
		System.out.println(this.accNo+"에 "+balance+"원이 출금되었습니다.");
		System.out.println(this.accNo+" 계좌의 잔고는 "+this.balance+"원 입니다.");
	}
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}
	
	

}
