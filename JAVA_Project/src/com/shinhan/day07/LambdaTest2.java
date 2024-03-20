package com.shinhan.day07;

//람다표현식 가능한지 컴파일타임에 check
//추상메서드가 반드시 1개만 가능

//매개변수 O, return X
@FunctionalInterface
interface Calculable {
	public abstract void calculate(int x, int y);
}

//매개변수 O, return O
@FunctionalInterface
interface Calculable2 {
	public abstract int calculate2(int x, int y);
}

public class LambdaTest2 {

	public static void main(String[] args) {
		call2(new Calculable2() {

			@Override
			public int calculate2(int x, int y) {
				// TODO Auto-generated method stub
				return x + y;
			}
		});

		call2((x, y) -> x - y);// 타입은 생력 가능
		call2((x, y) -> {
			System.out.println("===================");
			return x - y;
		});// 타입은 생력 가능
		call2((left, right) -> left > right ? left : right);
		call2((left, right) -> Math.max(left, right));
		
		//static method를 사용하는 경우
		call2(Math::max);//위와 동일한 효과
		
		//instance method를 사용하는 경우
		Integer a = 100;
		

	}

	private static void call2(Calculable2 cal2) {
		// TODO Auto-generated method stub
		int result = cal2.calculate2(10, 6);
		System.out.println("result");
	}

	public static void f1(String[] args) {
		call(new Calculable() {

			public void calculate(int x, int y) {
				System.out.println("익명구현 class x+y=" + (x + y));
			}
		});

		call((x, y) -> System.out.println("람다식 x-y=" + (x - y)));
		call((a, b) -> {
			System.out.println("=====================");
			System.out.println("람다식 a*b=" + (a * b));
			System.out.println("=====================");

		});

	}

	private static void call(Calculable cal) {
		// TODO Auto-generated method stub
		cal.calculate(1, 2);
	}

}
