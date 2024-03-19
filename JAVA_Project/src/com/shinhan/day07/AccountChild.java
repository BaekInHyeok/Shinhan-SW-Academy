package com.shinhan.day07;

import com.shinhan.day06.Account;

public class AccountChild extends Account {

	public AccountChild() {
		super("", "", 0);
	}
	
	void test() {
		System.out.println(title);
		print();
	}

}

//상속받지 않은 경우:protected는 같은 패키지에서만 접근 가능
class Account2{
	void test() {
		Account acc = new Account("","",0);
		
		//System.out.println(acc.title);
		//acc.print();
	}
}
