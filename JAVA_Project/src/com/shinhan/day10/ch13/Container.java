package com.shinhan.day10.ch13;

import lombok.AllArgsConstructor;
import lombok.Setter;

public class Container<T> {
	T data;

	void set(T data) {
		this.data=data;
	}
	
	T get() {
		return this.data;
	}
	
}
