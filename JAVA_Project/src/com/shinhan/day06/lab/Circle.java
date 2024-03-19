package com.shinhan.day06.lab;

public class Circle extends Shape {

	double radius;
	double circumference;

	public Circle(String color, double radius) {
		super(color, "Circle");
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return radius * radius * Math.PI;
	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub

		circumference = 2 * Math.PI * radius;
		return circumference;
	}

}
