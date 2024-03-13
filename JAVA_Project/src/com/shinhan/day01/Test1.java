package com.shinhan.day01;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		
		int m=0;
		int a=0;
		int left=0;
		
		ArrayList<Integer> arraylist = new ArrayList<Integer>();//입출금 내역을 저장하는 동적 배열
		
		/*마이너스 통장 한도 금액 입력*/
		System.out.print("한도 금액을 입력하십시오>>");
		m=scanner.nextInt();
		
		
		/*입출금내역 입력, q를 입력하고 Enter 시 입력 종료*/
		System.out.println("입출금 요청 내역을 입력하십시오");
		System.out.print("q를 입력하면 입력이 종료됩니다>>");
		
		while(true) {
			String work=scanner.next();
			if(work.equals("q"))
				break;
			
			a=Integer.parseInt(work);
			arraylist.add(a);
		}
		
		/*입출금 처리*/
		
//		for(int st:arraylist) {
//			System.out.println(st);
//		}
		
		int count = arraylist.size();
		int limit = 0-m;
		
		for(int i=0;i<count;i++) {
			int temp = left + arraylist.get(i);
			//System.out.println("임시 계산 결과값:"+temp);
			
			if(temp>=limit){
				left=temp;
			}
			System.out.println("통장 잔고:"+left);
		}
		
		System.out.println();
		System.out.println("최종결과 : "+left);//최종 결과값 출력
		
	}

}
