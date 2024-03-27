package com.shinhan.day11;


//Process : 실행 중인 하나의 프로그램
//Thread : 프로그램에서 하나의 흐름
//Multithread : 실행 중인 하나의 프로그램의 흐름이 여러 개

/*
 * 1)Thread class 상속
 * 2)Runnable interface 구현
 * */

class MyThread1 extends Thread{

	String name;
	
	MyThread1(String name){
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(currentThread().getName());
	}
}

class MyThread2 extends Object implements Runnable{

	String name;
	
	MyThread2(String name){
		this.name=name;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+name);
	}
}



public class Review2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		f1();
	}

	private static void f1() {
		// TODO Auto-generated method stub
		MyThread1 t1 = new MyThread1("신한1");
		Thread t2 = new MyThread1("신한2");
		Thread t3 = new Thread("신한3") {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(currentThread().getName());
			}
			
		};
	}

}
