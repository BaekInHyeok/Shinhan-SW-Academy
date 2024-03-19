package com.shinhan.day06.ch07;

public class Parent2 {

	public String nation;
	
	public Parent2() {
		this("대한민국");
		System.out.println("Parent() call");
	}

	public Parent2(String nation) {
		// TODO Auto-generated constructor stub
		this.nation=nation;
		System.out.println("Parent(String nation) call");
	}
}
