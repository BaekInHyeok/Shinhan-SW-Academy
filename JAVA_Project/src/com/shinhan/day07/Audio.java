package com.shinhan.day07;

public class Audio implements RemoteController {

	int a = 100;
	static int b = 200;

	public Audio() {
		System.out.println("Audio default 생성자");
	}
	
	void show() {
		System.out.println("Audio show 메서드");
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("Audio method1() 구현");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("Audio method2() 구현");

	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Audio  전원 On");

	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Audio  전원 Off");

	}

}
