package com.shinhan.myapp.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.dept.DepDTO;
import org.firstzone.myapp.dept.DepService;
import org.firstzone.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	DepService dService;

	@Autowired
	EmpService eService;

	@GetMapping("/deptList.do")
	public void retrieve(Model model, HttpServletRequest request) {

		String result="";
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			result = (String)flashMap.get("deptResult");
			System.out.println(result);
		}
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("deptResult", result);
		
		// return "dept/deptList.do"; >> return이 void인 경우 다음과 같음
		// forward된다. /WEB-INF/views/dept/deptList.jsp
	}

	@GetMapping("/deptInsert.do")
	public ModelAndView insertView() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("mlist", eService.selectAllManager());
		mv.setViewName("dept/deptInsert");

		// redirect가 없으면 default로 forward된다. 즉, 요청의 주소는 그대로이고 보여지는 page는 jsp이다.
		// request.getRequestDispatcher("페이지이름").forward(request,response);

		// redirect가 있다면 재요청을 의미한다. 새로운 요청이므로 주소가 바뀐다. 이 때 request는 전달되지 않는다.
		// response.redirect("요청주소");

		return mv;
	}

	@PostMapping("/deptInsert.do")
	public String DBInsert(DepDTO dept, Integer deptid2, Integer department_id, RedirectAttributes redirectAttributes) {
		System.out.println(dept);
		System.out.println(deptid2);
		System.out.println(department_id);

		int result = dService.depInsert(dept);
		String message;

		if (result > 0) {
			message = "insert success";
		} else {
			message = "insert fail";
		}
		redirectAttributes.addFlashAttribute("deptResult", message);
		return "redirect:deptList.do";
	}

	@GetMapping("/deptUpdate.do")
	public void detail(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam("deptid") Integer id) {

		System.out.println("getRemoteAddr:" + request.getRemoteAddr());
		session.setAttribute("deptid", id);
		session.setAttribute("myname", "Emmet Baek");
		model.addAttribute("dept", dService.selectById(id));
	}

	@PostMapping("/deptDetail.do")
	public String deptInfoView(@ModelAttribute("dept") DepDTO dept, Model model) {
		System.out.println(dept);
		// model.addAttribute("dept", dept);

		model.addAttribute("mlist", eService.selectAllManager());
		return "dept/deptUpdate_DB";
	}

	@PostMapping("/deptDBUpdate.do")
	public String deptUpdate(DepDTO dept, RedirectAttributes redirectAttributes) {
		int result = dService.depUpdate(dept);

		String message;

		if (result > 0) {
			message = "update success";
		} else {
			message = "update fail";
		}
		redirectAttributes.addFlashAttribute("deptResult", message);
		return "redirect:deptList.do";
	}

	@GetMapping("/deptDelete.do")
	public String deptDelete(@RequestParam("deptid") Integer deptid, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String deptid2 = request.getParameter("deptid");
		System.out.println("Spring이 전달:" + deptid);
		System.out.println("Servlet API 사용:" + deptid2);

		int result = dService.depDelete(deptid);
		
		String message;

		if (result > 0) {
			message = "delete success";
		} else {
			message = "delete fail";
		}
		redirectAttributes.addFlashAttribute("deptResult", message);
		return "redirect:deptList.do";
	}

}
