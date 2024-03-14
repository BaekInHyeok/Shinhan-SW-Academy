package com.shinhan.day03;

public class ArrayLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q1();
		//q2(); //2번 문제는 Spliting.java로

	}

	private static void q1() {
		// TODO Auto-generated method stub
		System.out.println("문자열에 특정문자 변경하는 테스");
		System.out.println("-------------Sample 1 --------------");
		String str1=myReplace("hello world",'l','*');
		System.out.println(str1);
		
		System.out.println("-------------Sample 2 --------------");
		String str2=myReplace("hello world",' ','-');
		System.out.println(str2);
		
		System.out.println("-------------Sample 3 --------------");
		String str3=myReplace("hello world",'a','*');
		System.out.println(str3);

	}

	private static String myReplace(String str, char oldChar, char newChar) {
		// TODO Auto-generated method stub
		String newstr="";
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==oldChar) {
				newstr=newstr+newChar;
			}
			else {
				newstr=newstr+str.charAt(i);
			}
		}
		return newstr;
		
	}

}
