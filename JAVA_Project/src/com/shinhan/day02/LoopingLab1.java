package com.shinhan.day02;

import java.util.Scanner;

public class LoopingLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Question1();
		//Question2();
		//Question3();
		Question4();

	}

	private static void Question4() {
		// TODO Auto-generated method stub
		int su=0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("직각 역삼각형 출력 줄 수>>");
		su=scanner.nextInt();
		
		for(int row=1;row<=su;row++) {
			for(int col=1;col<=su+1-row;col++)
				System.out.print("*");
		}
		System.out.println();
	}

	private static void Question3() {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		int num;
		int total=0;
		
		System.out.print("숫자 입력>>");
		num=scanner.nextInt();
		
		if(num%2==0) {//짝수
			for(int i=0;i<=num;i=i+2) {
				total=total+i;
			}
		}else//홀수
			for(int i=1;i<=num;i=i+2) {
				total=total+i;
			}
		
		System.out.println("결과:"+total);

	}

	private static void Question2() {
		// TODO Auto-generated method stub

		String word;
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열 입력>>");
		word = scanner.nextLine();

		word = word.toUpperCase();

		for (int i = 1; i <= word.length(); i++)
			System.out.println(word.substring(0,i));
		
		
			

		scanner.close();
	}

	private static void Question1() {
		// TODO Auto-generated method stub
		int start;// 시작
		int end;
		;// 끝
		int add;// 증가분
		int total = 0;// 합계

		Scanner scanner = new Scanner(System.in);

		System.out.print("초기값을 정수로 입력>>");
		start = scanner.nextInt();
		System.out.print("마지막 값을 정수로 입력>>");
		end = scanner.nextInt();
		System.out.print("중가분을 정수로 입력>>");
		add = scanner.nextInt();

		for (int i = start; i <= end; i += add) {
			total = total + i;
		}

		if (total > 1000) {
			total = total + 2000;
		}

		System.out.println("총합은 " + total + "입니다");

		scanner.close();
	}

}
