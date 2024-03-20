package com.shinhan.day07.lab;

interface Resizeable {
	void resize(double s);
}

abstract class Shape {
	int numSides;

	Shape(int numSides) {
		this.numSides = numSides;
	}

	int getNumSides() {
		return numSides;
	}

	public abstract double getArea();

	public abstract double getPerimeter();
}

class Rectangle extends Shape implements Resizeable {

	double width;
	double height;

	Rectangle(int numSides) {
		super(numSides);
		// TODO Auto-generated constructor stub
	}

	public Rectangle(double w, double h) {
		// TODO Auto-generated constructor stub
		super(3);
		this.width = w;
		this.height = h;
	}

	@Override
	public void resize(double s) {
		// TODO Auto-generated method stub
		width = width * s;
		height = height * s;

	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.width * this.height;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2.0 * (this.width + this.height);
	}

}

class RectTriangle extends Shape {
	double width;
	double height;

	RectTriangle(double w, double h) {
		super(4);
		this.width = w;
		this.height = h;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (this.width * this.height) / 2.0;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return width + 2*Math.sqrt(Math.pow(width / 2.0, 2) + Math.pow(height, 2));
	}

}

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape[] arr = new Shape[3];

		Rectangle object1 = new Rectangle(5.0, 6.0);
		Rectangle object2 = new Rectangle(5.0, 6.0);
		object2.resize(0.5);
		RectTriangle object3 = new RectTriangle(6.0, 2.0);

		arr[0] = object1;
		arr[1] = object2;
		arr[2] = object3;

		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i].getArea() + " / " + arr[i].getPerimeter());

		}
	}

}
