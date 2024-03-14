package com.shinhan.day03;

import java.util.Scanner;

public class Ch5_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		q6();
		q7();
		q8();
		q9();
	}


	private static void q9() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String order="";
		int sum=0;
		int max=0;
		double avg;
		
		int[] scores = null;
		
		aa :while(true) {
			System.out.println("------------------------------------");
			System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("------------------------------------");
			
			System.out.print("선택>>");
			order=scanner.nextLine();
			
			switch(order) {
			case "1":
				System.out.print("학생수>>");
				order=scanner.nextLine();
				int count=Integer.parseInt(order);
				scores=new int[count];
				break;
				
			case "2":
				//System.out.print("점수입력>>");
				for(int i=0;i<scores.length;i++) {
					System.out.print("scores["+i+"]>");
					order=scanner.nextLine();
					int score=Integer.parseInt(order);
					scores[i]=score;
				}
				
				break;
			case "3":
				for(int i=0;i<scores.length;i++) {
					System.out.printf("scores[%d]:%d",i,scores[i]);
					System.out.println();
				}
				break;
			case "4":
				
				for(int i=0;i<scores.length;i++) {
					sum+=scores[i];
					
					if(max<scores[i])
						max=scores[i];
				}
				
				avg=(double)sum/(double)scores.length;
				System.out.println("최고 점수 : "+max);
				System.out.println("평균 점수 : "+avg);
				
				break;
			case "5":
				System.out.println("프로그램 종료");
				break aa;
			default:
				break;
			}
		
		}
	}


	private static void q8() {
		// TODO Auto-generated method stub
		int[][] array= {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		int total=0;
		int count=0;
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++) {
				total+=array[i][j];
				count++;
			}
		}
		
		double average=(double)total/(double)count;
		
		System.out.println("합:"+total);
		System.out.println("평균:"+average);
	}


	private static void q7() {
		// TODO Auto-generated method stub
		int[] array= {1,5,3,8,2};
		int max=0;
		
		for(int i=0;i<array.length;i++) {
			if(array[i]>max)
				max=array[i];
		}
		
		System.out.println("배열의 최댓값 : "+max);
	}


	private static void q6() {
		// TODO Auto-generated method stub
		int[][]array= {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		System.out.println(array.length);
		System.out.println(array[2].length);
	}
}
