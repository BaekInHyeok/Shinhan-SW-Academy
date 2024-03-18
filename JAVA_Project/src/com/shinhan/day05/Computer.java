package com.shinhan.day05;

/*접근지정자(Modifier)
 * 1.public : 모든 패키지에서 접근 가능. 
 * 2.protected : 같은 패키지에서 접근 가능, 다른 패키지인 경우는 상속받으면 접근 가능
 * 3.생략 : 같은 패키지 내에서 접근 가능
 * 4.private : 같은 클래스 내에서만 접근 가능(정보은닉,캡슐화)
 */
public class Computer {

	private String model;
	protected int price;
	public Computer() {
		System.out.println("default 생성자 정의함");
		
		
	}
	
	public void setModel(String model){
		this.model=model;
	}
}
