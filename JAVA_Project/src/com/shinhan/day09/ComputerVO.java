package com.shinhan.day09;

import java.util.Objects;

//클래스 : 틀(template) >> object를 만들기 위해 사용
//object : instance(실체)

//VO(Value Object):data 저장(field 여러 개), C언어의 structure 개념과 유사
//DTAO(Data Transfer Object):data 전송 목적
//JavaBeans 기술 : default 생성자가 반드시 있어야 함.

public class ComputerVO {

	// 1.field >> 데이터 저장
	String model;
	int price;
	String company;

	public ComputerVO() {
	}

	public ComputerVO(String model, int price, String company) {
		super();
		this.model = model;
		this.price = price;
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("ComputerVO [model=");
//		builder.append(model);
//		builder.append(", price=");
//		builder.append(price);
//		builder.append(", company=");
//		builder.append(company);
//		builder.append("]");
//		return builder.toString();
//	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComputerVO [model=").append(model).append(", price=").append(price).append(", company=")
				.append(company).append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComputerVO other = (ComputerVO) obj;
		return Objects.equals(company, other.company) && Objects.equals(model, other.model) && price == other.price;
	}
	
	
	
	

}
