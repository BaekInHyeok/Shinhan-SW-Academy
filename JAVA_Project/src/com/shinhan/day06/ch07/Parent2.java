package com.shinhan.day06.ch07;

public class Parent2 {

	public String nation;

	public Parent2() {
		this("대한민국");
		System.out.println("2.Parent() call");
	}

	public Parent2(String nation) {
		// TODO Auto-generated constructor stub

		// super()...Object가 생성됨
		this.nation = nation;
		System.out.println("1.Parent(String nation) call");
	}
}
