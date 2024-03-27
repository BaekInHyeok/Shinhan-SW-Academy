package com.shinhan.day11;

public class MovieThread extends Thread{

	@Override
	public void run() {
		try {
		while(true) {
			System.out.println("동영상 재생");
			//다른 방법:if(this.interrupted())break;
			sleep(1);
		}
		}catch(InterruptedException e) {}
		
		System.out.println("자원정리");
		System.out.println("안전종료");
	}

	
}
