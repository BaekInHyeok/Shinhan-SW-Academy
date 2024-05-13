package com.shinhan.controller3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.workerDTO;
import com.shinhan.javaGrammer.workerSERVICE;

/**
 * Servlet implementation class WrkPageController
 */
@WebServlet("/worker/wkrpage.do")
public class WkrPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		workerSERVICE wService = new workerSERVICE();
		List<workerDTO> wkrList = wService.selectAll();
		List<String> workList = wService.allWork();
		System.out.println(workList);
		request.setAttribute("wkrList", wkrList);
		request.setAttribute("workList", workList);
		
		RequestDispatcher rd = request.getRequestDispatcher("wkrInfo.jsp");
		rd.forward(request, response);
		return;
	}
}
