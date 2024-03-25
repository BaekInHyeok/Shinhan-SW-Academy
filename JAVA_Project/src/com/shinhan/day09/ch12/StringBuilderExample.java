package com.shinhan.day09.ch12;

import java.util.StringTokenizer;

public class StringBuilderExample {
	
	//Q11
	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		
		StringTokenizer stringTokenizer = new StringTokenizer(str,",| ");
		
		while(stringTokenizer.hasMoreTokens()) {
			System.out.println(stringTokenizer.nextToken());
			
		}
	}

	//Q10
	public static void f1(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder str = new StringBuilder();
		System.out.println(System.identityHashCode(str));

		for (int i = 1; i <= 100; i++) {
			str.append(String.valueOf(i));
			System.out.println(System.identityHashCode(str));
		}
		System.out.println(str);
	}

}
