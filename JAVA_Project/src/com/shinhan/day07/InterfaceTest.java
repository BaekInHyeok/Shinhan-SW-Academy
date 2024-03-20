package com.shinhan.day07;

interface AInterface{
	public abstract void method1();
}

interface BInterface extends AInterface{
	void method2();
}
class MyClass implements BInterface{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
	
}

public class InterfaceTest {

	public static void main(String[] args) {
		MyClass a = new MyClass();
		
		a.method1();
		a.method2();
	}
	
}
