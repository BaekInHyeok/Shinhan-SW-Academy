package com.shinhan.day06;

//extends Object는 생략되어 있음
//JavaBeans 기술 규격서 : field는 접근 제한자를 private으로 설정, 외부에서는 getter/setter로 접근
public class Account extends Object{
	
	//final:최종을 위미
	//final class : 상속 불가
	//final field : 1회만 할당(선언시, 수정 불가)
	//final static field : 상수(1회 할당, 선언시 또는 static block에서 할당
	//final method : 재정의 불가
	private final String name="우리은행";//선언시 할당
	private final String name2;
	private static final String NAME3 = "우리은행";
	private static final String NAME4;
	
	static {
		NAME4="우리은행";
	}
	
	final void method1() {
		System.out.println("자식이 재정의할 수 없음");
	}
	
	
	private String accountNo;
	private String ownerName;
	private int balance;

	//생성자:정의하지 않으면 컴파일러가 default 생서자을 만든다. 정의하면 만들어주지 않는다.
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		name2="우리은행";//선언시 할당, 이후 수정 불가
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) {
		if (balance < amount) {
			System.out.println("잔고 부족, 출금 불가");
			return 0;
		}
		
		balance -= amount;
		return amount;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
	//필드 추가
	protected String title="protected field 연습";
	//메서드 추가
	protected void print() {
		System.out.println("protected 접근제한자 연습");
	}
	

}
