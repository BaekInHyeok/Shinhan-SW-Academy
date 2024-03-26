package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car implements Comparable<Car> {

	public String model;
	public int price;
	public String color;

	public void run() {
		System.out.println("자동차가 달립니다");
	}

	// ASC:나의 값, 들어온 값
	// 값이 같으면 자리이동 없음
	// DESC:들어온 값, 나의 값
	@Override
	public int compareTo(Car obj) {
		// 가격 desc, 모델 desc, 색 asc
		int result1 = obj.price - price;
		if (result1 == 0) {
			int result2 = obj.model.compareTo(model);
			if (result2 == 0) {
				return color.compareTo(obj.color);
			}
			return result2;
		}
		return result1;
	}
}
