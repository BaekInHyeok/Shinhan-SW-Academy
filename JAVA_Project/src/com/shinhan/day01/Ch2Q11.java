package com.shinhan.day01;

public class Ch2Q11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//method 내에 있는 변수는 지역변수
		//변수 scope : {} 내에서만 유효
		{
			int score = 100;
			System.out.println(score);
		}
		
		
		int v1=1;
		System.out.println("v1:"+v1);
		if(true) {
			int v2=2;
			if(true) {
				int v3=2;
				System.out.println("v1:"+v1);
				System.out.println("v2:"+v2);
				System.out.println("v3:"+v3);
			}
			System.out.println("v1:"+v1);
			System.out.println("v2:"+v2);
			//System.out.println("v3:"+v3);
		}
		
		System.out.println("v1:"+v1);
		//System.out.println("v2:"+v2);

	}

}
