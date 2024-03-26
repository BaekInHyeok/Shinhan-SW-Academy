package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Box<T> {

	private T content;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	
}
