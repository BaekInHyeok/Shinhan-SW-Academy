package com.shinhan.day05;

//class : object를 만들기 위한 툴(template),설계도
//object : class를 이용하여 만든 독립된 객체
//instance == object, new로 만든 실체(메모리에 저장됨)
public class Car {
	// 1.field(특징, data 값 저장, 변수)
	// :static(클래스변수,object 공통 변수,정적)
	// :non-static(instance 변수, 멤버변수)
	static String company = "현대자동차";// 클래스 정의에서 저장해놓으면 생성할 때마다 정의할 필요가 없어짐
	private String model;
	
	private int price;
	static int carCount = 0;

	// 2.constructor method(생성자 메서드)...컴파일 시에 정의가 없으면 자동으로 default 생성자가 만들어짐
	// 객체 생성 시 자동으로 호출. new Car(); -> argument 없음
	// 생성자는 생성 시 값 초기화를 목적으로 함
	//매개변수 이름과 멤버변수 이름간의 충돌을 피하기 위해 this. 사용
	Car(String model, int price) {
		// 함수(변수타입 매개변수) : 매개변수는 지역변수
		this.model = model;
		this.price = price;
		carCount++;
		System.out.println(carCount + "번째 자동차가 만들어집니다.");
	}

	Car(String model) {
//		this.mode = mode;
//		this.price = 1000;
		this(model, 1000);

	}

	Car(int price) {
//		this.mode = "이름 없음";
//		this.price = price;
		this("모델명 미정", price);

	}

	// 3.일반 method(기능 구현{}, 문장들의 묶음
	// 반드시 retrun 값 타입을 정의, 없으면 void
	void carInfoPrint(String title) {
		System.out.println(title);
		System.out.println("company:" + company);
		System.out.println("carcount:" + carCount);
		System.out.println("model:" + model);
		System.out.println("price:" + price);
	}

	public static String getCompany() {
		return company;
	}

	public static void setCompany(String company) {
		Car.company = company;
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

	public static int getCarCount() {
		return carCount;
	}

	public static void setCarCount(int carCount) {
		Car.carCount = carCount;
	}

	static void carInfoPrint2(String title) {
		System.out.println(title);
		System.out.println("company:" + company);
		System.out.println("carcount:" + carCount);
		// static method에서는 non-static 사용 뷸가
//		System.out.println("model:"+model);
//		System.out.println("price:"+price);
	}

	// 4.block : 생성자보다 먼저 수행
	{
		System.out.println("----[instatce block, 객체 생성 시마다 수행]----");
	}
	static {
		System.out.println("----[cass load 시 1회 수행]----");
		//class load시 static 변수 로직이 필요한 초기화 시 사용
	}
	
	// 5.inner class
	class Tire{
		//1.field
		String color;
		//2.constructor
		//3.method
		//4.block
		//5.inner class
		
	}
}
