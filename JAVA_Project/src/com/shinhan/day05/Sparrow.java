package com.shinhan.day05;

public class Sparrow {

	private String name;
	private int legs;
	private int length;

	Sparrow() {

	}

	public Sparrow(String name, int legs, int length) {
		this.name = name;
		this.legs = legs;
		this.length = length;
	}

	public Sparrow(int legs, int length) {
		this.legs = legs;
		this.length = length;
	}

	void fly() {
		System.out.println(getClass().getSimpleName() + "(" + this.name + ")는 날아다닙니다.");
	}

	void sing() {
		System.out.println(getClass().getSimpleName() + "(" + this.name + ")가 소리 내어 웁니다.");
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "의 이름은 " + this.name + "입니다. 다리는 " + this.legs + "개이고, 길이는 " + this.length
				+ "입니다.";
	}
}
