package com.shinhan.day06;

public class CreditLineAccount extends Account {

	int creditLine;// 마이너스 한도

	public CreditLineAccount(String accountNum, String ownerName, int balance, int creditLine) {
		super(accountNum, ownerName, balance);
		this.creditLine = creditLine;
	}

	// 인출하다 메서든느 부모의 로직을 사용하지만 재정의 필요(마이너스 한도 요소를 추가)
	// Override(재정의,덮어쓰기) 수행
	// 이름, 매개변수 타입&개수, 리턴이 모두 값아야 한다.
	// Modifier는 같거나 넓어야 함
	@Override
	public int withdraw(int amount) {
		if (getBalance() + creditLine < amount) {
			System.out.println("잔고 부족, 출금 불가");
			return 0;
		}

		setBalance(getBalance() - amount);
		return amount;
	}
	
	
	
	@Override
	public String toString() {
		return "CreditLineAccount"+super.toString()+"[creditLine=" + creditLine + "]";
	}

	Book f1() {
		return new Book("AA",100);
	}
}

class Book{
	String title;
	int price;
	
	Book(String title, int price){
		this.title=title;
		this.price=price;
	}
}