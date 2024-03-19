package com.shinhan.day06;

//OOP 특징 :
//캡슐화(정보은닉, private)
//상속(기존 class를 물려받음, 수정 가능, 추가 가능)
//다형성(사용은 같지만 결과는 다르다)
public class InheritenceTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// method1();
//		method2();
//		method3();
		mehtod4();
//		method6();
		// method7();

	}

	static void method5(Account acc) {
		// TODO Auto-generated method stub
		System.out.println("----------------------------");
		System.out.println(acc);
		System.out.println("계좌번호:" + acc.getAccountNo());
		System.out.println("예금주:" + acc.getOwnerName());
		System.out.println("잔고:" + acc.getBalance());

		System.out.println(acc instanceof CheckingAccount);

		if (acc instanceof CheckingAccount) {

			// 부모 = 자식
			// 자식 = (자식)부모
			// 형제로는 변경 불가
			CheckingAccount acc2 = (CheckingAccount) acc;
			System.out.println("카드번호:" + acc2.cardNum);
			acc2.pay("6677", 1000);
		}

		if (acc instanceof CreditLineAccount acc2) {
			System.out.println("마이너스 한도:" + acc2.creditLine);
			int amount = acc2.withdraw(5000);
			System.out.println("출금액:" + amount);
		}

		if (acc instanceof BonusPointAccount acc3) {
			acc3.deposit(6000);
			System.out.println("보너스 포인트:" + acc3.bonusPoint);

		}

	}

	private static void method7() {
		// TODO Auto-generated method stub
		// 형변환
		// 3. 객체에서 자동형변환 : 부모의 타입방 = 자식의 타입값
		Account acc = new CheckingAccount("113", "양", 2000, "6677");

		// 4. 객체에서 강제형변환 : 자식의 타입방 = (자식의 타입, 반드시 instance의 타입)부모의 타입값
		CheckingAccount acc2 = (CheckingAccount) acc;
	}

	private static void method6() {
		// 형변환
		// 1.기본형에서 자동형변환 : 큰방 = 작은값
		long bang;
		int data = 100;
		bang = data;

		// 2.강제(명시)
		long data2 = 200;
		int bang2;

		bang2 = (int) data2;

	}

	private static void mehtod4() {
		// TODO Auto-generated method stub
		Account acc1 = new Account("112", "김", 1000);
		CheckingAccount acc2 = new CheckingAccount("113", "양", 2000, "6677");
		CreditLineAccount acc3 = new CreditLineAccount("114", "박", 3000, 2000);
		BonusPointAccount acc4 = new BonusPointAccount("115", "정", 4000, 4);

		method5(acc1);
		method5(acc2);
		method5(acc3);
		method5(acc4);

//		System.out.println(acc1);
//		System.out.println(acc2);
//		System.out.println(acc3);
//		System.out.println(acc4);
	}

	private static void method3() {
		// TODO Auto-generated method stub
		BonusPointAccount acc3 = new BonusPointAccount("111-444", "이하나", 1000, 1);
		acc3.deposit(5000);
		System.out.println(acc3.getBalance());
		System.out.println(acc3.bonusPoint);
	}

	private static void method2() {
		// TODO Auto-generated method stub
		CreditLineAccount acc2 = new CreditLineAccount("111-333", "강자바", 2000, 1000);

		acc2.deposit(2000);
		int amount = acc2.withdraw(5000);
		System.out.println("출금액:" + amount);
	}

	private static void method1() {
		// TODO Auto-generated method stub
		CheckingAccount acc1 = new CheckingAccount("111-222", "홍길동", 1000, "7788");
		acc1.deposit(2000);
		int amount = acc1.withdraw(1200);
		System.out.println("출금액:" + amount);
		System.out.println("잔고:" + acc1.getBalance());
		amount = acc1.pay("7799", 800);
		System.out.println("카드인출:" + amount);
	}

}
