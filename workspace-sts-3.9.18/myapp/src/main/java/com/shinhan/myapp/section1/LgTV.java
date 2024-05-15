package com.shinhan.myapp.section1;

public class LgTV implements TV {
	
	public LgTV() {
		System.out.println("LGTV 생성자");
	}
	public void powerOn() {
		System.out.println("****LG**PowerOn****");
		System.out.println(getClass().getSimpleName()+"전원을 켠다");
	}
	
	public void powerOff() {
		System.out.println("****LG**PowerOff****");
		System.out.println(getClass().getSimpleName()+"전원을 끈다");
	}
}
