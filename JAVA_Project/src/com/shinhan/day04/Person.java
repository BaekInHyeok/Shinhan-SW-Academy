package com.shinhan.day04;

public class Person {
	
	private int age;
	private String name;
	
	private static int numberOfPersons;
	
	Person(){
		this.age=12;
		this.name="Anonymous";
		numberOfPersons++;
	}
	
	Person(int age, String name){
		this.age=age;
		this.name=name;
		numberOfPersons++;
	}
	
	public void selfIntroduce() {
		System.out.println("내 이름은 "+this.name+"이며, 나이는 "+this.age+"살입니다.");
	}

	public static int getPopulation() {
		return numberOfPersons;
	}
}
