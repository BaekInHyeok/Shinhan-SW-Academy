package com.shinhan.day02;

public class Ch4_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q3();
		q4();
		q5();
		q6();
		q7();

	}

	private static void q5() {
		// TODO Auto-generated method stub
		
		for(int x=1;x<=10;x++) {
			for(int y=1;y<=10;y++) {
				if(4*x+5*y==60) {
					
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
