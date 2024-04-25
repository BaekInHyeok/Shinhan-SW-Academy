package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 * @WebServlet : 주소창에서 요청 시 Mapping 주소
 * http://192.168.0.103:9090/webShop
 */
@WebServlet({ "/FirstServlet", "/First", "/First2" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        System.out.println("FierstServlet 생성자");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FierstServlet init(초기화)");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("FierstServlet 소멸자");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addr = request.getRemoteAddr();
		System.out.println("FierstServlet get요청 : "+addr);
		System.out.println("userid:"+request.getParameter("userid"));
		
		response.getWriter().append("<h1>Served at(get): ").append(addr).append(request.getContextPath()+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addr = request.getRemoteAddr();
		System.out.println("FierstServlet post요청"+addr);
		System.out.println("userid:"+request.getParameter("userid"));
		response.getWriter().append("<h1>Served at(post): ").append(addr).append(request.getContextPath()+"</h1>");

		doGet(request, response);
	}

	/*
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * System.out.println("============service==========");
	 * System.out.println(req.getMethod()+"요청"); //doGet(), doPost() 코드를 모두 해야 하는 경우
	 * }
	 */
	
	

}
