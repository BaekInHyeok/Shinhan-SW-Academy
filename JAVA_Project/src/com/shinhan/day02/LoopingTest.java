package com.shinhan.day02;

public class LoopingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
		method2();
		method3();
		method4();

	}

	//중첩 for문
	private static void method4() {
		// TODO Auto-generated method stub
		//3행*4열
		for(int row=1;row<=3;row++) {
			for(int col=1;col<=4;col++) {
				System.out.printf("%d행 %d열 \t",row,col);
			}
			System.out.println();
		}
	}

	//do while문
	private static void method3() {
		// TODO Auto-generated method stub
		int i = 1;
		do {
			System.out.println(i + "while문 연습");
			i++;
		} while (i <= 10);
		System.out.println("while후 ...i=" + i);
	}

	//while문
	private static void method2() {
		// TODO Auto-generated method stub
		int i = 1;
		while (i <= 10) {
			System.out.println(i + "while문 연습");
			i++;
		}
		System.out.println("while후 ...i=" + i);
	}

	//for문
	private static void method1() {
		// TODO Auto-generated method stub
		// 1.for문...조건에 맞는 동안 반복
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + ":java배우기");
		}
	}

}
