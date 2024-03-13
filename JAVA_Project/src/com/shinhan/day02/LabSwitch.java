package com.shinhan.day02;

import java.util.Scanner;

public class LabSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 자신이 태어난 달을 키보드를 받아서 어떤 계절에 태어났는지를 출력하는 printSeason() 메서드를 구현하시오. (단, 반드시
		 * switch 문을 사용해야 하며 1~12월이 아닌 달을 입력했을 경우 “1~12 사이의 숫자만 입력하셔야 합니다.” 라는 문자를 출력하도록
		 * 해야 한다. 그리고 주어진 메서드의 시그니쳐는 변경하지 않는다.) (봄: 3, 4, 5월, 여름: 6, 7, 8월, 가을: 9, 10,
		 * 11월, 겨울 12, 1, 2월)
		 */

		printSeason();
		printSeason2();
	}

	private static void printSeason2() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int month;
		String season;

		System.out.print("태어난 달을 입력하세요>>");
		month = scanner.nextInt();

		if (month == 3 || month == 4 || month == 5) {
			season="봄";

		} else if (month == 6 || month == 7|| month == 8) {
			season="여름";

		} else if (month == 9 || month == 10 || month == 11) {
			season="가을";

		} else if (month == 12 || month == 1 || month == 2) {
			season="겨울";

		}else {
			System.out.println("1~12 사이의 숫자만 입력하셔야 합니다.");
		}
	}

	private static void printSeason() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		int month;

		System.out.print("태어난 달을 입력하세요>>");
		month = scanner.nextInt();

		switch (month) {
		case 3, 4, 5:
			System.out.println("봄에 태어나셨네요");
			break;
		case 6, 7, 8:
			System.out.println("여름에 태어나셨네요");
			break;
		case 9, 10, 11:
			System.out.println("가을에 태어나셨네요");
			break;
		case 12, 1, 2:
			System.out.println("겨울에 태어나셨네요");
			break;

		default:
			System.out.println("1~12 사이의 숫자만 입력하셔야 합니다.");
		}
	}

}
