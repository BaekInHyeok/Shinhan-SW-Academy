package com.shinhan.day05;

public class Teacher {

	String name;
	int age;
	String subject;
	
	Teacher(String name, int age, String subject){
		this.name=name;
		this.age=age;
		this.subject=subject;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	void print() {
		System.out.printf("이  름 : %s  나 이 : %d  담당과목 : %s",this.name,this.age,this.subject);
		System.out.println();
	}
	
}
