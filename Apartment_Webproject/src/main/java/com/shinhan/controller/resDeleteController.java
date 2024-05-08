package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.residentSERVICE;

/**
 * Servlet implementation class resDeleteController
 */
@WebServlet("/resident/resDelete.do")
public class resDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resid = Integer.parseInt(request.getParameter("resid"));
		residentSERVICE rService = new residentSERVICE();
		
		int result=rService.resDelete(resid);
		
		response.addHeader("Refresh", "1;respage.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
