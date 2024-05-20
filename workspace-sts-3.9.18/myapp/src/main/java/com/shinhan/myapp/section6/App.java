package com.shinhan.myapp.section6;

import java.util.List;

import org.firstzone.section6.CompanyVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shinhan.myapp.section8.PhoneDTO;

public class App {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("di6.xml");

		CompanyVO a = ctx.getBean("companyVO", CompanyVO.class);
		System.out.println(a);
		
		PhoneDTO b = ctx.getBean("myPhone1",PhoneDTO.class);
		System.out.println("section8:"+b);
		
		org.firstzone.section6.PhoneDTO c = ctx.getBean("myPhone2",org.firstzone.section6.PhoneDTO.class);
		System.out.println("org.*.section6:"+c);
		
		BoardService service = ctx.getBean("bService",BoardService.class);
		
		List<BoardDTO> blist = service.selectAll();
		
		blist.stream().forEach(board->System.out.println(board));
	}
}
