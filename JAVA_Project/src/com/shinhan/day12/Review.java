package com.shinhan.day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/*Collection*/
//List : add 순서 있음. index 가능, 중복 가능 
//		 >> ArrayList(중간 삽입/삭제가 비효율적)
//		 >> LinkedList(다음 데이터, 이전 데이터의 주소를 가짐, 공간 차지가 큼 but 중간 삽입 삭제 효율적)
//		 >> Vector(동기화 지원, 멀티쓰레드 환경에서 안정적)
//Set : 순서없음. 중복 불가
//		 >> HashSet(hashcode(), equals())
//		 >> TreeSet(add시 sort.. compareTo)
//Map : 키와 값의 쌍(entry), 키는 set.
//		 >> HashMap,
//		 >> Hashtable,TreeMap, properties

public class Review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
	}

	private static void f6() {
		// Map<Student, Product> map = new HashMap<>();
		// Map<Student, Product> map = new TreeMap<>();//>>sort가 되어서 나옴
		Map<Student, Product> map = new Hashtable<>();
		map.put(new Student("A", 100), new Product(1, "노트북1", "삼성", 200));
		map.put(new Student("A", 100), new Product(2, "노트북2", "LG", 200));
		map.put(new Student("B", 100), new Product(3, "노트북3", "애플", 200));
		map.put(new Student("C", 100), new Product(4, "노트북4", "레노버", 200));
		map.put(new Student("A", 100), new Product(5, "노트북5", "삼성", 200));

		print(map, "key가 Student");
	}

	// 메서드이름, 매배개변수 개수와 타입이 같으면 오버로딩이 아님
	private static void print(Map<Student, Product> map, String title) {
		System.out.println("======" + title + "========");
		for (Student key : map.keySet()) {
			System.out.println(key + ">>" + map.keySet());
		}

		System.out.println("======entrySet=======");
		for (Entry<Student, Product> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ">>" + entry.getValue());
		}
	}

	private static void f5() {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 100);
		map.put("A", 200);// 같은 키 -> 덮어쓰기
		map.put("B", 100);
		map.put("C", 100);
		map.put("D", 100);

		print(map.keySet());
		print(map);
	}

	private static void print(Map<String, Integer> map) {
		System.out.println("======keySet=======");
		for (String key : map.keySet()) {
			System.out.println(key + ">>" + map.keySet());
		}

		System.out.println("======entrySet=======");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ">>" + entry.getValue());
		}
	}

	private static void f4() {
		Set<Student> data = new TreeSet<>();
		data.add(new Student("A", 70));
		data.add(new Student("A", 70));// X
		data.add(new Student("B", 80));
		data.add(new Student("C", 60));
		data.add(new Student("B", 80));// X

		print(data);
	}

	private static void f3() {
		Set<Student> data = new HashSet<>();
		data.add(new Student("A", 70));
		data.add(new Student("A", 70));// X
		data.add(new Student("B", 80));
		data.add(new Student("C", 60));
		data.add(new Student("B", 80));// X

		print(data);
	}

	private static void print(Set<Student> data) {
		for (Student s : data) {
			System.out.println(s);
		}

	}

	private static void f2() {
		Set<String> data1 = new HashSet<>();
		data1.add("월");
		data1.add("월");
		data1.add("토");
		data1.add("토");

		print(data1);

	}

	private static void f1() {
		List<String> data1 = new ArrayList<String>();
		List<String> data2 = new LinkedList<String>();
		List<String> data3 = new Vector<String>();
		data1.add("월");
		data1.add("월");
		data1.add("토");
		data1.add("토");

		print(data1);

	}

	private static void print(Collection<String> data) {
		System.out.println("====Collection<String>====");
		for (String s : data) {
			System.out.println(s);
		}
	}

}
