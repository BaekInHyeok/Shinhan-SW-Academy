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

		ArrayList<Integer> arraylist = new ArrayList<Integer>();// 입출금 내역을 저장하는 동적 배열

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			x=Character.getNumericValue(c);
			
			arraylist.add(x);
		}

		for (int st : arraylist) {
			System.out.println(st);
		}

	}

}
