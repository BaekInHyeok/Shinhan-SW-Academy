package com.shinhan.day10;

import com.shinhan.day02.LoopingTest;

public class GenericTest {

	public static void main(String[] args) {
		Product<Integer, Integer> p1 = makeProduct2(100, 200);

		boolean res1 = compare(10, 20);
		// boolean res2 = compare("10", "20"); >> 에러 발생

		System.out.println(res1);

	}

	private static <T extends Number> boolean compare(T i, T j) {
		double d1 = i.doubleValue();
		double d2 = j.doubleValue();

		return d1 == d2;
	}

	// A extends 부모 : 타입을 부모로 제한
	private static <A extends Number, B> Product<A, B> makeProduct2(A i, B j) {
		Product<A, B> p = new Product<A, B>(i, j);
		return null;
	}

	public static void main4(String[] args) {
		Product<String, Integer> p1 = makeProduct("A", 100);
		Product<Integer, String> p2 = makeProduct(200, "B");
		Product<String, String> p3 = makeProduct("C", "D");

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

	// 앞쪽에 제네릭 타입을 둔다
	private static <A, B> Product<A, B> makeProduct(A a, B b) {

		Product<A, B> p = new Product<>(a, b);
		return p;

	}

	public static void main3(String[] args) {
		Box<String> result1 = makeBox("구체적 타입 사용 시 결정");
		Box<Integer> result2 = makeBox(100);
		Box<Car> result3 = makeBox(new Car());

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}

	private static <T> Box<T> makeBox(T t) {
		Box<T> box = new Box<>(t);

		return box;
	}

	public static void main2(String[] args) {
		// TODO Auto-generated method stub
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
		Box<String> s = boxing("문자");
		Box<Integer> i = boxing(100);
		Box<TV> tv = boxing(new TV());
		Box<Home> home = boxing(new Home());
		Box<Product<String, Integer>> product = boxing(new Product<>("A", 100));
		Box<ChildProduct<String, Integer, String>> childProduct = boxing(new ChildProduct<>("A", 10, "B"));

		System.out.println(s.getContent());
		System.out.println(i.getContent());
		System.out.println(tv.getContent());
		System.out.println(home.getContent());
		System.out.println(product.getContent());
		System.out.println(childProduct.getContent());
	}

	// <P> : P가 제네릭, 구체적 타입 아님.
	// Box<P> : return 타입, 제네릭 타입인 box 리턴
	private static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.setContent(t);
		return box;

	}

	private static void f6() {
		// TODO Auto-generated method stub
		ChildProduct<String, Integer, Integer> p1 = new ChildProduct<>("컴퓨터", 10, 20);

		System.out.println(p1);
	}

	private static void f5() {
		// TODO Auto-generated method stub
		CoffeeAgency coffeeAgency = new CoffeeAgency();
		CoffeeMachine machine = coffeeAgency.rent();
		machine.method1();
	}

	private static void f4() {
		// TODO Auto-generated method stub

		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();

		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
	}

	private static void f3() {
		// TODO Auto-generated method stub
		Product<String, Integer> p1 = new Product<String, Integer>();
		p1.setKind("ABC");
		p1.setModel(200);
		Product<String, Integer> p2 = new Product<String, Integer>("컴퓨터", 100);
		System.out.println(p1);
		System.out.println(p2);

		Product<CoffeeMachine, String> p3 = new Product<>(new CoffeeMachine(), "DDD");
		p3.toString();

	}

	private static void f2() {
		// 제네릭의 사용 목적 : 컴파일 시에 타입 제한(잘못된 타입 입력 불가, 얻을 시 형변환 시행)
		Box<Integer> box1 = new Box<Integer>();
		box1.setContent(100);

		int a = box1.getContent();// unboxing
		System.out.println(a);

		Box<CoffeeMachine> box2 = new Box<>();
		box2.setContent(new CoffeeMachine());
		CoffeeMachine obj = (CoffeeMachine) box2.getContent();
		System.out.println(obj);

	}

	private static void f1() {
		// TODO Auto-generated method stub
		Box box1 = new Box();
		box1.setContent(100);
		box1.setContent("100");
		box1.setContent(new CoffeeMachine());

		CoffeeMachine obj = (CoffeeMachine) box1.getContent();
		System.out.println(obj);
	}

}
