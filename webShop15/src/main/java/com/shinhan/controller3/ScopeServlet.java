package com.shinhan.controller3;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeServlet
 */

//URL 패턴은 가상의 이름
//@WebServlet("/jsp/scope")
//@WebServlet("/jsp/scope/*")
@WebServlet("*.go")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		
		//우선순위는 request>session>applicaiton 순
		request.setAttribute("mydata", 100);
		session.setAttribute("mydata", 200);
		application.setAttribute("mydata", 300);
		
		request.setAttribute("myage1", 10);
		session.setAttribute("myage2", 20);
		application.setAttribute("myage3", 30);
		
		//절대경로 사용하기
		String path = getServletContext().getServletContextName();
		System.out.println(path);
		request.getRequestDispatcher("/jsp/scope.jsp").forward(request, response);
	
		//서블릿의 default 경로는 http://localhost:9090/webShop15
		//JSP, html의 default 경로는 http://localhost:9090
	}

	

}
