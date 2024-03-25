package com.shinhan.day09;

import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println("1.main 시작");
		// f1(0);
		// f2();
		// f3();
//		f4();
//		f5();
//		f6();
//		f7();
		f8();
		// System.out.println("4.main 끝");
	}

	private static void f8() {
		// 이메일
		String regExp = "(\\w+)@(\\w+\\.\\w+)";// ()로 싸인 부분이 각각 group1,group2
		String data = "wed0406@daum.net";

		boolean result = Pattern.matches(regExp, data);

		System.out.println(result);

		Pattern patt = Pattern.compile(regExp);
		Matcher mat = patt.matcher(data);

		while (mat.find()) {
			System.out.println(mat.group());// 전체
			System.out.println(mat.group(0));// 전체
			System.out.println(mat.group(1));// 첫 번째 괄호
			System.out.println(mat.group(2));// 두 번째 괄호
			System.out.println("---------------------");

		}
	}

	/*
	 * []:선택 [-]:범위 {3}:횟수 \\d=[-]와 같은 +:1개 이상 *:0개 이상 \\w:[0-9A-Za-z]와 같은 의미
	 */
	private static void f7() {
		// 제어문자는 정해져있음 : \t \n \" ... \\->\를 뜻함
		String reqExp = "[01]{3}-[0-9]{3,4}-\\d{4}";// 전화번호 패턴 구현
		String data = "010-1234-5678";

		boolean result = Pattern.matches(reqExp, data);

		System.out.println("Matches 결과 : " + result);

		// 패턴에 따른 다중 추출
		String data2 = "짜장면집 111-2234-5555 스시집 111-3048-3356";
		Pattern patt = Pattern.compile(reqExp);

		Matcher mat = patt.matcher(data2);
		while (mat.find()) {
			System.out.println(mat.group());
		}
	}

	private static void f6() {
		// Split 사용
		System.out.println("----------------------");
		// Split은 빈값도 사용
		String str = "컴퓨터 커피@지갑, 마이크";
		String arr[] = str.split("@|,| ");
		System.out.println("배열갯수:" + arr.length);

		for (String s : arr) {
			System.out.println(s);
		}

		// StringTokenizer 사용
		System.out.println("----------------------");
		// StringTokenizer는 (, )에서 ( )는 무시함(빈 토큰은 신경안씀)
		StringTokenizer st = new StringTokenizer(str, "@|,| ");
		System.out.println("토큰 개수:" + st.countTokens());
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void f5() {
		// StringBuilder, StringBuffer는 직접 문자열 할당 불가
		StringBuilder s1 = new StringBuilder("이것이 자바다");
		StringBuffer s2 = new StringBuffer("이것이 자바다");

		System.out.println(System.identityHashCode(s1));
		s1.append("!!!!");
		s1.insert(0, "####");
		System.out.println(s1);
		System.out.println(System.identityHashCode(s1));

	}

	private static void f4() {
		// String은 고정문자열이다.
		String s1 = "이것이자바다";
		String s2 = new String("이것이자바다");

		byte[] arr = { 65, 66, 67, 97, 98, 99 };// ABCabc
		String s3 = new String(arr);

		char[] arr2 = { '가', '나', '다' };
		String s4 = new String(arr2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(System.identityHashCode(s4));
		s4 += "!!!!";
		System.out.println(System.identityHashCode(s4));

	}

	private static void f3() {
		// Properties는 Map(key,value)를 구현함
		// Properties의 키는 Set으로 만들어짐
		// Set<Object>
		// key가 String이었음 -> Propertiese(키가 Object)
		// <-
		System.out.println(System.getProperty("java.version"));

		Properties pr = System.getProperties();
		for (Object key : pr.keySet()) {
			String value = System.getProperty((String) key);
			System.out.println(value);
		}
	}

	private static void f2() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		long startTime2 = System.nanoTime();

		int total = 0;
		for (int i = 1; i < 1000000000; i++) {
			total += i;
		}

		long endTime = System.currentTimeMillis();
		long endTime2 = System.nanoTime();
		System.out.println(endTime - startTime + "ms");
		System.out.println(endTime2 - startTime2 + "ms");

	}

	private static void f1(int j) {
		// TODO Auto-generated method stub
		System.out.println("2.f1() 시작");
//		if (j == 0)
//			//return;//함수 빠져나오기
//			System.exit(0);//관례적으로 0은 정상종료, -1은 비정상종료를 의미
//		int i = 10 / j;

		try {
			int i = 10 / j;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("3.f1() 끝");
	}

}
