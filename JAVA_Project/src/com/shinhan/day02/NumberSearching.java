package com.shinhan.day02;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberSearching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word;
		int x;

		Scanner scanner = new Scanner(System.in);

		word = scanner.nextLine();

		ArrayList<Integer> arraylist = new ArrayList<Integer>();// 입력받은 숫자 문자열을 숫자로 바꿔 저장하는 동적 배열
		ArrayList<String> convert = new ArrayList<String>();// 숫자코드를 기호 기반 문자열로 convert한 결과를 만드는 용도의 동적 배열
		

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			x=Character.getNumericValue(c);
			
			arraylist.add(x);
		}

		for (int st : arraylist) {
			System.out.println(st);
		}
		
		for (int st : arraylist) {
			if(st==0) {
				
			}
			else if(st==1) {
				
			}
			else if()
		}

	}

}
