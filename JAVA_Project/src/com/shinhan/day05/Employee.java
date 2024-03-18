package com.shinhan.day05;

public class Employee {

	String name;
	int age;
	String dept;
	
	Employee(String name, int age, String dept){
		this.name=name;
		this.age=age;
		this.dept=dept;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	void print() {
		System.out.printf("이  름 : %s  나 이 : %d  부  서 : %s",this.name,this.age,this.dept);
		System.out.println();
	}
}
