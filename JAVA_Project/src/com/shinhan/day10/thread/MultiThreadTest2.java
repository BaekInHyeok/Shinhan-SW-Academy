package com.shinhan.day10.thread;

public class MultiThreadTest2 {
	
	public static void main3(String[] args) {
		BathRoom room = new BathRoom();
		BathroomThread t1 = new BathroomThread(room, "김");
		BathroomThread t2 = new BathroomThread(room, "박");
		BathroomThread t3 = new BathroomThread(room, "양");
		
		
		t1.start();
		t2.start();
		t3.start();
	}

	public static void main(String[] args) {
		
		ShareArea shareArea = new ShareArea(new Account("112","이몽룡",2000), new Account("113","성춘향",1000));
		Thread t1 = new TransferThread(shareArea);
		
		Thread t2 = new Thread(new PrintThread(shareArea));
		
		t1.start();
		t2.start();
	}
	public static void main2(String[] args) {
		System.out.println(Thread.currentThread().getName()+"시작");
		
		Thread t1 = new UppercaseThread2();
		Thread t2 = new Thread(new UppercaseThread());//Runnable interface를 thread로 만듦
		Thread t3 = new UppercaseThread2();

		t1.start();
		t2.start();
		t3.start();
		
		System.out.println(Thread.currentThread().getName()+"끝");

	}

}
