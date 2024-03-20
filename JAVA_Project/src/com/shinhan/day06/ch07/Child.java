package com.shinhan.day06.ch07;

public class Child extends Parent {

	public int studentNo;
	
	public Child(String name, int sutdentNo) {
		//default는 부모의 default 생성자를 호출한다.
		//super();
		
		//명시적으로 부모의 생성자를 호출
		super(name);
		
		this.studentNo=studentNo;
		
	}
}
