package com.shinhan.day04;

//class: 틀(설계도), 특정 행위 정하기
//object:각각의 다른 object와 구별되는 독립된 특징 부여
public class Korean {

	// 1.field
	String nation="대한민국";
	String name;
	String ssn;

	// 2.constructor:목적이 초기화이다.
	Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	//OverLoading
	Korean(String name) {
		this.name = name;
	}
	//3.메서드(기능) : 리턴값 필수, 없으면 void
	void print(){
		System.out.println(nation);
		System.out.println(name);
		System.out.println(ssn);
	}

	@Override
	public String toString() {
		return "Korean [nation=" + nation + ", name=" + name + ", ssn=" + ssn + "]";
	}
	
	
}
