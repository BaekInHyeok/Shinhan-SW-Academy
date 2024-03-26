package com.shinhan.day10.thread;

public class TransferThread extends Thread {

	ShareArea shareArea;

	// 초기화
	TransferThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}

	@Override
	public void run() {
		// 12번 계좌이체
		for (int i = 1; i <= 12; i++) {
			//synchronized block : 공유데이터를 하나의 thread가 점유하고 있을 때, 다른 thread가 접근 불가
//			synchronized (shareArea) {
//				int amount = shareArea.lee.withdraw(100);
//				System.out.println("이몽룡 계좌에서 출금");
//				System.out.println("성춘향 계좌로 입금");
//				shareArea.sung.deposit(amount);
//	
//			}
			
			shareArea.transfer();
			
//			try {
//				sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		}

	}

}
