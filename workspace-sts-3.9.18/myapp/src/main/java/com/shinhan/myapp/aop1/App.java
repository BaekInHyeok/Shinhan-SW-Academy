package com.shinhan.myapp.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop1.xml");
		
		Calculator cal= ctx.getBean("proxyCal",Calculator.class);
		
		cal.add(10,2);
		//cal.divide(10, 3);

	}

}
