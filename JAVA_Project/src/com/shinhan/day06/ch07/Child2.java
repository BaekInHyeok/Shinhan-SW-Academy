package com.shinhan.day06.ch07;

public class Child2 extends Parent2 {

	public String name;

	public Child2() {
		// 1.default super()
		this("홍길동");// 자신의 class의 다른 생성자 호출, 첫줄에서만 가능함(중간에 호출 불가)
		System.out.println("4.Child() call");
	}

	public Child2(String name) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		System.out.println("3.Child(String name) call");
	}

}
