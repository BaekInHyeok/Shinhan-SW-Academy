package com.shinhan.day09;

import java.util.HashSet;

public class ObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//f1();
		//f2();
		f3();
	}

	private static void f3() {
		// TODO Auto-generated method stub
		ComputerVO3 com1 = new ComputerVO3(null, 100, "Samsung");
		ComputerVO3 com2 = new ComputerVO3("A", 100, "Samsung");
		ComputerVO2 com3 = new ComputerVO2(null, 100, "Samsung");//record
		
		ComputerVO2 aa = new ComputerVO2("B", 1000, "CC");
		System.out.println(aa.model());
		
		System.out.println(com1);
		System.out.println(com2);
		System.out.println(com1.equals(com2));
		
		System.out.println(com1.getModel());
		System.out.println(com3.model());
	}

	private static void f2() {
		// TODO Auto-generated method stub
		ComputerVO2 com1 = new ComputerVO2("A", 100, "Samsung");
		ComputerVO2 com2 = new ComputerVO2("A", 100, "Samsung");
		System.out.println(com1);
		System.out.println(com2);
		System.out.println(com1.equals(com2));
	}

	private static void f1() {
		// TODO Auto-generated method stub
		ComputerVO com1 = new ComputerVO("A", 100, "Samsung");
		ComputerVO com2 = new ComputerVO("A", 100, "Samsung");

		System.out.println(com1);// toString()이 호출됨
		System.out.println(com2);

		System.out.println(com1 == com2);// 주소비교,c++에서는 재정의 가능하지만 java는 불가
		System.out.println(com1.equals(com2));// equals : 주소비교, 재정의 가능

		// 동일객체비교(hahcode(), equals() 재정의)
		// Set:순서 없음, 중복 불가
		HashSet<ComputerVO> computers = new HashSet<>();// 뒷쪽은 타입 생략 가능
		computers.add(com1);
		computers.add(com2);
		computers.add(new ComputerVO("A", 100, "Samsung"));
		System.out.println(computers.size());

		for (ComputerVO com : computers) {

			System.out.println(com);
		}
	}

}
