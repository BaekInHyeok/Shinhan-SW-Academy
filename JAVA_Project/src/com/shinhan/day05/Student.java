package com.shinhan.day05;

public class Student {

	private String name;
	private int age;
	private int id;
	
	Student(String name, int age, int id){
		this.name=name;
		this.age=age;
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	void print() {
		System.out.printf("이  름 : %s  나 이 : %d  학  번 : %d",this.name,this.age,this.id);
		System.out.println();
	}
	
	
	
	
}
