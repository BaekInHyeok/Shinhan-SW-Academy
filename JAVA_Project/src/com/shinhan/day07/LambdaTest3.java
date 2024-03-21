package com.shinhan.day07;

public class LambdaTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person = new Person(10, 20);

		person.action(new ComputeInterface() {

			@Override
			public double calc(double x, double y) {
				// TODO Auto-generated method stub
				System.out.println("---1.익명 구현 class(-)----");
				return x - y;
			}
		});

		person.action((a, b) -> {
			System.out.println("2.람다표현식");
			return a + b;
			// Person > action >> ComputeInterface > double calc(x,y)->return받는 곳
		});

		// 이미 만들어진 메서드가 static인 경우 사용할 수 있음
		person.action(Computer::staticMethod);

		// 이미 만들어진 instance method사용 >> instance는 LambdaTest3에서 재정의가 가능하다.
		Computer com = new Computer();
		person.action(com::instanceMethod);
	}
}