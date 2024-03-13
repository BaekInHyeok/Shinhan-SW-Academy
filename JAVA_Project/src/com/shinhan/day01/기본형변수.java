package com.shinhan.day01;

public class 기본형변수 {
	
	public static void main(String[] args) {
		String str1 = "이것이\n \"자바\"다";
		System.out.println(str1);
		
		String str2 = "aaaaaaaaaaaaaaa"
				+"bbbbbbbbbbbbbb"
				+"ccccccccccccccc";
		System.out.println(str2);
		
		String str3="""
				json 타입의 값을 저장할 때 유용하다.
				{
				"키":"값",
				"키":"값",
				"키":"값",
				"키":"값",
				"키":"값",
				"키":"값",
				}
				""";
		
		System.out.println(str3);
	}
	
	
	public static void f10(String[] args) {
		//데이터타입(데이터의 성격)
		//1. 기본형(8가지) : 메모리값이 직접 저장됨, 값을 저장, 연산, 비교
		//2. 객체 참조형(기본형을 제외한 전부) : 객체 생성 후 해당 객체의 주소값이 저장됨, 기능을 가진다.
		//Wrapper class : 기본형(8가지) + 기능
		//byte + 기능 = Byte
		//short + 기능 = Short
		//char + 기능 = Character
		//int + 기능 = Integer
		//long + 기능 = Long
		//float + 기능=Float
		//double + 기능=Double
		//boolean + 기능=Boolean
		
		Integer score=65;
		double d=score.doubleValue();
		System.out.println("double바꿈 :"+d);
		System.out.println(Integer.toBinaryString(score));
		
	}
	
	
	public static void f9(String[] args) {
		//문자열 저장 -> String class 사용
		//1.객체 참조 변수 선언
		String str1, str2, str3, str4;
		//2.객체 생성
		//str1=new String("자바 언어의 문법 배우기");
		str1="자바언어의 문법 배우기"; //->컴파일 타임에 저장된다.(메모리에 저장하는 주소 생김)
		str2="자바언어의 문법 배우기"; //->이미 저장된 값을 사용한다.(str1과 같은 주소를 사용
		str3= new String("자바언어의 문법 배우기");//->실행 시 생성됨
		str4= new String("자바언어의 문법 배우기");//->실행 시 생성됨
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		System.out.println(str1==str4);//->주소 비교 : 다르다
		System.out.println(str1.equals(str4));//->내용 비교 : 같다
	}
	
	public static void f8(String[] args) {
		boolean var1=true;
		boolean var2=false;
		
		boolean var3=20>10;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
	}
	
	public static void f7(String[] args) {
		double var1=3.14;
		System.out.println(var1);
	}
	
	public static void f6(String[] args) {
		//실수의 기본값은 double(8byte)
		
		float var1 = 3.14f;//F도 가능
		System.out.println(var1);
	}
	
	public static void f5(String[] args) {
		//정수의 기본은 int로 설정되어 있다.
		long var1=2147483648L;//l을 써도 가능하다
		var1++;
		System.out.println(var1);
	}
	
	public static void f4(String[] args) {
		int var1=Integer.MAX_VALUE;
		int var2=2147483647;
		
		System.out.println("var1="+var1);
		System.out.println("var2="+var2);

	}
	
	public static void f3(String[] args) {
		char a='A';	//0~2767*2
		char b=65;
		char c=0x0041;
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);

	}

	public static void f1(String[] args) {
		// TODO Auto-generated method stub
		byte a;
		a=102;
		
		a++; a++;
		
		System.out.println(a);

	}
	
	public static void f2(String[] args) {
		// TODO Auto-generated method stub
		short a;
		a=102;
		
		a++; a++;
		
		System.out.println(a);

	}

}
