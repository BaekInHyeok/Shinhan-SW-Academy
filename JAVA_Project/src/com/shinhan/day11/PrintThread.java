package com.shinhan.day11;

import java.beans.IntrospectionException;

public class PrintThread extends Thread{

	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	//조건문을 이용한 쓰레드 종료
	public void run2() {
		while(!stop) {
			System.out.println("실행중...");
		}
		
		System.out.println("리소스 정리");
		System.out.println("정상적으로 쓰레드 종료");
	}
	
	//interrupt()문 활용
	public void run() {
		try {
		while(true) {
			System.out.println("실행중...");
			sleep(1);
		}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("리소스 정리");
		System.out.println("정상적으로 쓰레드 종료");
	}
	
	
	
	
	
}
