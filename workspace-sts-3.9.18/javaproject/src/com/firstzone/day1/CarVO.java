package com.firstzone.day1;

import javax.annotation.processing.Generated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class CarVO {
	String model;
	int price;
	
	public static void main(String[] args) {
		CarVO car1 = new CarVO("abc",1000);
		System.out.println(car1);
	}
}
