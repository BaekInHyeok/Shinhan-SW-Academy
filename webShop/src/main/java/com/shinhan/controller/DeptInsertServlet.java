package com.shinhan.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DepDTO;
import com.shinhan.dept.DepService;

/**
 * Servlet implementation class DeptInsertServlet
 */
@WebServlet("/dept/deptInsert.do")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("deptInsert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int deptid = Integer.parseInt(request.getParameter("department_id"));
		String deptname = request.getParameter("department_name");
		int mid = Integer.parseInt(request.getParameter("manager_id"));
		int loc = Integer.parseInt(request.getParameter("location_id"));
	
		DepDTO dept = new DepDTO(deptid,deptname,mid,loc);
		
		DepService dservice = new DepService();
		int result = dservice.depInsert(dept);
		System.out.println(result+"건 입력됨");
		
		request.setAttribute("message", result+"건 입력됨");
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
