package com.shinhan.day11;

import com.shinhan.day10.thread.Account;

import lombok.Setter;

//제네릭 : 구체적인 타입은 사용할 때 결정, 컴파일 시 강한 타입체크, Object를 사용한다면 강제형변환이 필요함
@Setter
class Box<T> {
	T content;

	//default 생성자
	public Box() {

	}

	public Box(T content) {
		super();
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Box [content=").append(content).append("]");
		return builder.toString();
	}

}

class BigBox<T, S> extends Box<T> {

	S size;
	public BigBox(T content, S size) {
		super(content);
		this.size = size;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BigBox [size=").append(size).append("]");
		return builder.toString();
	}
}

class AccountChild extends Account{

	public AccountChild(String accuntNo, String ownerName, int balance) {
		super(accuntNo, ownerName, balance);
		// TODO Auto-generated constructor stub
	}
	
}


public class Review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		f1();
		f2();
		f3();
		f4();
		f5();
	}
	
	private static void f5() {
		// TODO Auto-generated method stub
		
		//배열은 실행 시 만들어짐
		String[] arr = {"A","B","C"};
		int[]arr2 = {1,2,3,4,5};
		
		Object[] arr3;
		arr3=arr;
		
		arr3[0]=10;
		
		//제네릭은 배열 생성 불가
		//Box<Account>[] b3 =new Box<Account>;
	}

	private static void f4() {
		// TODO Auto-generated method stub
		Box<Double> box1 = call2(3.14);
		Box<Integer> box2 = call2(100);
		Box<Long> box3 = call2(1234567890000L);

		System.out.println(box1);//toString()
		System.out.println(box2);//toString()
		System.out.println(box3);//toString()
	}
	
	private static <T extends Account> Box<T> call3(T t) {//Account를 상속받은 것만 가능
		// TODO Auto-generated method stub
		return new Box<T>(t);
	}
	
	private static void f3() {
		// TODO Auto-generated method stub
		Box<Double> box1 = call2(3.14);
		Box<Integer> box2 = call2(100);
		Box<Long> box3 = call2(1234567890000L);

		System.out.println(box1);//toString()
		System.out.println(box2);//toString()
		System.out.println(box3);//toString()
	}
	
	private static <T extends Number> Box<T> call2(T t) {// 타입값을 숫자 계열로 제한(Integer, Double, Long 등등)
		// TODO Auto-generated method stub
		return new Box<T>(t);
	}

	private static void f2() {
		// TODO Auto-generated method stub
		Box<String> box1 = call("문자");
		Box<Integer> box2 = call(100);
		Box<Account> box3 = call(new Account("112", "j", 100));

		System.out.println(box1);//toString()
		System.out.println(box2);//toString()
		System.out.println(box3);//toString()
	}

	private static <T> Box<T> call(T t) {// 앞쪽에 <T> 써주는 것 잊지 말기
		// TODO Auto-generated method stub
		return new Box<T>(t);
	}

	private static void f1() {
		// TODO Auto-generated method stub
		Box<String> box1 = new Box<>("문자");
		Box<String> box2 = new Box<>();
		Box<Integer> box3 = new Box<>(100);
		Box<Integer> box4 = new Box<>();
		Box<Account> box5 = new Box<>();
		Box<Account> box6 = new Box<>();

		
		box2.content = "String";
		box4.content = 100;
		Integer a = box3.content;
		Account acc = new Account(null, null, 0);
		box5.content=acc;
		box6.setContent(new Account("112","A",300));

		

	}

}
