package com.shinhan.day01;


//JVM이 String변환 class의 main() 메서드 호출을 위해 접근 권한이 public이다.

public class String변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
		f2();
		f3();
		f4();

	}

	private static void f4() {
		// TODO Auto-generated method stub
		int a=100;
		{
			int b=200;
			System.out.println(a+b);
		}
		
		if(a>=100){
			int b=300;
			System.out.println(a+b);
		}
		System.out.println("3."+a);
		//System.out.println(a+b);//여기에서는 b를 쓸 수 없다
		
		
	}

	private static void f3() {
		// TODO Auto-generated method stub
		int a=100;
		String s1=String.valueOf(a);
		String s2=a+"";//메모리 낭비의 단점
		
		System.out.println(s1);
		System.out.println(s2);

	}

	private static void f2() {
		// TODO Auto-generated method stub
		String score="100";
		
		//String에서 +는 연결을 의미한다
		System.out.println(score+200);//문자
		System.out.println(1+2+score);//3+100 문자
		System.out.println(10-2+score);
	}

	private static void f1() {
		// TODO Auto-generated method stub
		String score="100";
		
		byte a = Byte.parseByte(score);
		short b= Short.parseShort(score);
		int c = Integer.parseInt(score);
		long d = Long.parseLong(score);
		float e = Float.parseFloat(score);
		double f = Double.parseDouble(score);
		
		System.out.println(a+b+c+d+e+f);
		
		
	}

}
