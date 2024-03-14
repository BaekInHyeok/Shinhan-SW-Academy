package com.shinhan.day03;

import java.util.Arrays;

public class ReferenceTest {

	public static void main(String[] args) {
		call();
		call2();
		call3();
		call4();
	}

	private static void call4() {
		// TODO Auto-generated method stub
		String subject = "이것이 자바다 저자는 신용권,임경균";
		
		System.out.println("replace:"+subject.replace("자바", "JAVA"));
		System.out.println("원본불변:"+subject);
		System.out.println("indexOf:"+subject.indexOf("자바"));
		
		String[] arr = subject.split(",|@| ");
		System.out.println(Arrays.toString(arr));
	}

	private static void call3() {
		// TODO Auto-generated method stub
		String subject = "이것이 자바다";
		
		System.out.println("length:"+subject.length());
		
		//substring:문자열의 일부만 출력
		System.err.println("substring"+subject.substring(4));
		System.err.println("substring"+subject.substring(4,6));
		
		//charAt
		System.out.println("charAt:"+subject.charAt(0));
		
		for(int i=0;i<subject.length();i++) {
			System.out.println("charAt:"+subject.charAt(i));
		}
		
	}

	private static void call2() {
		// TODO Auto-generated method stub
		String s1="자바";
		String s2="자바";
		String s3=new String("자바");
		String s4=new String("자바");
		
		//String은 고정문자열
		s1+="프로그램"; //주소 달라짐
		s2+="프로그램";
		
		System.out.println(s1==s2?"같은 주소":"다른 주소");//주소 : 다름
		System.out.println(s3==s4?"같은 주소":"다른 주소");
		System.out.println(s1.equals(s2)?"같은 내용":"다른 내용");//내용: 같음
		
	}

	private static void call() {
		// TODO Auto-generated method stub
		int a = 10;
		String s = null;

		System.out.println("기본형연습:" + a);
		System.out.println("참조형연습:" + a);
		try {
			// Exception 발생 가능성이 있는 문장을
			System.out.println("참조형연습" + s.length());// NullPointerException
		} catch (NullPointerException aa) {
			System.out.println("null은 정의된 값이 없다는 의미, 복구 가능");
		}
		System.out.println("Exception 발생 시 프로그램 중단");

	}
}
