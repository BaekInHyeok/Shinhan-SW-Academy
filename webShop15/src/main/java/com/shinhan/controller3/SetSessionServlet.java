package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetSessionServlet
 */
@WebServlet("/jsp/setSession")
public class SetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();//request.getSession(true)
		System.out.println("신규?:"+session.isNew());
		System.out.println("생성시각:"+session.getCreationTime());
		System.out.println("유효시간:"+session.getMaxInactiveInterval());
		System.out.println("getId:"+session.getId());
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		session.setAttribute("memberid", id);
		session.setAttribute("memberpw", pw);
		
	}

}
