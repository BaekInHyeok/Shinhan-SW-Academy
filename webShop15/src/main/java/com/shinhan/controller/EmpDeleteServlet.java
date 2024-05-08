package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/emp/empdelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));

		EmpService service = new EmpService();
		int result = service.empDelete(empid);
		//sendRedirect : 새로운 요청으로 보내기...주소창의 주소가 바뀜
		//브라우저로 내려갔다가 다시 서버에 새로운 요청을 한다.
		//1)
		//response.sendRedirect("empList.do");
		
		//2)3초 뒤에 처리
		response.addHeader("Refresh","3;empList.do");
		
		//3)
		//forwards : 받은 요청을 다른 페이지에 위임(주소창 안바뀜)
//		request.setAttribute("message", result + "건 삭제됨");
//		request.getRequestDispatcher("result.jsp").forward(request, response);

	}

}
