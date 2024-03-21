package com.shinhan.day08.lab;

public class MySum {
	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}

	/* 조건1 */

	@Override
	public String toString() {
		return String.valueOf(first + second);
	}

	/* 조건2 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MySum))
			return false;
		MySum my = (MySum) obj;
		return this.toString().equals(my.toString());
	}

}
