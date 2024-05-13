package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.facilityDTO;
import com.shinhan.javaGrammer.facilitySERVICE;
import com.shinhan.javaGrammer.workerDTO;
import com.shinhan.javaGrammer.workerSERVICE;

/**
 * Servlet implementation class wkrIdCheckServlet
 */
@WebServlet("/worker/wkrIdCheck.do")
public class wkrIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message=null;
		int idSize=request.getParameter("wkrid").length();
		
		if(idSize!=3) {
			message="2";
		}else {
			int wkrid = Integer.parseInt(request.getParameter("wkrid"));
			System.out.println(wkrid);
			workerSERVICE wService = new workerSERVICE();
			workerDTO wkr = wService.findBYID(wkrid);
			
			if (wkr == null) {
				message = "0";
			}else {
				message="1";
			}
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(message);
	}

}
