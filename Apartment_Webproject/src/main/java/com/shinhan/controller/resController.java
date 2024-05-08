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
 * Servlet implementation class resController
 */
@WebServlet("/resident/rescon1.do")
public class resController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		residentSERVICE rService = new residentSERVICE();
		List<residentDTO> resList = rService.selectAll();
		
		request.setAttribute("resList", resList);
		
		RequestDispatcher rd = request.getRequestDispatcher("resList.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		residentSERVICE rService = new residentSERVICE();
		int dong = Integer.parseInt(request.getParameter("dong"));
		System.out.println("선택한 동:"+dong);
		List<residentDTO> resList = rService.findBYDONG(dong);
		System.out.println(resList);
		request.setAttribute("resList",resList);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("resList.jsp");
		rd.forward(request, response);
		return;
	}

}
