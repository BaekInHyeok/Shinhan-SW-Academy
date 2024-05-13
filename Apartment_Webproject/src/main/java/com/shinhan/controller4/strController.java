package com.shinhan.controller4;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.storeDTO;
import com.shinhan.javaGrammer.storeSERVICE;
import com.shinhan.javaGrammer.workerDTO;
import com.shinhan.javaGrammer.workerSERVICE;
import com.shinhan.javaGrammer.wrkINworkDTO;

/**
 * Servlet implementation class StrPageController
 */
@WebServlet("/store/strcon.do")
public class strController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeSERVICE sService = new storeSERVICE();
		List<storeDTO> strList = sService.selectAll();
		request.setAttribute("strList", strList);

		RequestDispatcher rd = request.getRequestDispatcher("strList.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeSERVICE sService = new storeSERVICE();
		String type = request.getParameter("type");
		System.out.println(type);
		
		List<storeDTO> strList = sService.findByType(type);
		
		System.out.println(strList);
		
		request.setAttribute("strList", strList);
		
		RequestDispatcher rd = request.getRequestDispatcher("strList.jsp");
		rd.forward(request, response);
		return;
	}

}
