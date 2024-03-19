package com.shinhan.day06;

public class BonusPointAccount extends Account {
	
	int bonusPoint;

	public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint=bonusPoint;
		
	}

	@Override
	public void deposit(int amount) {
		// TODO Auto-generated method stub
		super.deposit(amount);
		bonusPoint+=amount*0.001;//복합대입연산자는 자동형변환이 이루어짐
	}

	@Override
	public String toString() {
		return "BonusPointAccount"+super.toString()+"[bonusPoint=" + bonusPoint + "]";
	}
	
	
	

	

}
