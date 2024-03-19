package com.shinhan.day06.lab;

//추상클래스 : 추상 메서드가 하나 이상 존재
public abstract class Shape {

	private String color;
	private String type;

	public Shape() {
	}

	public Shape(String color, String type) {
		this.color = color;
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public String getType() {
		return type;
	}

	// 추상 메서드 : 정의는 있고 구현은 상속받는 자식이 함
	public abstract double calculateArea();

	public abstract double calculatePerimeter();

	public String toString() {
		return color + " " + type;
	}

}