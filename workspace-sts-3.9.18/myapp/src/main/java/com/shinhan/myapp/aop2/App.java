package com.shinhan.myapp.aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop2.xml");
		Calculator cal= ctx.getBean("cal",Calculator.class);
		
		cal.add(10);
		
		
		BoardService service = ctx.getBean("bService2",BoardService.class);
		service.selectAll().stream().forEach(board->System.out.println(board));

	}

}
