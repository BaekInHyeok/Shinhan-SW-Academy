package com.shinhan.day10.ch13;

import lombok.Getter;

@Getter
public class Container2<A, B> {

	A key;
	B value;
	
	void set(A key, B value){
		this.key=key;
		this.value=value;
	}
	
}
