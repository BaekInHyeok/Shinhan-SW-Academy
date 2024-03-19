package com.shinhan.day06;

public class CheckingAccount extends Account {

	// 상속 후 자식클래스에서 필드 추가
	String cardNum;

	// 생성자 정의...부모의 생성자를 명시적으로 호출
	// 부모의 field가 private인 경우
	// 자식값 setting을 위해 1)생상자 이용 2)setter 이용 >> 여기서는 1번을 사용한다.
	public CheckingAccount(String accountNum, String ownerName, int balance, String cardNum) {
		// 생성자를 명시적으로 호출하기
		super(accountNum, ownerName, balance);
		this.cardNum = cardNum;

	}

	// 1.상속 후 기능 추가...카드 번호가 같으면 요청한 만큼 인출
	int pay(String cardNum, int amount) {

		if (cardNum.equals(this.cardNum)) {
			return withdraw(amount);//withdraw에서 잔고와 인출액 비교 가능

		} else {
			System.out.println("카드번호 불일치");
			return 0;
		}
	}

	@Override
	public String toString() {
		return "CheckingAccount"+super.toString()+ "[cardNum=" + cardNum + "]";
	}
	
	

}
