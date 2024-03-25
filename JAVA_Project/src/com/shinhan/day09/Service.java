package com.shinhan.day09;

public class Service {

	@PrintAnnotation
	public void method1() {
		System.out.println("method1...");
	}
	
	@PrintAnnotation("*") //>>value에 *이 들어감
	public void method2() {
		System.out.println("method2...");
	}
	@PrintAnnotation(value="#", number=10) //>>value에 *이 들어감
	public void method3() {
		System.out.println("method3...");
	}
	@PrintAnnotation(value="$", number=15, subject1="Python") //>>value에 *이 들어감
	public void method4() {
		System.out.println("method4...");
	}
	@PrintAnnotation(value="&", number=2, subject1="C++", subject2="html5") //>>value에 *이 들어감
	public void method5() {
		System.out.println("method5...");
	}
}
