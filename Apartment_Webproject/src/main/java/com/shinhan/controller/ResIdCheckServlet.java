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
		String message=null;
		int idSize=request.getParameter("resid").length();
		
		if(idSize!=5) {
			message="2";
		}else {
			int resid = Integer.parseInt(request.getParameter("resid"));
			System.out.println(resid);
			residentSERVICE rService = new residentSERVICE();
			residentDTO res = rService.findBYID(resid);
			
			if(res==null) {
				message="0";
			}else {
				message="1";
			}
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(message);
	}


}
