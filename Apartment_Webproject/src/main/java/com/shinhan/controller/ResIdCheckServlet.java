package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.residentDTO;
import com.shinhan.javaGrammer.residentSERVICE;

/**
 * Servlet implementation class ResIdCheckServlet
 */
@WebServlet("/resident/resIdCheck.do")
public class ResIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resid = Integer.parseInt(request.getParameter("resid"));
		System.out.println(resid);
		residentSERVICE rService = new residentSERVICE();
		
		String message="이미 존재하는 ID입니다.";
		residentDTO res = rService.findBYID(resid);
		if(res==null) {
			message="사용 가능한 ID입니다.";
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(message);
	}


}
