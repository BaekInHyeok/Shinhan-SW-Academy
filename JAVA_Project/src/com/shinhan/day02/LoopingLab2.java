package com.shinhan.day02;

import java.util.Scanner;

public class LoopingLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Question1();
		// Question2();
		// Qusetion3();
		// Question4();
		// Question5();
		// Question6();
		// Question7();//numDays 문제
		Question8();

	}

	private static void Question8() {
		// TODO Auto-generated method stub
		int first = 0;
		int second = 0;
		int standard = 0;
		int temp = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.print("첫 번째 입력값:");
		first = scanner.nextInt();
		System.out.print("두 번째 입력값:");
		second = scanner.nextInt();

		if (first <= second) {
			standard = first;
		} else {
			standard = second;
		}
		
		standard=Integer.min(first,second);

		for (int i = 1; i <= standard; i++) {
			if (first % i == 0 && second % i == 0) {
				temp = i;
			}
		}

		System.out.printf("최대공약수 : %d", temp);

	}

	private static void Question7() {
		// TODO Auto-generated method stub
		int year = 0;
		int day = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.print("월 입력>>");
		year = scanner.nextInt();

		switch (year) {
		case 1, 3, 5, 7, 8, 10, 12:
			day = 31;
			break;
		case 4, 6, 9, 11:
			day = 30;
			break;
		case 2:
			day = 28;
			break;
		default:
			day = 0;
		}

		if (year >= 1 && year <= 12) {
			System.out.printf("%d월은 %d일입니다.", year, day);
		} else {
			System.out.printf("%d월은 존재하지 않음", year);
		}

	}

	private static void Question6() {
		// TODO Auto-generated method stub
		int year=0;
		int month=0;
		
		int day=0;
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("년도 입력>>");
		year=scanner.nextInt();	
		System.out.print("월 입력>>");
		year=scanner.nextInt();	
		
		scanner.close();
		
		switch(month) {
		case 2:
			if(year%4==0) {
				if(year%400==0 || year %100!=0) {
					day=29;
				}else {
					day=28;
				}
			}
			break;
		case 4,6,9,11:
			day=30;
			break;
		default:
			day=31;
		}

	}

	private static void Question5() {
		// TODO Auto-generated method stub
		int count = 1;
		int total = 0;

		int start = 1;
		int gap = 1;

		while (count <= 15) {
			total = total + start;
			start = start + gap;
			gap++;
			count++;
		}

		System.out.printf("15번째까지의 합 : %d", total);
	}

	private static void Question4() {
		// TODO Auto-generated method stub

		int su = 0;
		int count = 0;
		int total = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.print("양의 정수 입력>>");
		su = scanner.nextInt();

		for (int i = 1; i <= 1000; i++) {
			if (i % su == 0) {
				count++;
				total = total + i;
			}
		}

		System.out.printf("%d의 배수 개수=%d", su, count);
		System.out.println();
		System.out.printf("%d의 배수의 합=%d", su, total);

		scanner.close();
	}

	private static void Qusetion3() {
		// TODO Auto-generated method stub
		int su = 0;
		int result = 1;

		Scanner scanner = new Scanner(System.in);

		System.out.print("1보다 크고 10보다 작은 정수 입력>>");
		su = scanner.nextInt();

		if (su < 2 || su > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return;
		} else {
			for (int i = 1; i <= su; i++) {
				result = 1;
				for (int j = 1; j <= i; j++) {
					result = result * j;
				}
				System.out.printf("%d!=%d", i, result);
				System.out.println();

			}
		}

		scanner.close();
	}

	private static void Question2() {
		// TODO Auto-generated method stub
		int su = 0;
		int count = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.print("2~100 사이의 정수 입력>>");
		su = scanner.nextInt();

		for (int i = 1; i <= su; i++) {
			if (su % i == 0)
				count++;
		}

		if (count == 2) {
			System.out.printf("%d는 소수입니다.", su);
			System.out.println();
		} else {
			System.out.printf("%d는 소수가 아닙니다.", su);
			System.out.println();
		}
	}

	private static void Question1_1() {
		// TODO Auto-generated method stub

		for (int gop = 1; gop <= 9; gop++) {
			// if(gop==4)break;
			for (int dan = 2; dan <= 9; dan++) {
				// if(dan==5)break; //>>가장 가까운 for문을 빠져나간다.
				System.out.printf("%2d*%2d=%2d", dan, gop, dan * gop);
			}
			System.out.println();

		}
	}

	private static void Question1() {
		// TODO Auto-generated method stub
		int su = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.print("1보다 크고 10보다 작은 정수 입력>>");
		su = scanner.nextInt();

		if (su < 2 || su > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return;
		} else {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d*%d=%d", su, i, su * i);
				System.out.println();
			}
		}

		scanner.close();
	}

}
