package com.shinhan.day12;

import javax.print.attribute.standard.PrinterMakeAndModel;

interface Calcuable {
	double calc(double x, double y);
}

class MyCalculator implements Calcuable {
	public double calc(double x, double y) {
		return x + y;
	}
}

class Computer {
	// static 메서드
	public static double staticMethod(double x, double y) {
		return x + y;
	}

	// instance 메서드
	public double instanceMethod(double x, double y) {
		return x + y + 200;
	}
}

interface Comparable2 {
	int compare(String a, String b);
}

interface CreatTable {

	public Student create(String name, int score);
}

class Person {
	public Student getStudent(CreatTable creatable, String name, int score) {
		return creatable.create("김", score);

	}
}

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		f1();
		f2();
		f3();
		f4();
		f5();
	}

	private static void f5() {
		Person p1 = new Person();

		// 익명구현class
		CreatTable createTable = new CreatTable() {
			public Student create(String name, int score) {
				return new Student(name, score);
			}
		};

		CreatTable creatTable2 = (String name, int score) -> new Student(name, score);// 람다표현식1
		CreatTable creatTable3 = Student::new;// 람다표현식2

		Student s = p1.getStudent(creatTable3, "홍길동", 100);
	}

	private static void f4() {
		Student s = new Student("홍길동", 100);
		Student s2 = makeStudent("홍길동", 100);
	}

	private static Student makeStudent(String string, int i) {
		// TODO Auto-generated method stub
		return new Student(string, i);
	}

	private static void f3() {
		String s1 = "홍길동aaaa";
		String s2 = "김길동bb";

		Comparable2 comp = (String a, String b) -> a.length() - b.length();// 문자열 길이 비교하기
		Comparable2 comp2 = (a, b) -> a.length() - b.length();// 타입 생략 가능
		Comparable2 comp3 = String::compareToIgnoreCase;

		int result = comp.compare(s1, s2);
		System.out.println(result);
	}

	private static void f2() {

		System.out.println("1.구현class 이용");
		MyCalculator a = new MyCalculator();

		System.out.println("2.익명구현class 이용");
		Calcuable b = new Calcuable() {
			public double calc(double x, double y) {
				return x - y;
			}
		};

		Computer computer = new Computer();
		Calcuable c = computer::instanceMethod;

		System.out.println("result=" + a.calc(1, 2));
	}

	private static void f1() {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Thread 구현");
			}
		};

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread 구현....Runnable interface 구현");
			}
		});

		Thread t3 = new Thread(() -> {
			System.out.println("Thread 구현....Runnable interface 구현");
		});
	}

}
