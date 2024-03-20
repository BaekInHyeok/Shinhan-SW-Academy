package com.shinhan.day07;

public class SmartTelevision implements RemoteController, Searchable{

	@Override
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.println("Smart Television search");
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("Smart Television method1()");
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("Smart Television method2()");
		
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Smart Television Turn On");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Smart Television Turn Off");
		
	}

}
