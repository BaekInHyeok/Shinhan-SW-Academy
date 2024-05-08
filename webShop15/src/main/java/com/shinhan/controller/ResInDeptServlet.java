package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DepDTO;
import com.shinhan.dept.DepService;
import com.shinhan.job.JobDTO;

/**
 * Servlet implementation class ResInDeptServlet
 */
@WebServlet("/dept/empIndept.do")
public class ResInDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepService dService = new DepService();
		List<DepDTO> deptlist = dService.selectAll();
		request.setAttribute("AllDeptInfo", deptlist);

		RequestDispatcher rd = request.getRequestDispatcher("empindeptlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
