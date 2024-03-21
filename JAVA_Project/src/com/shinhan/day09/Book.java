package com.shinhan.day09;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

//JavaBeans 기술:field는 private, getter/setter, default 생성자
//DTO(Data Transfer Object):data 전송을 위해 만듦
//VO(Value Object) : 값을 저장하기 위해 만듦
public class Book {
	

	String title;
	int price;
	String author;

}
