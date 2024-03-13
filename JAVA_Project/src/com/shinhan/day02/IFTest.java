package com.shinhan.day02;

public class IFTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		method1();
		method2();
		method3();
		method4();
		method5();
		method6();

	}

	private static void method6() {
		// TODO Auto-generated method stub
		
		//Wrapper class->기본형+기능추가
		char grade = 'A';
		String message;
		
		grade=Character.toLowerCase(grade);//소문자로 변경
		
		
		switch(grade) {
		case 'a'->{message="우수회원";}
		case 'b'->{message="일반회원";}
		default->{message="손님";}
		}
		
		System.out.printf("Switch 사용 => %s입니다.", message);
		
		if (grade == 'a') {
			message = "우수회원";
		} else if (grade == 'b') {
			message = "일반회원";
		} else {
			message = "손님";
		}

		System.out.printf("\nIF 사용 => %s입니다.", message);

	}

	private static void method5() {
		// TODO Auto-generated method stub
		char grade = 'B';
		String message;

		if (grade == 'A' || grade == 'a') {
			message = "우수회원";
		} else if (grade == 'B' || grade == 'b') {
			message = "일반회원";
		} else {
			message = "손님";
		}

		System.out.printf("%s입니다.", message);

		switch (grade) {
		case 'A', 'a':{
			int point=100;
			message = "우수회원";
			break;
		}
		case 'B', 'b':{
			String point="good";
			message = "일반회원";
			break;
		}
		default:
			message = "손님";
		}

		System.out.printf("\n%s입니다.", message);
		
		//12버전부터 지원
		switch(grade){
		case 'A','a'->{message="우수회원";}
		case 'B','b'->{message="일반회원";}
		default->{message="손님";}
		}
		
		System.out.printf("\n%s입니다",message);
	}


	private static void method4() {
		// TODO Auto-generated method stub
		double su = Math.random();// 0<=su<1
		int result = (int) (su * 10) + 1;// 1<=result<=10
		int result2 = (int) (su * 45) + 1;// 1<=result2<=45

	}

	private static void method3() {
		// TODO Auto-generated method stub
		int score = 80;
		String grade;
		// break는 switch 빠져나오기. 없으면 무조건 아래로 흐른다.
		// 17 버전은 , 가능
		switch (score / 10) {
		case 10, 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		System.out.printf("%s학점", grade);

	}

	private static void method2() {
		// TODO Auto-generated method stub
		int score = 80;
		String grade;
		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}

		System.out.printf("%s학점", grade);
	}

	private static void method1() {
		// TODO Auto-generated method stub
		int score = 100;

		if (score >= 90) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		System.out.println("if 끝");
	}

}
