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
import com.shinhan.javaGrammer.wrkINfacDTO;

/**
 * Servlet implementation class facController
 */
@WebServlet("/facility/faccon.do")
public class facController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		facilitySERVICE fService = new facilitySERVICE();
		List<facilityDTO> facList = fService.selectAll();
		request.setAttribute("facList", facList);
		
		RequestDispatcher rd = request.getRequestDispatcher("facList.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		facilitySERVICE fService = new facilitySERVICE();
		String facname = request.getParameter("facName");
		List<wrkINfacDTO> wrkINfaclist = fService.findBYfacname(facname);
		
		request.setAttribute("empList", wrkINfaclist);
		
		RequestDispatcher rd = request.getRequestDispatcher("wrkInfacList.jsp");
		rd.forward(request, response);
		return;
	}

}
