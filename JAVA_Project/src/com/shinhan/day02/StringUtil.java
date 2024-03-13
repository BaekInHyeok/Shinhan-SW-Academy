package com.shinhan.day02;

public class StringUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hokeyGraphics( '*', 3, true);
		hokeyGraphics( '&', 4, false);

	}

	public static void hokeyGraphics(char cell, int size, boolean isRect) {
		// TODO Auto-generated method stub
		
		if(isRect) {
			for(int row=1;row<=size;row++) {
				for(int col=1;col<=size;col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
			
		}else {
			for(int row=1;row<=size;row++) {
				for(int col=1;col<=row;col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		}
		
	}

}
