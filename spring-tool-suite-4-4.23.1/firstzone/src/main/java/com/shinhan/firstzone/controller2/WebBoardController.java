package com.shinhan.firstzone.controller2;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shinhan.firstzone.paging.PageRequestDTO;
import com.shinhan.firstzone.security.MemberService;
import com.shinhan.firstzone.service2.WebBoardService;
import com.shinhan.firstzone.vo2.MemberEntity;
import com.shinhan.firstzone.vo4.WebBoardDTO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

//@Controller : 요청->서비스수행->data, page가 리턴(page는 Thymeleaf template를 사용중)
//@RestController : 요청->서비스수행->data 리턴(ReactJS에서 사용 예정) 
@Controller
@RequestMapping("/webboard")
@RequiredArgsConstructor
@Log4j2

public class WebBoardController {

	final WebBoardService boardService;
	
	final MemberService memService;
	
	@GetMapping("/register")
	void registerForm() {
		//forword:template/webboard/register.html
	}
	
	@PostMapping("/register")
	String register(WebBoardDTO dto, RedirectAttributes attr, Principal principal, Authentication authentication, HttpSession session) {
		
		System.out.println("방법1 principal : "+ principal);
		Object principal2 = authentication.getPrincipal();
		System.out.println("방법 2 authentication : "+principal2);
		
		Object principal3 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("방법 3 authentication : "+principal3);
		
		UserDetails userDetails = (UserDetails) principal3;
		System.out.println("userDetails : "+userDetails);
		
		//****로그인한 멤버 ID가 board의 멤버 ID로 입력한다.
		String mid = principal.getName();
		UserDetails userDetails2 = memService.loadUserByUsername(mid);
		System.out.println("방법 4 loadUserByUsername : "+ userDetails2);
		
		MemberEntity loginUser = (MemberEntity)session.getAttribute("user");
		System.out.println("방법 5 session에서 읽기 : "+loginUser);
		
		dto.setMid(mid);
		
		log.info("입력 before:"+dto);
		Long bno = boardService.register(dto);
		log.info(bno+"번 게시글 등록됨");
		attr.addFlashAttribute("msg","입력완료");
		return "redirect:list";
	}
	
	@GetMapping("/list")
	String getList(Model model, PageRequestDTO pageRequestDTO) {
		//List<WebBoardDTO> blist = boardService.getList();
		//model.addAttribute("blist",blist);
		if(pageRequestDTO.getSize()==0) {
			pageRequestDTO.setPage(1);
			pageRequestDTO.setSize(10);
			//pageRequestDTO.setType("ctw");
			//pageRequestDTO.setKeyword("user2");
			
		}
		System.out.println(pageRequestDTO);
		model.addAttribute("result",boardService.getList(pageRequestDTO));
		model.addAttribute("pageRequestDTO",pageRequestDTO);
		return "webboard/boardlist";
	}
	
	@GetMapping("/detail")
	void detail(Long bno, Model model) {
		model.addAttribute("board",boardService.selectById(bno));
		//return "webboard/detail";
	}
	
	@PostMapping("/modify")
	String modify(WebBoardDTO dto, RedirectAttributes attr) {
		boardService.modify(dto);
		attr.addFlashAttribute("msg","입력완료");
		return "redirect:list";
	}
	
	@PostMapping("/delete")
	String delete(Long bno, RedirectAttributes attr) {
		boardService.delete(bno);
		attr.addFlashAttribute("msg","입력완료");
		return "redirect:list";
	}
}
