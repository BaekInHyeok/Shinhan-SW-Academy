package com.shinhan.controller4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.storeSERVICE;
import com.shinhan.javaGrammer.workerSERVICE;

/**
 * Servlet implementation class StrPageController
 */
@WebServlet("/store/strDelete.do")
public class strDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int strid = Integer.parseInt(request.getParameter("strid"));
		storeSERVICE sService = new storeSERVICE();
		int result=sService.strDelete(strid);
		response.addHeader("Refresh", "1;strpage.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
