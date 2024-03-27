package com.shinhan.day11.ch15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);

		String name = null;
		int maxScore = 0;
		int totalScore = 0;

		// 여기에 코드를 작성하세요.

		for (String key : map.keySet()) {
			totalScore += map.get(key);
			if (map.get(key) > maxScore) {
				maxScore = map.get(key);
				name = key;
			}

		}

		int avg = totalScore / map.size();
		
		System.out.println("평균:" + avg);
		System.out.println("최고점수:" + maxScore);
		System.out.println("최고점수 아이디:" + name);
		
	}

}
