package com.shinhan.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.myapp.model.BoardDTO;
import com.shinhan.myapp.model.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService bService;

	@RequestMapping("/selectAll.do")
	public String test1(Model model) {
		System.out.println("/board/selectAll.do 요청");
		List<BoardDTO> blist = bService.selectAll();
		model.addAttribute("blist", blist);
		return "board/boardlist";
	}

	@GetMapping("/boardinsert.do")
	public void test2() {

	}

	@PostMapping("/boardInsert.do")
	// public String test3(String title, String content, String pic ) {
	public String test3(BoardDTO board) {
		/*
		 * System.out.println(title); System.out.println(content);
		 * System.out.println(pic);
		 */
		
		//BoardDTO board = new BoardDTO();
		//board.settile(request.getParameter("title"))
		System.out.println(board);
	
		//BoardDTO board = new BoardDTO(0, title, content, "작성자", pic, null);

		bService.insertBoard(board);

		// forward:요청을 위임(다른 요청으로 감)
		// redirect:재요청
		return "redirect:selectAll.do";
	}
	
	//상세보기
	@GetMapping("/boardDetail.do")
	public String detail(Integer bno, Model model) {
		model.addAttribute("board", bService.selectById(bno));
		
		return "/board/boarddetail";
	}
	
	@PostMapping("/boardDetail.do")
	public String update(BoardDTO board) {
		bService.updateBoard(board);
		return "redirect:selectAll.do";
	}
	
	//@RequestMapping(value="/boardDelete.do", method=RequstMethod.GET)
	@GetMapping("/boardDelete.do")
	public String delete(Integer bno) {
		bService.deleteBoard(bno);
		
		return "redirect:selectAll.do";
	}
}
