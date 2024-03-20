package com.shinhan.day07;


//interface를 구현한 구현-class
//추상메서드를 반드시 구현할 의무가 있음
public class Television extends Object implements RemoteController{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName()+" method1()");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName()+" method2()");
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName()+" 전원 On");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName()+" 전원 Off");
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		RemoteController.super.method3();
		System.out.println("default메서드 재정의함");
	}
	
	void method4() {
		RemoteController.method4();
		System.out.println("method4 메서드 추가. 재정의 아님");
	}
	
	

}
