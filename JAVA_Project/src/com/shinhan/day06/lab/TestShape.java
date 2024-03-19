package com.shinhan.day06.lab;

public class TestShape {

	public static void main(String args[]) {
		Shape[] s = new Shape[3];

		s[0] = new Circle("BLUE", 10);
		s[1] = new Rectangle("RED", 5, 7);
		s[2] = new Circle("GREEN", 8);

		for (int i = 0; i < 3; i++) {
			print(s[i],i);
		}
	

//		for (int i = 0; i < 3; i++) {
//			if (s[i] instanceof Circle cir) {
//				System.out.println("Shape " + i + " is a " + s[i] + " with an area of " + s[i].calculateArea()
//						+ ", a radius of " + ((Circle) s[i]).getRadius() + ":" + cir.getRadius()
//						+ ", and a perimeter of " + s[i].calculatePerimeter());
//			} else if (s[i] instanceof Rectangle) {
//				System.out.println("Shape " + i + " is a " + s[i] + " with an area of " + s[i].calculateArea()
//						+ " and a perimeter of " + s[i].calculatePerimeter());
//			}
//		}
	}

//	private static void print(Shape s, int i) {
//		// TODO Auto-generated method stub
//		if (s instanceof Circle cir) {
//			System.out.println("Shape " + i + " is a " + s + " with an area of " + s.calculateArea()
//					+ ", a radius of " + ((Circle) s).getRadius() + ":" + cir.getRadius()
//					+ ", and a perimeter of " + s.calculatePerimeter());
//		} else if (s instanceof Rectangle) {
//			System.out.println("Shape " + i + " is a " + s + " with an area of " + s.calculateArea()
//					+ " and a perimeter of " + s.calculatePerimeter());
//		}
//	}
	
	private static void print(Shape s, int i) {
		String result = (s instanceof Circle cir)?
				", a radius of "+cir.getRadius():"";
		System.out.println("Shape " + i + " is a " + s
				+ " with an area of " + s.calculateArea()
				+", a radius of "
				+ result
				+ ", and a perimeter of " + s.calculatePerimeter());
	}
}
