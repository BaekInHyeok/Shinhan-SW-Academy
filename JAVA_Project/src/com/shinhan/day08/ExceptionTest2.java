package com.shinhan.day08;

import javax.management.RuntimeErrorException;

public class ExceptionTest2 {

	public static void main(String[] args) {
		method9(71);
	}

	private static void method9(int score) {
		try {
			if (score <= 70)
				throw new ScoreException("70 초과만 가능");

			double avg = score / 3;
			System.out.println("결과:"+avg);
		} catch (ScoreException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void method8(String[] args) {
		try {
			method1(70);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*************");

	}

	private static void method1(int score) throws Exception {

		// 조건에 맞지 않으면 강제로 예외를 발생시키려 한다
//		if(score>=70) throw new RuntimeException();
//		System.out.println("--------------");

//		try{
//			if(score>=70) throw new Exception("오류!!!!");
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("--------------");

		if (score <= 70)
			throw new Exception();
		System.out.println("--------------");

	}

}
