package com.shinhan.day04;

//class 정의 : Object를 만들기 위한 틀(template)
//Object : class를 이용하여 만든 독립된 실체(instance)
public class Book {

	//1.field(변수, 데이터 저장용, 객체 특징)
	String title;
	int price;
	
	//2.constructor(생성자(메서드)):argument가 없는 기본생성자는 compile 시에 만들어진다.
	//class 이름과 같아야 함.
	//return 불가
	//생성자 추가 가능...>추가하면 컴파일시에 생성자를 만든다.
	
	//OverLoading(이름은 같지만 매개변수 사양이 다름)
	//this : 현재 객쳬
	//매개변수 이름과 field 이름의 충돌이 발생했을 경우 사용(구분을 위함)
	
	//이름은 같지만 모양이 다른 생성자를 호출 : this()
	Book(){
//		System.out.println("default 생성자를 재정의함");
		this(null,0);
	}
	Book(String title, int price){
		//System.out.println("argument 2개를 가진 생성자");
		this.title=title;
		this.price=price;
	}
	Book(String title) {
//		System.out.println("argument 1개를 가진 생성자...title");
//		this.title=title;
		this(title,50000);
	}
	Book(int price) {
//		System.out.println("argument 1개를 가진 생성자...price");
//		this.price=price;
		this("제목모름",price);
	}
	
	//3.method(함수, 기능) : 반드시 return type을 정의한다. return 값이 없으면 void
	void bookInfoPrint() {
		System.out.println("----도서 정보----");
		System.out.println("제목:"+title);
		System.out.println("가격:"+price);	
	}
	
	
	
	@Override
	public String toString() {
		return "Book정보 [title=" + title + ", price=" + price + "]";
	}



	//4.block
	{
		System.out.println("block...object 생성 시마다 수행");
		
	}
	static{
		System.out.println("class load 시 1회 수행");
	}
	//5.inner class
	class AA{
		
	}
	
}
