package com.shinhan.controller4;

import java.io.IOException;
import java.util.Date;
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
 * Servlet implementation class strOpenListServlet
 */
@WebServlet("/store/strOpen.do")
public class strOpenListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeSERVICE sService = new storeSERVICE();
		List<storeDTO> openedStrLIst = sService.findIsOpen();
	
		request.setAttribute("openedStrLIst", openedStrLIst);
		RequestDispatcher rd = request.getRequestDispatcher("strOpenNow.jsp");
		rd.forward(request, response);
		return;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
