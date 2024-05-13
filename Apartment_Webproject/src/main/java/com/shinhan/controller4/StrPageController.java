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

/**
 * Servlet implementation class StrPageController
 */
@WebServlet("/store/strpage.do")
public class StrPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeSERVICE sService = new storeSERVICE();
		List<storeDTO> strList = sService.selectAll();
		List<String> typeList = sService.allType();
		System.out.println(strList);
		request.setAttribute("strList", strList);
		request.setAttribute("typeList", typeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("strInfo.jsp");
		rd.forward(request, response);
		return;
	}

	

}
