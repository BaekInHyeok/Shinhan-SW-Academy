package com.shinhan.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.facilityDTO;
import com.shinhan.javaGrammer.facilitySERVICE;
import com.shinhan.javaGrammer.residentDTO;

/**
 * Servlet implementation class facIDCheckServlet
 */
@WebServlet("/facility/facIdCheck.do")
public class facIDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message=null;
		int idSize=request.getParameter("facid").length();
		if(idSize!=2) {
			message="2";
		}else {
			int facid = Integer.parseInt(request.getParameter("facid"));
			System.out.println(facid);
			facilitySERVICE fService = new facilitySERVICE();
			facilityDTO fac = fService.findBYID(facid);
			
			if (fac == null) {
				message = "0";
			}else {
				message = "1";
			}
		}

		response.setCharacterEncoding("utf-8");
		response.getWriter().append(message);
	}

}
