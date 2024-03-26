package com.shinhan.day10.thread;

//process : 실행 중인 하나의 프로그램
//thread : 하나의 process 내의 프로그램의 흐름
//Thread class를 이용하면 MultiThread 프로그램이 가능
public class MultilThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Thread.currentThread().getName() + ":thread 시작");

		// 1)구현 class
		// 3)Thread t1 = new UppercaseThread();//자식은 부모에 담을 수 있다.

		// Runnable Interface를 구현(implements Runnable)
		Thread t1 = new Thread(new UppercaseThread());// new Thread(new runnable interface)

		// 2)익명 구현 class
		Thread t2 = new Thread() {
			// 2.영문자 소문자 출력
			@Override
			public void run() {
				for (char i = 'a'; i <= 'z'; i++) {
					System.out.println(Thread.currentThread().getName() + "t2 i=" + i);
				}
			}
		};

		// 4)interface를 익명 구현 class로 만들기
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (char i = 'a'; i <= 'z'; i++) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "t3 i=" + i);
				}
			}
		});

		// 5)람다 표현식
		Thread t4 = new Thread(() -> {
			for (int i = 1; i <= 26; i++) {
				System.out.println(Thread.currentThread().getName() + "t4 i=" + i);
			}
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		// 아래처럼 하면 시작 >> main >> t1 >> main >> t2 >> main >> 끝(멀티쓰레드 아님)
//		t1.run();
//		t2.run();

		// 메인 thread에서 수행
		// 3.숫자 1~26 출력
		for (int i = 1; i <= 26; i++) {
			System.out.println(Thread.currentThread().getName() + "main i=" + i);
		}

		System.out.println(Thread.currentThread().getName() + ":thread 끝");

	}

}
