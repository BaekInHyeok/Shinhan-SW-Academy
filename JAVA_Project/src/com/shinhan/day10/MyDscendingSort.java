package com.shinhan.day10;

import java.util.Comparator;

public class MyDscendingSort implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// 앞-뒤 : ASC, 뒤-앞(DESC)
		return o2 - o1;
	}

}
