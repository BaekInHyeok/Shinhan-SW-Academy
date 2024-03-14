package com.shinhan.day03;

import java.util.Arrays;

//실행 순서
//1. >java ArrayTest
//2. JVM이 class load(byte code가 method 영역으로 들어감)
//3. 검증
//4. main 시작
public class ArrayTest {

	//명령행 매개변수(argument)
	//2개 입력받아서 사칙 연산 수행
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int su1=Integer.parseInt(args[0]);
			int su2=Integer.parseInt(args[1]);
			
			System.out.println(su1+su2);
			System.out.println(su1-su2);
			System.out.println(su1*su2);
			System.out.println(su1/su2);
			System.out.println(su1%su2);
		}catch(ArrayIndexOutOfBoundsException aa) {
			aa.printStackTrace();
			
		}
		
		System.out.println("--------------------");
		
		System.out.println(args.length+"개");
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[1]);//ArrayIndexOutOfBoundsException
		
		
//		call();
//		call2();
//		call3();
//		call4();
//		call5();
//		call6();
//		call7();
//		call8();
//		call9();
//		method1();
//		method2();

	}

	private static void method2() {
		// TODO Auto-generated method stub
		int[] arr = new int[] {10,20,30};
		String[] arr2 = {"자바","DB","WEB"};
		
		System.out.println("====일반 for문====");
		for(int i=0;i<arr.length;i++){
			System.out.println(i+"번째 값은 "+arr[i]);
		}
		
		System.out.println("====향상(확장) for문====");
		for(int data : arr) {
			System.out.println(data);
		}
		
		for(String data : arr2) {
			System.out.println(data);
		}
		

	}

	private static void method1() {
		// TODO Auto-generated method stub
		int[] arr = new int[] {10,20,30};
		int[] arr2=arr;//주소 복사;
		int[] arr3=new int[arr.length];
		
		System.arraycopy(arr, 0, arr3, 0, 0);//값 복사, 다른 주소임
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));

		
	}

	private static void call9() {
		// TODO Auto-generated method stub
		String[][] arr = new String[3][];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=new String[] {"자바","DB"};
			
			for(int j=0;j<arr[i].length;j++) {
				System.out.println(arr[i][j]);
				
			}
		}
	}

	private static void call8() {
		//배열 선언+생성+초기화
		String[] arr = new String[] {"자바","DB","WEB","Framework"};
		String[] arr2= new String[4];//null로 초기화
		
		arr2[0]="자바";
		arr2[1]="DB";
		arr2[2]="WEB";
		arr2[3]="Framework";
		
		arr[0]+="";
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+"---"+arr2[i]+"---"+
					(arr[i]==arr2[i]?"같다":"다르다"));
			
			System.out.println(arr[i]==arr2[i]?"동일주소":"다른주소");
			System.out.println(arr[i].equals(arr2[i])?"동일값":"다른값");
		}	
		
	}

	private static void call7() {
		int total=0;
		int[][] scores=new int[][] {{10,20,30,40},{1,2,3}};
		for(int i=0;i<scores.length;i++) {
			for(int j=0;j<scores[i].length;j++) {
				total +=scores[i][j];
				System.out.printf("[%d][%d]=>%d", i,j,scores[i][j]);
			}
		}
	}

	private static void call6() {
		char[][] arr= {{'A','B','C'},{'가','나'},{'a','b','c','d'}};
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.println(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

	private static void call5() {
		// 2차원 배열
		// 1.배열 선언
		int[][] arr;
		int[] arr2[];
		int arr3[][];
		//선언+생성+초기화
		int[][] arr4 = new int[][] {{99,98},{77,66,55}};

		// 2.배열 생성
		arr = new int[3][4];
		arr2 = new int[3][];
		//생성+초기화
		arr3 = new int[][] {{10,20,30},{40,50},{60,70,80},{90}};

		
		// 3.배열 사용
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		
		System.out.println(arr4[0][1]);
		System.out.println(arr3[2][2]);
	}

	private static void call4() {
		// 1.배열선연
		// 2.배열생성+3.배열 초기화
		int[] arr;
		arr = new int[] { 10, 20, 30, 40, 50 };// 자동 생성 안됨

		System.out.println(arr.length);
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call3() {
		// 1.배열선연+2.배열생성+3.배열 초기화
		int[] arr = { 10, 20, 30, 40, 50 };// 생성(new int[]) 생략 가능, 자동생성
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call2() {
		// 1.배열선연+2.배열생성
		int[] arr = new int[10];
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call() {
		// 변수 : 하나의 값을 저장하기 위한 기억장소의 이름
		// 같은 타입의 값을 여러 개 저장하고자 한다면? >> 하나의 이름으로 연속 공간을 index로 참조한다.
		// index는 무조건 0부터 시작한다.

		// 1.배열선언
		int[] arr1;
		double arr2[];
		boolean arr3[];
		char[] arr4;
		String[] arr5;
		// 2.배열생성... 반드시 개수를 알아야 한다. >> 자동으로 초기화
		// 정수->0, 실수->0.0, boolean->false, char->' ', 참조형->null
		arr1 = new int[10];
		arr2 = new double[10];
		arr3 = new boolean[10];
		arr4 = new char[10];
		arr5 = new String[5];
		// 3.배열사용

		System.out.println(arr1[0]);

	}

}
