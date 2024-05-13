package com.shinhan.controller4;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.facilitySERVICE;
import com.shinhan.javaGrammer.storeDTO;
import com.shinhan.javaGrammer.storeSERVICE;
import com.shinhan.javaGrammer.workerDTO;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class StrPageController
 */
@WebServlet("/store/strUpdate.do")
public class strUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int strid = Integer.parseInt(request.getParameter("strid"));
		System.out.println(strid);
		request.setAttribute("strinfo", new storeSERVICE().findBYID(strid));
		
		RequestDispatcher rd = request.getRequestDispatcher("strUpdate.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeSERVICE sService = new storeSERVICE();
		storeDTO str = makeStr(request);
		int result = sService.strUpdate(str);
		
		request.setAttribute("message", "상점 정보 수정됨");
		response.addHeader("Refresh", "0;strpage.do");
		
		
	}

	private storeDTO makeStr(HttpServletRequest request) {
		Enumeration<String> colnames = request.getParameterNames();
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col+"=>"+request.getParameter(col));
		}
		
		storeDTO str = new storeDTO();
		
		int strid = convertInt(request.getParameter("STORE_ID"));
		String businessNum = request.getParameter("STORE_BUSSINESS_NUMBER");
		String strName = request.getParameter("STORE_NAME");
		String owner = request.getParameter("STORE_OWNER");
		String phone = request.getParameter("STORE_PHONE");
		String type = request.getParameter("STORE_TYPE");
		Date strDate = DateUtil.getSQLDate(request.getParameter("STORE_STARTDATE")); 
		String startTime = request.getParameter("STORE_START_TIME");
		String endTime = request.getParameter("STORE_END_TIME");
		
		str.setSTORE_ID(strid);
		str.setSTORE_BUSSINESS_NUMBER(businessNum);
		str.setSTORE_NAME(strName);
		str.setSTORE_OWNER(owner);
		str.setSTORE_PHONE(phone);
		str.setSTORE_TYPE(type);
		str.setSTORE_STARTDATE(strDate);
		str.setSTORE_START_TIME(startTime);
		str.setSTORE_END_TIME(endTime);
		
		return str;
	}

	private int convertInt(String parameter) {
		if(parameter=="") return 0;
		return Integer.parseInt(parameter);
	}
}
