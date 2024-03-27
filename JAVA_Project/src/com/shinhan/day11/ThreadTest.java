package com.shinhan.day11;

import java.lang.reflect.Executable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.shinhan.day10.thread.BathRoom;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// f1();
		// f2();
//		f3();
//		f4();
		//f5();
		f6();
		f7();

		System.out.println("Main End");
	}

	private static void f7() {
		BathRoom room = new BathRoom();
		
		
	}

	private static void f6() {
	
	Thread thread1=new MovieThread();
	thread1.start();
	Thread thread2 = new Thread();
	thread2.start();
	}

	private static void f5() {
		ExecutorService service = Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 100; i++) {
			int end = i;
			Future<Integer> result = service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int j = 1; j < end; j++) {
						sum += j;
					}
					System.out.println(Thread.currentThread().getName() + end + "까지의 합 >> " + sum);
					return sum;
				}
			});

			try {
				Integer a = result.get();
				System.out.println("a:" + a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.shutdown();

	}

	private static void f4() {
		// TODO Auto-generated method stub
		final String s = "JAVA";
		int score = 100;
		class LocalClass {
			void method1() {
				// s+="프로그램"; >>메서드 내부 클래스에서는 변경 불가

				// System.out.println(score);
				System.out.println(s);
			}
		}

		score = 200;

		Runnable r = new Runnable() {

			@Override
			public void run() {

				// System.out.println(score); >> 값이 변경된 변수는 내부 메서드에서 사용 불가
				System.out.println(s);
			}
		};
	}

	private static void f3() {
		// TODO Auto-generated method stub
		String[][] mails = new String[1000][3];
		int i = 1;
		for (String[] arr : mails) {
			arr[0] = "admin@my.com";
			arr[1] = "member" + i + "@my.com";
			arr[2] = "신상품 입고됨";

			i++;
		}

		// MulthiThread(5개)로 1000명에게 이메일 보내기
		ExecutorService service = Executors.newFixedThreadPool(5);// Thread 개수를 5개로 제한하는 풀 생성

		// 내부 클래스에서 지역변수를 쓰고 있음(지역변수는 무조건 final이다.)
		for (int index = 0; index < 1000; index++) {
			int seq = index;// 값 복사
			// 익명 구현 class
			service.execute(new Runnable() {
				@Override
				public void run() {
					String message = "Thread 이름:" + Thread.currentThread().getName() + "\n from " + mails[seq][0]
							+ "\n To:" + mails[seq][1] + "\n 내용:" + mails[seq][2];
					System.out.println(message);
				}
			});
		}

	}

	private static void f2() {
		// TODO Auto-generated method stub
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true);
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f1() {
		// TODO Auto-generated method stub
		PrintThread t1 = new PrintThread();

		t1.start();

		// t1.stop(); >> 비추천

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		t1.setStop(true);
		t1.interrupt();
	}

}
