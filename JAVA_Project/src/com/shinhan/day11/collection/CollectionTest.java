package com.shinhan.day11.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import com.shinhan.day10.thread.Account;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode//중복체크
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Car implements Comparable<Car> {
	String model;
	int price;

	@Override
	public int compareTo(Car obj) {
		// price asc, model desc
		if (price - obj.price == 0) {
			return obj.model.compareTo(model);
		}
		return price - obj.price;

	}
}

public class CollectionTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
		// f9();
		f10();
	}

	private static void f10() {
		// 배열(연속공간, 가변 불가)
		// Collection: List(순서있고, 중복있음), Set(순서 없고 중복 없음), Map(키와 값의 쌍 entry)

		System.out.println("===List===");
		List<Car> alist = new LinkedList<Car>();
		alist.add(new Car("A", 1000));// 뒤에 추가
		alist.add(0, new Car("B", 500));// 원하는 위치에 삽입

		for (Car car : alist) {
			System.out.println(car);
		}

		System.out.println("===Set===");
		Set<Car> blist = new HashSet<>();
		blist.add(new Car("A", 1000));// 뒤에 추가
		blist.add(new Car("B", 00));
		blist.add(new Car("C", 2000));
		blist.add(new Car("A", 1000));

		for (Car car : blist) {
			System.out.println(car);
		}

		System.out.println("====HashMap====");
		Map<Car, Integer> data = new HashMap<>();
		data.put(new Car("A", 1000), 1);
		data.put(new Car("A", 1000), 2);// !!!!
		data.put(new Car("B", 1000), 3);
		data.put(new Car("C", 1000), 4);
		data.put(new Car("B", 1000), 5);// !!!!

		for (Car key : data.keySet()) {
			System.out.println(key + " >> " + data.get(key));
		}
		
		System.out.println("====TreeMap====");
		Map<Car, Integer> data2 = new TreeMap<>();
		data.put(new Car("A", 1000), 1);
		data.put(new Car("A", 1000), 2);// !!!!
		data.put(new Car("B", 3000), 3);
		data.put(new Car("C", 1000), 4);
		data.put(new Car("B", 5000), 5);// !!!!
		
		System.out.println(data2.containsKey(new Car("C",1000)));
		System.out.println(data2.containsKey(new Car("C2",1000)));
		System.out.println(data2.containsValue(4));
		System.out.println(data2.containsValue(44));
		
		for (Car key : data.keySet()) {
			System.out.println(key + " >> " + data.get(key));
		}
		
		

	}

	private static void f9() {
		// Map : key와 value의 쌍이다(Map.Entry), key는 Set으로 만듦(중복 불가)
		// 구현 class: HashMap, HashTable, TreeMap, Properties
		Map<String, Integer> data = new HashMap<>();
		data.put("A", 99);
		data.put("B", 100);
		data.put("C", 77);
		data.put("B", 99);
		data.put("A", 88);

		// 이미 존재하는 키가 있으면 덮어쓰기 한다.
		System.out.println(data.size());
		System.out.println(data.get("A"));
		System.out.println(data.get("B"));

		// 1.키의 이름을 모른다면
		System.out.println("-------1,keySet()---------");
		for (String key : data.keySet()) {
			System.out.println(key + "==>" + data.get(key));
		}
		// 2.EntrySet
		System.out.println("-------2.entrySet()---------");
		Set<Map.Entry<String, Integer>> entrySet = data.entrySet();
		for (Map.Entry<String, Integer> entry : data.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}

		// 3.iterator
		System.out.println("-------3.iterator---------");
		Iterator<Entry<String, Integer>> it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}

	}

	private static void f8() {
		// Set : 순서 X, 중복 불가 interface=>구현 class : HashSet>>순서 X, TreeSet>>순서 O
		Set<Car> data = new TreeSet<>();
		data.add(new Car("A", 1000));
		data.add(new Car("B", 3000));
		data.add(new Car("C", 4000));
		data.add(new Car("B", 2000));// add안됨
		data.add(new Car("C", 5000));// add안됨

		System.out.println("개수:" + data.size());

		System.out.println("일반 for문 이용");
		// -----일반 for문----- : 불가능
//		for (int i = 0; i < data.size(); i++) {
//			System.out.println(data.get(i));
//		}

		// -----확장 for문-----
		System.out.println("확장 for문 이용");
		for (Car s : data) {
			System.out.println(s);
		}

		System.out.println("반복자 이용");
		Iterator<Car> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	private static void f7() {
		// Set : 순서 X, 중복 불가 interface=>구현 class : HashSet>>순서 X, TreeSet>>순서 O
		TreeSet<String> data = new TreeSet<>();
		data.add("월");
		data.add("화");
		data.add("토");
		data.add("토");// add안됨
		data.add("월");// add안됨

		System.out.println("개수:" + data.size());

		System.out.println("일반 for문 이용");
		// -----일반 for문----- : 불가능
//		for (int i = 0; i < data.size(); i++) {
//			System.out.println(data.get(i));
//		}

		// -----확장 for문-----
		System.out.println("확장 for문 이용");
		for (String s : data) {
			System.out.println(s);
		}

		System.out.println("반복자 이용");
		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	private static void f6() {
		// Set : 순서 X, 중복 불가 interface=>구현 class :
		HashSet<String> data = new HashSet<>();
		data.add("월");
		data.add("화");
		data.add("토");
		data.add("토");// add안됨
		data.add("월");// add안됨

		System.out.println("개수:" + data.size());

		System.out.println("일반 for문 이용");
		// -----일반 for문----- : 불가능
//		for (int i = 0; i < data.size(); i++) {
//			System.out.println(data.get(i));
//		}

		// -----확장 for문-----
		System.out.println("확장 for문 이용");
		for (String s : data) {
			System.out.println(s);
		}

		System.out.println("반복자 이용");
		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	private static void f5() {
		// ArrayList: 연속공간 필요, 공간 부족 시 자동으로 증가, 중간 삽입/삭제 시 비효율적(당기거나 밀거나 이동 있음)
		// LinkedList : 연속공간 불필요, 전요소나 후요소의 주소 기억(공간 차지), 중간 삽입/삭제 시 효율적
		// Vector : Multi Thread에서 동기 처리 가능

		// 선언부 왼쪽에 List<E> list를 한 후 오른쪽에서 자유롭게 설정하면 된다.
		List<String> data1 = new ArrayList<>();
		List<String> data2 = new LinkedList<>();
		List<String> data3 = new Vector<>();

		insertData(data1);
		insertData(data2);
		insertData(data3);

		displayData(data1, "ArrayList");
		displayData(data2, "LinkedList");
		displayData(data3, "Vector");
	}

	private static void displayData(List<String> data, String title) {
		// TODO Auto-generated method stub

		System.out.println(title);

		// -----일반 for문-----
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}

		// -----확장 for문-----
		for (String s : data) {
			System.out.println(s);
		}
	}

	private static void insertData(List<String> data) {
		data.add("월");
		data.add("화");
		data.add("수");
		data.add("목");
	}

	private static void f4() {
		// TODO Auto-generated method stub
		Vector<String> data = new Vector<>();
		data.add("문자1");// 끝에 추가
		data.add("문자2"); // 끝에 추가
		data.add("문자3");// 끝에 추가

		// -----일반 for문-----
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}

		// -----확장 for문-----
		for (String s : data) {
			System.out.println(s);
		}
	}

	private static void f3() {
		// TODO Auto-generated method stub
		// List:순서 있고 중복 가능 interface==>구현 class:ArrayList, LinkedList, Vector
		LinkedList<String> data = new LinkedList<>();
		data.add("문자1");// 끝에 추가
		data.add("문자2"); // 끝에 추가
		data.add("문자3");// 끝에 추가

		// -----일반 for문-----
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}

		// -----확장 for문-----
		for (String s : data) {
			System.out.println(s);
		}

	}

	private static void f2() {
		// TODO Auto-generated method stub
		// List:순서 있고 중복 가능 interface==>구현 class:ArrayList, LinkedList, Vector
		ArrayList<String> data = new ArrayList<>();
		data.add("문자1");// 끝에 추가
		data.add("문자2"); // 끝에 추가
		data.add("문자3");// 끝에 추가

		// -----일반 for문-----
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}

		// -----확장 for문-----
		for (String s : data) {
			System.out.println(s);
		}

	}

	private static void f1() {
		// TODO Auto-generated method stub
		// List:순서 있고 중복 가능 interface==>구현 class:ArrayList, LinkedList, Vector
		ArrayList data = new ArrayList();
		data.add("문자");// 끝에 추가
		data.add(100);// 끝에 추가
		data.add(new Account());// 끝에 추가

		String a = (String) data.get(0);
		int b = (Integer) data.get(1);
		Account acc = (Account) data.get(2);
	}

}
