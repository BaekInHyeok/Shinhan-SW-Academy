package com.shinhan.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.facilityDTO;
import com.shinhan.javaGrammer.facilitySERVICE;


/**
 * Servlet implementation class FacPageController
 */
@WebServlet("/facility/facpage.do")
public class FacPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		facilitySERVICE fService = new facilitySERVICE();
		List<facilityDTO> facList = fService.selectAll();
		request.setAttribute("facList", facList);

		RequestDispatcher rd = request.getRequestDispatcher("facInfo.jsp");
		rd.forward(request, response);
		return;
	}

}
