package com.shinhan.day10.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Applicant<T> {

	T kind;
	
}
