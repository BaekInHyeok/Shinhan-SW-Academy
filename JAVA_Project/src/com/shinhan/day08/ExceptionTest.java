package com.shinhan.day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {

	// 예외:
	// 1)RuntimeException...실행시 오류 발생
	// 2)일반Exception
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		method1(1);
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();

		try {
			method8();
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-------Main End-------");

	}

	private static void method8() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.shinhan.day09.Book");
		FileReader fi = new FileReader("src/com/shinhan/day08/Book22.java");
		int i;
		while ((i = fi.read()) != -1) {
			System.out.println((char) i);
		}
		fi.close();
	}

	private static void method7() {
		// TODO Auto-generated method stub
		try (FileReader fi = new FileReader("src/com/shinhan/day08/Book.java")) {
			int i;
			while ((i = fi.read()) != -1) {
				System.out.println((char) i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void method6() {
		// TODO Auto-generated method stub
		FileReader fi = null;// FileInputStream은 1byte, FileReader는 2Byte씩 읽는다
		int i;
		try {
			fi = new FileReader("src/com/shinhan/day08/Book.java");
			while ((i = fi.read()) != -1) {
				System.out.print((char) i);// 1013...return Enter와 ASCII 코드값

			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음 " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			if (fi != null)
//				try {
//					fi.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			try {
//				if (fi != null)
				fi.close();// 자원 반납(파일 열기 후 닫기,자원 반납)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			} catch (NullPointerException e) {
				System.out.println("파일 open 불가... 닫기 불가");
			}
		}

	}

	private static void method5() {
		// 하나의 메서드 혹은 class에서 같은 이름의 class를 이용하는 경우
		// 같은 패키지에서 우선 탐색
		// 다른 패키지에 있는 class는 반드시 패키지 이름까지 써야 함
		Book a = new Book();
		com.shinhan.day09.Book b = new com.shinhan.day09.Book();
		System.out.println(a);
		System.out.println(b);
		try {
			Class mybook = Class.forName("com.shinhan.day09.Book");
			System.out.println(mybook.getName());
			System.out.println(mybook.getPackageName());
			System.out.println(mybook.getSimpleName());
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		System.out.println("--------------");
	}

	private static void method4() {
		// TODO Auto-generated method stub
		com.shinhan.day09.Book a = new com.shinhan.day09.Book();
		try {
			Class.forName("com.shinhan.day09.Book");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		System.out.println("--------------");

	}

	private static void method3() throws IOException {
		// 일반Exception... RuntimeException 제외한 Exception : 컴파일 시에 check
		// 반드시 Exception 처리를 해야 한다.
		// 1)내가 한다 2)떠넘긴다
		InputStream input = System.in;

		int data = input.read();

	}

	private static void method2() {
		// 일반Exception... RuntimeException 제외한 Exception : 컴파일 시에 check
		// 반드시 Exception 처리를 해야 한다.
		// 1)내가 한다 2)떠넘긴다
		InputStream input = System.in;
		// int data = input.read();
		try {
			int data = input.read();
			System.out.println(data);
		} catch (IOException ex) {
			System.out.println("IO오류");
		}

	}

	// 오류 발생 시 JVM이 자동으로 Exception 객체를 생성해서 Exception이 발생한 곳으로 준다
	// try-catcih :
	private static void method1(int count) {
		// 예외:
		// 1)RuntimeException...실행시 오류 발생
		int score = 100;
		int[] arr = new int[10];
		String s = "백";

		// if(count==0) return; ...오류 처리와 비즈니스 로직이 섞이는 문제가 있음

		try {
			System.out.println("평균은 " + score / count);
			arr[0] = 99;
			System.out.println(arr[0]);
			System.out.println(Integer.parseInt(s) + 200);
		} catch (ArithmeticException ex) {// 그냥 Exception ex로 받아도 됨
			// Exception 처리...중단 업이 계속 진행됨
			System.out.println("연산오류..." + ex.getMessage());

		} catch (NullPointerException ex) {// 그냥 Exception ex로 받아도 됨
			// Exception 처리...중단 업이 계속 진행됨
			System.out.println("연산오류..." + ex.getMessage());

		} catch (ArrayIndexOutOfBoundsException ex) {// 그냥 Exception ex로 받아도 됨
			// Exception 처리...중단 업이 계속 진행됨
			System.out.println("연산오류..." + ex.getMessage());

		}
		// catch (NumberFormatException ex) {// 그냥 Exception ex로 받아도 됨
		// Exception 처리...중단 업이 계속 진행됨
		// System.out.println("연산오류..."+ex.getMessage());
		// }
		catch (Exception ex) {// 그냥 Exception ex로 받아도 됨
			// Exception 처리...중단 업이 계속 진행됨
			System.out.println("Exception..." + ex.getMessage());
			ex.printStackTrace();

		} finally {
			System.out.println("오류 여부와 상관없이 무조건 수행하는 업무");
		}

		System.out.println("----------");
	}

}
