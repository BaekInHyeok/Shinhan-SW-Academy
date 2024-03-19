package com.shinhan.day06.lab;

public class Rectangle extends Shape {

	double length;
	double width;

	Rectangle(String color, double length, double width) {

		super(color, "Rectangle");
		this.length = length;
		this.width = width;

	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return length * width;
	}

	//@ -> 컴파일러가 해석하는 주석(Annotation)
	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2 * (length + width);
	}

}
