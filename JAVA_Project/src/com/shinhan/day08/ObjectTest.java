package com.shinhan.day08;

import java.util.HashSet;

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
//		return super.equals(obj);//무조건 주소값으로 비교함

		if (obj instanceof Dice) {
			if (!(obj instanceof Dice))
				return false;

			Dice d = (Dice) obj;
			if (size == d.size)
				return true;
			return false;

		}
		return false;
	}

}

public class ObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f8();
	}

	private static void f1() {
		// TODO Auto-generated method stub
		// Objct는 모든 Object의 부모 클래스

		Object obj1 = new Object();
		Object obj2 = new Object();

		System.out.println(obj1 == obj2);// 주소비교
		System.out.println(obj1.equals(obj2));// 주소비교
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f2() {
		// TODO Auto-generated method stub
		// Objct를 상속받아 만든 String

		String obj1 = new String("자바");
		String obj2 = new String("자바");

		System.out.println(obj1 == obj2);// 주소비교
		System.out.println(obj1.equals(obj2));// 주소비교를 내용비교로 override
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f3() {
		// TODO Auto-generated method stub
		// Objct를 상속받아 만든 Integer

		Integer obj1 = new Integer(100);// Integer obj1=100; 을 쓰는 걸 더 권장한다는 뜻
		Integer obj2 = new Integer(100);

		System.out.println(obj1 == obj2);// 주소비교
		System.out.println(obj1.equals(obj2));// 주소비교를 내용비교로 override
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f4() {
		// TODO Auto-generated method stub
		// Objct를 상속받아 만든 Integer

		Dice obj1 = new Dice(100);// Integer obj1=100; 을 쓰는 걸 더 권장한다는 뜻
		Dice obj2 = new Dice(100);

		System.out.println(obj1 == obj2);// 주소비교
		System.out.println(obj1.equals(obj2));// 주소비교를 내용비교로 override
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f5() {
		// TODO Auto-generated method stub
		// Objct를 상속받아 만든 Integer

		Book obj1 = new Book("자바다", 20000, "신");// Integer obj1=100; 을 쓰는 걸 더 권장한다는 뜻
		Book obj2 = new Book("자바다", 20000, "신");

		System.out.println(obj1 == obj2);// 주소비교
		System.out.println(obj1.equals(obj2));// 주소비교를 내용비교로 override
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

	private static void f6() {
		// HashSet : 순서 X, 중복 X, Key로 사용
		HashSet datas = new HashSet();
		datas.add(100);
		datas.add("자바");
		datas.add(new Book("자바다", 20000, "신"));

		for (Object obj : datas) {
			if (obj instanceof Integer) {

			} else if (obj instanceof String) {

			} else {

			}
		}
	}

	private static void f7() {
		// HashSet : 순서 X, 중복 X, Key로 사용
		HashSet<String> datas = new HashSet<String>();// <> -> type 제한
		/// datas.add(100);
		datas.add("월");
		datas.add("토");
		datas.add("토");
		datas.add("화");
		// datas.add(new Book("자바다", 20000, "신"));

		System.out.println(datas.size());
		for (String s : datas) {
			System.out.println(s);
		}
	}

	private static void f8() {

		Book b = new Book("A", 1000, "a");
		// b.equals(null);
		b.equals("aa");
		
		// HashSet : 순서 X, 중복 X, Key로 사용
		HashSet<Book> datas = new HashSet<Book>();// <> -> type 제한
		/// datas.add(100);
		datas.add(new Book("A", 20000, "김"));
		datas.add(new Book("A", 20000, "김"));
		datas.add(new Book("A", 20000, "김"));
		datas.add(new Book("B", 20000, "나"));
		datas.add(new Book("C", 20000, "박"));
		datas.add(new Book("D", 20000, "이"));
		// datas.add(new Book("자바다", 20000, "신"));

		System.out.println(datas.size());
		for (Book s : datas) {
			System.out.println(s);
		}
	}

}
