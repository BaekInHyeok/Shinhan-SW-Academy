package com.shinhan.controller3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.facilitySERVICE;
import com.shinhan.javaGrammer.workerDTO;
import com.shinhan.javaGrammer.workerSERVICE;
import com.shinhan.javaGrammer.wrkINfacDTO;
import com.shinhan.javaGrammer.wrkINworkDTO;

/**
 * Servlet implementation class wrkController
 */
@WebServlet("/worker/wkrcon.do")
public class wkrController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		workerSERVICE wService = new workerSERVICE();
		List<workerDTO> wkrList = wService.selectAll();
		request.setAttribute("wkrList", wkrList);

		RequestDispatcher rd = request.getRequestDispatcher("wkrList.jsp");
		rd.forward(request, response);
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		workerSERVICE wService = new workerSERVICE();
		String work = request.getParameter("work");
		System.out.println(work);
		
		List<wrkINworkDTO> wrkINworklist = wService.findByWork(work);
		
		System.out.println(wrkINworklist);
		
		request.setAttribute("wrkINworklist", wrkINworklist);
		
		RequestDispatcher rd = request.getRequestDispatcher("wkrInWorkList.jsp");
		rd.forward(request, response);
		return;
	}

}
