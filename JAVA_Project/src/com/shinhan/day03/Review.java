package com.shinhan.day03;

public class Review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		call(100);
		call2(55);
		call3(10);
		call4(20);
		call5(30);
	}
	private static void call5(int a) {
		// TODO Auto-generated method stub
		int total=0;
		int i=1;
		do {
			total+=i++;
			
		}while(i<=a);
	}
	private static void call4(int a) {
		// TODO Auto-generated method stub
		//반복문 while : 1~a까지의 합계
		int total=0;
		int i=1;
		while(i<=a) {
			total+=i+1;
			
		}
		
		
	}
	private static void call3(int a) {
		// TODO Auto-generated method stub
		
		//반복문 for:1~a까지의 합계
		int total=0;
		
		for(int i=1;i<=a;i++) {
			total=total+i;
		}
		
	}
	private static void call2(int a) {
		// TODO Auto-generated method stub
		
		//조건문 switch
		switch(a%2) {
		case 0:System.out.println(a+":짝수");
		case 1:System.out.println(a+":홀수");
		}
		
	}
	//반복사용을 위해 메서드를 만든다
	private static void call(int a) {
		// TODO Auto-generated method stub
		//조건문 if
		if(a%2==0)
			System.out.println("짝수");
		else
			System.out.println("홀수");
		
		System.out.println(a%2==0?a+"짝수":a+"홀수");
		
	}

}
