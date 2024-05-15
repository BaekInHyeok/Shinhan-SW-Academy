package com.shinhan.myapp.section2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PeopleApp {

	public static void main(String[] args) {
		f3();
	}

	private static void f3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2_1.xml");
		
		//기본적으로 컨테이너에 한 개의 bean 객체를 생성한다(싱글톤)
		PeopleVO p1 = ctx.getBean("people5", PeopleVO.class);
		PeopleVO p2 = ctx.getBean("people5", PeopleVO.class);
		
		System.out.println(p1==p2);//주소비교
		
	}

	private static void f2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2.xml");
		PeopleVO p5 = ctx.getBean("people5", PeopleVO.class);
		System.out.println(p5.getCar());
		
	}

	private static void f1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2.xml");
		PeopleVO p2 = ctx.getBean("people2", PeopleVO.class);
		PeopleVO p3 = ctx.getBean("people3", PeopleVO.class);
		System.out.println(p2);
		System.out.println(p3.name+"==>"+p3.getCar().getModel());
		System.out.println("p2------------------------------------");
		System.out.println(p2.getMajor());
		System.out.println(p2.getLicensList());
		System.out.println(p2.getFriend());
		System.out.println(p2.getMyprofile());
		System.out.println("p3------------------------------------");
		System.out.println(p3.getMajor());
		System.out.println(p3.getLicensList());
		System.out.println(p3.getBookMap());
	}
}
