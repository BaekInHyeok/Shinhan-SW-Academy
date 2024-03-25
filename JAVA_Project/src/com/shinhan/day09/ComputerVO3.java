package com.shinhan.day09;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//클래스 : 틀(template) >> object를 만들기 위해 사용
//object : instance(실체)

//VO(Value Object):data 저장(field 여러 개), C언어의 structure 개념과 유사
//DTAO(Data Transfer Object):data 전송 목적
//JavaBeans 기술 : default 생성자가 반드시 있어야 함.
//@ToString
//@EqualsAndHashCode
//@Setter
//@Getter
@AllArgsConstructor
//@NoArgsConstructor
@Data
public class ComputerVO3 {

	// 1.field >> 데이터 저장

	public ComputerVO3(int price, String company) {
		// TODO Auto-generated constructor stub
		this.price = price;
		this.company = company;
	}

	@NonNull
	String model; //model은 null이 될 수 없다 >> key에 해당하는 변수에 주로 사용
	
	
	int price;
	String company;

}
