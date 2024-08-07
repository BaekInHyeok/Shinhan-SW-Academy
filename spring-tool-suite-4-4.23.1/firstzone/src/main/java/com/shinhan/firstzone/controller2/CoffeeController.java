package com.shinhan.firstzone.controller2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shinhan.firstzone.repository3.FreeBoardRepository;
import com.shinhan.firstzone.vo2.MemberEntity;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


//@RestController //@Controller + @ResponseBody
@Controller //요청하면 Page가 forward, 다른 요청으로 Redirect
@RequestMapping("/coffee")
@RequiredArgsConstructor
public class CoffeeController {

	final FreeBoardRepository boardRepo;
	
	@GetMapping("/layout1")
	String f6() {
		return "layout/layout1";
	}
	@GetMapping("/exlayout1")
	String f5() {
		return "layout/exLayout1";
	}
	
	
	@GetMapping("/detail")
	void f4(Long bno, Model model) {
		model.addAttribute("board",boardRepo.findById(bno).get());
	}
	
	@GetMapping("/list")
	void f3(@RequestParam("keyword") String keyword, Model model, HttpSession session) {
		System.out.println("keyword:"+keyword);
		model.addAttribute("blist",boardRepo.findAll());
		MemberEntity member = MemberEntity.builder()
				.mid("abc")
				.mname("찐")
				.build();
		session.setAttribute("loginUser", member);
	}
	
	@GetMapping("/page2")
	public String f2() {
		return "coffee/page1";
	}
	
	@GetMapping("/page1")
	public void f1(Model model) {
	
		model.addAttribute("menu","아메리카노");
		MemberEntity member = MemberEntity.builder()
				.mid("abc")
				.mname("찐")
				.build();
		model.addAttribute("member",member);
	}
}
