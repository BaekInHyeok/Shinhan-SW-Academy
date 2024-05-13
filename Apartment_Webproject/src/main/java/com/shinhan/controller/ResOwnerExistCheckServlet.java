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
 * Servlet implementation class ResOwnerExistCheckServlet
 */
@WebServlet("/resident/resOwnerExistCheck.do")
public class ResOwnerExistCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkResult=null;
		
		int dong = Integer.parseInt(request.getParameter("resdong"));
		int ho = Integer.parseInt(request.getParameter("resho"));
		
		System.out.println(dong);
		System.out.println(ho);
		
		residentSERVICE rService = new residentSERVICE();
		residentDTO res = rService.isOwnerExist(dong, ho);
		
		System.out.println(res);
		
		if(res==null) {
			checkResult="no";
		}else {
			checkResult="yes";
		}
		System.out.println(checkResult);
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(checkResult);
	}
}
