package com.shinhan.day04;

public class ParameterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParameterTest aa = new ParameterTest();
		aa.sum(10, 20);
		sum(10, 20, 30);//자동형변환
		sum(10, 20, 30, 40);
		sum(10, 20, 30, 40, 50);

		int[] values = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		sum(values);

		sum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });

		sum("자바", "프로그램");
		sum(3.14, 10.5, 20.5);

	}

	private static void sum(double d, double e, double f) {
		// TODO Auto-generated method stub
		System.out.println("실수3:" + (d + e + f));
	}

	private static void sum(String str1, String str2) {
		// TODO Auto-generated method stub
		System.out.println("문자2:" + str1 + str2);
	}

	// 메서드 오버로딩:메서드 이름은 같지만 매개변수 사양(타입,개수)이 다름
	private static void sum(int... datas) {
		int total = 0;
		for (int data : datas) {
			total += data;
		}
		System.out.println("가변길이 매개변수 합:" + total);
	}

//	private static void sum(int i, int j, int k) {
//		// TODO Auto-generated method stub
//		System.out.println("정수합3:" + (i + j + k));
//	}

	// 멤버 메서드(non-static):객체 생성 후에 호출 가능(7번 줄)
	// static은 static에서만 호출 가능
	void sum(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("정수합2:" + (i + j));
	}

	void print() {
		sum(1, 2);
	}

}
