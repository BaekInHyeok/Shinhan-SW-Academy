package com.shinhan.day08;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@EqualsAndHashCode(exclude = "price")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//JavaBeans 기술:field는 private, getter/setter, default 생성자
//DTO(Data Transfer Object):data 전송을 위해 만듦
//VO(Value Object) : 값을 저장하기 위해 만듦
public class Book {

	String title;
	int price;
	String author;

	@Override
	public int hashCode() {
		return Objects.hash(author, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && price == other.price && Objects.equals(title, other.title);
	}

//	@Override
//	public boolean equals(Object obj) {
//		Book book = (Book) obj;
//		return title.equals(book.title);
//	}
//
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return title.hashCode();
//	}

}
