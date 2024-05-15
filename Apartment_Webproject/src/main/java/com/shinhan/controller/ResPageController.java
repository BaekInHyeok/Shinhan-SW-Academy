package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.residentDTO;
import com.shinhan.javaGrammer.residentSERVICE;

/**
 * Servlet implementation class ResPageController
 */
@WebServlet("/resident/respage.do")
public class ResPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		residentSERVICE rService = new residentSERVICE();
		List<residentDTO> resList = rService.selectAll();

		request.setAttribute("resList", resList);

		RequestDispatcher rd = request.getRequestDispatcher("residentInfo.jsp");
		rd.forward(request, response);
		return;
		
		
	}

}
