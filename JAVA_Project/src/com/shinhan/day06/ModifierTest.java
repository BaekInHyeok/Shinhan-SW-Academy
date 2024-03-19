package com.shinhan.day06;

import com.shinhan.day05.Computer;

public class ModifierTest extends Computer {

	void print() {
		System.out.println(price);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
	}

	private static void method1() {
		// TODO Auto-generated method stub
		Computer com1;
		com1=new Computer();
		//com1.model="AA";
		com1.setModel("AA");
	}

}
