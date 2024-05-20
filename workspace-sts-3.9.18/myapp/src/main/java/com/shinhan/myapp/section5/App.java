package com.shinhan.myapp.section5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di5.xml");
		
		ComputerVO c1 = ctx.getBean("c1",ComputerVO.class);
		System.out.println(c1);
		
		CompanyVO comp1 = ctx.getBean("company",CompanyVO.class);
		System.out.println(comp1);
	}
}
