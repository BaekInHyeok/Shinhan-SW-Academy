package com.shinhan.day06.lab;

public class Prob1 {
	public static void main(String[] args) {
		Entry e1 = new Directory("tetD");
		e1.print();
		Entry e2 = new File("testF", 1000);
		e2.print();

	}

}

//추상클래스 : 추상 메서드가 하나 이상 존재
//자식은 추상메서드를 구현할 의무가 있음

abstract class Entry {
	private String name;
	private int size;

	// 생성자 시작
	public Entry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entry(String name) {
		super();
		this.name = name;
	}

	public Entry(int size) {
		super();
		this.size = size;
	}

	public Entry(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}
	// 생성자 끝

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// 추상메서드: 정의는 있고 구현은 없는 메서드
	public abstract void print();

}

class Directory extends Entry {

	Directory(String name) {
		super(name);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(getName());

	}

}

class File extends Entry {
	File(String name, int size) {
		super(name, size);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(getName() + "(" + getSize() + ")");

	}

}
