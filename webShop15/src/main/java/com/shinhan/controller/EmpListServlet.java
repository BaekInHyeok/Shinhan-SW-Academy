package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmpDTO emp = (EmpDTO)session.getAttribute("loginEmp");
		if(emp==null||emp.getEmployee_id()==-1 || emp.getEmployee_id()==-2) {
			//로그인되어 있지 않으면 브라우저로 내려가서 로그인으로 재요청
			response.sendRedirect("../auth/login.do");
			return;
		}
		
		EmpService eService = new EmpService();
		List<EmpDTO> emplist= eService.selectAll();
		System.out.println(emplist.size()+"건 조회됨");
		request.setAttribute("emplist", emplist);//요청문서에 추가로 저장
		//Dispatcher : 위임, 요청은 서블릿이 받고 응답은 jsp가 한다.
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);//response가 전달되었다는 것은 서블릿 대신 jsp가 응답한다는 의미
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpService eService = new EmpService();
		int eid=Integer.parseInt(request.getParameter("deptid"));
		System.out.println("부서번호:"+eid);
		List<EmpDTO> emplist = eService.selectByDepId(eid);
		System.out.println(emplist);
		request.setAttribute("emplist", emplist);
		System.out.println("여기까지 도달");
		RequestDispatcher rd = request.getRequestDispatcher("empindeplist2.jsp");
		rd.forward(request, response);
	}
}
