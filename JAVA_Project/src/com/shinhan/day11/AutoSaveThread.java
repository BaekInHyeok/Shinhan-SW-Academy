package com.shinhan.day11;

//Dmon
//주 쓰레드를 도와주는 쓰레드
//주 쓰레드가 끝나면 같이 끝남
public class AutoSaveThread extends Thread {

	public void save() {
		System.out.println("작업 내용을 저장한다.");
	}
	
	public void run() {
		while(true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			save();
		}
		
		
	}
}
