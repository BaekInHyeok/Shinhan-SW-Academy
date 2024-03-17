package com.shinhan.day04;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person();
		Person p2 = new Person(3, "철수");
		Person p3 = new Person();
		Person p4 = new Person(22, "가영");

		p2.selfIntroduce();

		System.out.println("전체 인구 수 : " + Person.getPopulation());

	}

}
