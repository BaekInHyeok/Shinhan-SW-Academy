package com.shinhan.day09.generic;

import java.util.ArrayList;

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
		f2();

	}

	private static void f2() {
		// TODO Auto-generated method stub

		// List:순서가 있고, 중복이 가능함
		ArrayList<String> alist1 = new ArrayList<>();
		alist1.add("월");
		alist1.add("월");
		alist1.add("화");
		alist1.add("월");
		alist1.add("수");
		
		for(String s:alist1) {
			System.out.println(s);
		}
	}

	private static void f1() {
		// TODO Auto-generated method stub
		Box<String, Integer> box1 = new Box<>("컴퓨터1", 100);
		System.out.println(box1);

		Box<Integer, String> box2 = new Box<>(123, "컴퓨터2");
		System.out.println(box2);
	}

}
