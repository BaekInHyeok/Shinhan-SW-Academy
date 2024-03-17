package com.shinhan.day04;

public class Car {

	//1.field(특징, 변수, data 저장, 멤버변수)
	//접근지정자(Modifier)가 private인 경우, 외부에서 접근 불가
	//접근하고자 한다면, 기능이 추가되어야 한다.(getter, setter)
	//JavaBeans 기술의 규칙:setCompany, getCompany
	private String company="현대자동차";
	private String model;
	private String color;
	private int maxSpeed;
	
	public void setCompany(String company) {
		this.company= company;
	}
	String getCompany(String company) {
		return company;
	}
	
	//2.Constructor(생성자)...생성하는 여러가지 방법들을 정의(Overloading)
	Car(){
		//default 생성자
	}
	Car(String model, String color, int maxSpeed){
		//super(); 부모 생성(생략되어 있음)
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	
	Car(String model, int maxSpeed,String color){
		this(model,color,maxSpeed);//생성자 호출은 첫 번째 줄에서만 가능, super()부분이 수행되지 않음
	}//요렇게 만들어놓으면 유지보수 효율성이 조금이라도 올라감
	
	Car(String color, int maxSpeed){
//		this.color=color;
//		this.maxSpeed=maxSpeed;
		this(null,color,maxSpeed);
	}
	
	Car(String model){
		this.model=model;
	}
	
	String first;//멤버변수 - 초기화 불필요
	
	//3.메서드(기능, 동작, 문장들의 묶음, return type 필/없으면 void)
	String carInfoPrint(String title){
		String second=null;//지역변수 - 반드시 초기화해 사용
		System.out.println(title);
		System.out.println("---------------Car 정보----------------");
		System.out.println("회사:"+company);
		System.out.println("모델:"+model);
		System.out.println("색:"+color);
		System.out.println("최고속력:"+maxSpeed);
		System.out.println(first);
		System.out.println(second);
		
		return "##############";
	}
	
	void powerOn() {
		System.out.println("Power ON");
	}
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed
				+ ", first=" + first + "]";
	}
	
	
	
}
