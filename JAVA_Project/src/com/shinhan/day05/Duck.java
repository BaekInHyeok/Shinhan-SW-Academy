package com.shinhan.day05;

public class Duck {

	private String name;
	private int legs;
	private int length;
	
	Duck(){
		
	}
	
	public Duck(String name, int legs, int length) {
		this.name=name;
		this.legs=legs;
		this.length=length;
	}
	
	public Duck(int legs, int length) {
		this.legs=legs;
		this.length=length;
	}
	
	void fly() {
		System.out.println("오리 ("+this.name+")는 날지 않습니다.");
	}
	void sing() {
		System.out.println("오리 ("+this.name+")가 소리 내어 웁니다.");
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@Override
	public String toString() {
		return "오리의 이름은 "+this.name+"입니다. 다리는 "+this.legs+"개이고, 길이는 "+this.length+"입니다.";
	}
	
}
