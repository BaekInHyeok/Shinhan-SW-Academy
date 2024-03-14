package com.shinhan.day03;

public class ArrayLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//q1();
		q2();

	}

	private static void q2() {
		// TODO Auto-generated method stub
		
		int [][]a = {{30,30,30,30},{40,40,40,40},{50,50,50,50}};
		int [][]b = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int [][]c = new int[3][4];
		
		c=sub(a,b,c);
		prn(c);
	}

	public static void prn(int[][] c) {
		// TODO Auto-generated method stub
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[i].length;j++) {
				System.out.printf("%d\t",c[i][j]);
			}
			System.out.println();
		}
	}

	public static int[][] sub(int[][]a, int[][]b, int[][]c) {
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				c[i][j]=a[i][j]-b[i][j];
			}
		}
		
		return c;
		// TODO Auto-generated method stub
		
	}

	private static void q1() {
		// TODO Auto-generated method stub
		int temp=0;
		int[] arr = {3,24,1,55,17,43,5};
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		for(int data : arr) {
			System.out.print(data+", ");
		}
	}

}
