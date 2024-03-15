package com.shinhan.day04;

public class Review {

	public static void main(String[] args) {
		method1();
		method2();
		method3();

	}

	private static void method3() {
		// TODO Auto-generated method stub
		int[][] arr = new int[3][4];
		int[][] arr2 = new int[3][];
		int[] arr3[] = new int[3][];
		int arr4[][] = new int[3][];

		//가변형 2차원 배열
		for (int i = 0; i < arr4.length; i++) {
			arr4[i] = new int[i + 2];// i가 0일 때 2, i=1일 때 3
			for (int j = 0; j < arr4[i].length; j++) {
				System.out.print(arr4[i][j]);
			}
			System.out.println();
		}

	}

	private static void method2() {
		// TODO Auto-generated method stub
		// 배열선언+생성+자동초기화
		int[] arr = new int[3];
		// 배열선언+생성+초기화
		int[] arr2 = new int[] { 1, 2, 3, 4 };
		int[] arr3 = { 10, 100, 1000, 10000 };

		// 1.배열 선언
		int[] arr4;
		// 2.생성+초기화
		arr4 = new int[] { 1, 10, 100, 1000 };

		for (int i = 0; i < arr4.length; i++) {
			System.out.printf("arr4[%d]:%d", i, arr4[i]);
			System.out.println();
		}
	}

	private static void method1() {
		// TODO Auto-generated method stub
		// 배열: 같은 타입의 여러 개의 값을 저장하기 위한 자료구조
		// heap영역에 연속 공간을 만듬
		// 개수를 알야야 생성 가능 >> 동적 생성은 ArrayList 사용 필(뒤에서 배울 예정)

		// 1.배열선언
		int a;
		int[] arr = null;
		// 2.배열생성
		arr = new int[3];// 자동초기화. 정수->0
		// 3.배열사용
		arr[0] = 100;
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]:%d", i, arr[i]);
			System.out.println();
		}

	}

}
