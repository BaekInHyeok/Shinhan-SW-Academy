package com.shinhan.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DepDTO;
import com.shinhan.dept.DepService;

/**
 * Servlet implementation class DeptDetailController
 */
@WebServlet("/dept/deptDetail.do")
public class DeptDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DepService dService = new DepService();
		String deptid = request.getParameter("deptid");
		if (deptid == null)
			return;

		
		int i_deptid = Integer.parseInt(deptid);
		DepDTO dept = null;
		try {
			dept = dService.selectById(i_deptid);
			System.out.println(dept);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("deptinfo", dept);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptUpdate.jsp");
		rd.forward(request, response);

	}

}
