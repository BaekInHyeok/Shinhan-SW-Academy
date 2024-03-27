package com.shinhan.day11.collection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTest2 {

	public static void main(String[] args) {

		// f1();
		// f2();
		// f3();
		// f4();
		// f5();
		f6();
	}

	// 변경불가
	private static void f6() {
		
		/*copyof를 사용하여 만든 collection은 수정 불가*/
		String[] arr = { "자바", "디비", "웹", "프레임워크" };
		List<String> alist = Arrays.asList(arr);
		// alist.add("aaaa"); >> 불가능
		for (String data : alist) {
			System.out.println(data);
		}

		List<String> blist = List.of("자바", "디비", "웹", "프레임워크");
		// blist.add("bbbb"); >>불가능

		Set<String> aset = Set.of("자바", "디비", "웹", "프레임워크");// 중복 data는 불가
		for (String data : aset) {
			System.out.println(data);
		}

		Map<Integer, String> map = Map.of(1, "자바", 2, "디비", 3, "웹", 4, "프레임워크");
		// map.put(5, "aaa"); >> 불가능

		for (Integer key : map.keySet()) {
			System.out.println(key + "==" + map.get(key));
		}

		List<String> alist3 = new ArrayList<String>();
		alist3.add("A1");
		alist3.add("A2");
		alist3.add("A3");
		List<String> alist4 = List.copyOf(alist3);
		// alist3.add("A4"); >> 불가능

	}

	private static void f5() {
		Stack<Integer> stack = new Stack<>();
		stack.push(100);
		stack.push(300);
		stack.push(200);
		stack.push(400);
		stack.push(500);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(100);
		queue.offer(300);
		queue.offer(400);
		queue.offer(200);
		queue.offer(500);

		while (!queue.isEmpty()) {

			System.out.println(queue.poll());
		}

	}

	private static void f4() {
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("apple1", 10);
		treeMap.put("apple2", 20);
		treeMap.put("apple3", 30);
		treeMap.put("apple4", 40);
		treeMap.put("apple5", 50);

//		print(treeMap, "original");
//		print2(treeMap, "original");
//		print3(treeMap, "찾기");
//		NavigableMap<String, Integer> datas = treeMap.descendingMap();
//		for (String key : datas.keySet()) {
//			System.out.println(key + ">>" + treeMap.get(key));
//		}
		print2(treeMap.descendingMap(), "descendingMap");
	}

	private static void print3(TreeMap<String, Integer> treeMap, String title) {
		System.out.println("====" + title + "====");
		System.out.println(treeMap.firstKey());// 첫 번째 키
		System.out.println(treeMap.firstEntry());// 첫 번째 엔트리

	}

	private static void print2(NavigableMap<String, Integer> treeMap, String title) {
		System.out.println("====" + title + "====");
		for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + ">>" + entry.getValue());
		}

	}

	private static void print(TreeMap<String, Integer> treeMap, String title) {
		System.out.println("====" + title + "====");
		for (String key : treeMap.keySet()) {
			System.out.println(key + ">>" + treeMap.get(key));
		}

	}

	private static void f3() {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);

		print(scores);
		print2(scores);

		// Descending Sort
//		NavigableSet<Integer> descScoreSet = scores.descendingSet();
//		for (Integer data : descScoreSet) {
//			System.out.println(data);
//		}
		print3(scores.descendingSet(), "Descending");

		print3(scores.tailSet(80, true), "tailSet");// >=80
		print3(scores.subSet(80, true, 90, false), "tailSet");// <=90 && >=80

	}

	private static void print2(TreeSet<Integer> scores) {
		// TODO Auto-generated method stub
		System.out.println("가장 낮은 점수" + scores.first());
		System.out.println("가장 높은 점수" + scores.last());
		System.out.println("95보다 낮은 점수" + scores.lower(95));
		System.out.println("95보다 높은 점수" + scores.higher(95));
		System.out.println("95, 없으면 낮은 애 점수" + scores.floor(95));
		System.out.println("96, 없으면 높은 애 점수" + scores.floor(96));

	}

	private static void print(TreeSet<Integer> scores) {
		System.out.println("---기본 출력은 Ascending Sort---");
		for (Integer data : scores) {
			System.out.println(data);
		}
	}

	private static void print3(Set<Integer> scores, String title) {
		System.out.println("----" + title + "----");
		for (Integer data : scores) {
			System.out.println(data);
		}
	}

	private static void f2() {
		Properties pro = new Properties();

		try {
			pro.load(CollectionTest2.class.getResourceAsStream("oracleDB.properties"));// 읽어오기

			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			String myname = pro.getProperty("myname");
			String myname2 = pro.getProperty("myname2", "AAA");// AAA:값을 읽어오지 못할 때의 default값

			System.out.println(driver);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			System.out.println(myname);
			System.out.println(myname2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void f1() {

		// Map(키, 값 쌍) 키중복 X, hashcode(),equals()
		// : HashMap, TreeMap(순서있음,Comparable 구현),
		// HashTable(동기화 가능)
		Map<String, Integer> map = new Hashtable<>();// 멀티쓰레드 환경에서 사용
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					System.out.println(getName() + "!!!!----");
					map.put(String.valueOf(i), i);// {"1":1,"2":2....}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				for (int i = 101; i <= 2000; i++) {
					System.out.println(getName() + "@@@@----");

					map.put(String.valueOf(i), i);// {"1":1,"2":2....}
				}
			}
		};

		t1.start();
		t2.start();

		try {
			t1.join();// t1이 종료될 때까지 대기
			t2.join();// t2가 종료될 때까지 대기
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("entry 개수:" + map.size());
	}
}
