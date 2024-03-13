package com.shinhan.day02;

public class OperraterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
		method2();
		method3();
		method4();
		method5();
		method6();
		method7();

	}

	private static void method7() {
		// TODO Auto-generated method stub
		int var1=100;
		int var2=100;
		
		//비교 연산자는 논리 연산자보다 우선순위가 높음
		//&&는 앞이 거짓이면 뒤를 수행하지 않음
		//&는 앞의 결과와 무관하게 모두 수행
		//||는 앞의 결과가 참이면 뒤를 수행 안함
		//|는 앞의 결과와 무관하게 모두 수행
		boolean result1 = var1>var2 && ++var1 < 100;
		boolean result2 = var1>var2 & ++var1 < 100;
		boolean result3 = var1>=var2 || ++var1 < 100;

		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(var1);
	}

	private static void method6() {
		// TODO Auto-generated method stub
		int var1=100;
		int var2=100;
		
		String str1="자바";// 컴파일 시점에 할당
		String str2="자바";// 컴파일 시점에 할당
		//>>str1과 str2의 주소가 같은 상태
		
		String str3=new String("자바");//기본형은 값을 비교
		String str4=new String("자바");
		
		
		//문자열은 값 변경 불가 >> 주소가 달라지는 것(str1과 str2의 주소가 서로 달라진다.
		str1=str1+"프로그램";//>>str+="프로그램"
		str2=str2+"프로그램";
		
		System.out.println(var1==var2);
		System.out.println(str1==str2);//객체는 주소비교(true)
		System.out.println(str3==str4);//객체는 주소비교(false)
		
		System.out.println(str3.equals(str4));//내용비교(true)
		
		
		
		/*주소 확인*/
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));

	}

	private static void method5() {
		// TODO Auto-generated method stub
		int i =100;
		int j=0;
		//정수는 0으로 나눌 수 없음
		//프로그램 중간을 막으려면?
		//1.0이면 수행 안하게 만들기
		//2.Exception 처리
		
		if(j!=0) {
			System.out.println(i/j);
		}
		
		System.out.println(j!=0?100/j:"");
		System.out.println(j==0?"0으로 불가":"나누기 기능");
		
		System.out.println(100/0.0);//>>Infinity(무한대)
		System.out.println(100%0.0);//>>NaN(Not a Number)

		
		System.out.println(100/0);//>>프로그램이 중단됨(Exception 발생)
	}

	private static void method4() {
		// TODO Auto-generated method stub
		int apple=1;
		double pieceUnit = 0.1;
		int number=7;
		double result = apple - pieceUnit*number;
		
		System.out.println(result);
	}

	private static void method3() {
		// TODO Auto-generated method stub
		int a = Integer.MAX_VALUE;//2147483647
		int b = Integer.MIN_VALUE;//-2147483647
		
		a++;
		a++;
		a++;
		
		b--;
		b--;
		b--;
		
		System.out.println(a);//Overflow 발생
		System.out.println(b);//Underflow 발생
	}

	private static void method2() {
		// TODO Auto-generated method stub
		int a=10;
		int b=3;
		
		System.out.println("합:"+(a+b));
		System.out.println("차:"+(a-b));
		System.out.println("곱:"+a*b);
		System.out.println("몫:"+a/b);
		System.out.println("나머지:"+a%b);


	}

	private static void method1() {
		// TODO Auto-generated method stub
		int var1=100;
		System.out.println(++var1);//++연산 후 출력 >> 101
		System.out.println(var1++);//출력 후 ++연산 >> 101
		System.out.println(var1);//출력 >> 102
		
		var1++;
		++var1;
		
		System.out.println(var1);//104

	}

}
