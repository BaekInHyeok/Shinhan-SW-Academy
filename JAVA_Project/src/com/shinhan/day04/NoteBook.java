package com.shinhan.day04;

public class NoteBook {

	//1.field : 객체마다 다른 객체와 구별되는 값을 저장하기 위함
	//(1)static->스태틱(공유)변수
	//(2)non-static -> 인스턴스(객체) 변수
	private String model;
	private int price;
	
	static int count;//공유변수가 됨
	
	//2.constructor : 값 초기화가 목적
	public NoteBook(String model, int price) {
		super();
		this.model = model;
		this.price = price;
		count++;
	}

	//3.getter/setter
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

	@Override
	public String toString() {
		return "NoteBook [model=" + model + ", price=" + price + "]";
	}
	
	
}
