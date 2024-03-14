package com.shinhan.day02;

import java.util.Scanner;

public class Ch4_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//q3();
		//q4();
		//q5();
		//q6();
		q7();

	}

	private static void q7() {
		// TODO Auto-generated method stub
		int select=0;
		int change=0;
		int temp=0;
		int left=0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			
			System.out.print("선택>");
			select=scanner.nextInt();
			
			
			if(select==1) {
				System.out.print("예금액>>");
				change=scanner.nextInt();
				
				//temp=Integer.parseInt(change);
				
				left=left+change;
			}
			else if(select==2) {
				System.out.print("출금액>>");
				change=scanner.nextInt();
				
				//temp=Integer.parseInt(change);
				
				left=left-change;
				
			}
			else if(select==3){
				System.out.print("잔고>>");
				
				System.out.println(left);
			}
			else {
				System.out.println("프로그램 종료");
				break;
			}
			
			
		}
	}

	private static void q6() {
		// TODO Auto-generated method stub
		for(int row=1;row<=5;row++) {
			for(int col=1;col<=row;col++)
				System.out.print("*");
		}
	}

	private static void q5() {
		// TODO Auto-generated method stub
		
		for(int x=1;x<=10;x++) {
			for(int y=1;y<=10;y++) {
				if(4*x+5*y==60) {
					System.out.printf("(%d,%d)",x,y);
					System.out.println();
				}
			}
		}
	}

	private static void q4() {
		// TODO Auto-generated method stub
		int first=0;
		int second=0;
		
		while(first+second!=5) {
			first=(int)(Math.random()*6)+1;
			second=(int)(Math.random()*6)+1;
			
		}
		
		
		System.out.printf("(%d,%d)",first,second);
		
		
	}

	private static void q3() {
		// TODO Auto-generated method stub

		int total = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				total = total + i;
			}
		}
		;
		System.out.println("총합"+total);
	}

}
