package com.shinhan.day10.ch13;

public class ContainerExample {

	public static void main(String[] args) {
		Container2<String, String> container1 = new Container2<String, String>();
		container1.set("홍길동", "도적");
		String name1 = container1.getKey();
		String job = container1.getValue();
		System.out.println(name1);
		System.out.println(job);
		Container2<String, Integer> container2 = new Container2<String, Integer>();
		container2.set("홍길동", 35);
		String name2 = container2.getKey();
		int age=container2.getValue();
		System.out.println(name2);
		System.out.println(age);
	}

	public static void Q2(String[] args) {
		// TODO Auto-generated method stub

		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		System.out.println(str);
		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
		System.out.println(value);
	}

}
