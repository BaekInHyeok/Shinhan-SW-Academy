package com.shinhan.controller4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.storeDTO;
import com.shinhan.javaGrammer.storeSERVICE;
import com.shinhan.javaGrammer.workerDTO;
import com.shinhan.javaGrammer.workerSERVICE;

/**
 * Servlet implementation class StrPageController
 */
@WebServlet("/store/strIdCheck.do")
public class strIDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message=null;
		int idSize=request.getParameter("strid").length();
		
		if(idSize!=4) {
			message="2";
		}else {
			int strid = Integer.parseInt(request.getParameter("strid"));
			System.out.println(strid);
			storeSERVICE sService = new storeSERVICE();
			storeDTO str = sService.findBYID(strid);
			if (str == null) {
				message = "0";
			}else {
				message="1";
			}
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(message);	
	}


}
