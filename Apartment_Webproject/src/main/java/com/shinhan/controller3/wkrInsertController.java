package com.shinhan.controller3;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.facilityDTO;
import com.shinhan.javaGrammer.facilitySERVICE;
import com.shinhan.javaGrammer.workerDTO;
import com.shinhan.javaGrammer.workerSERVICE;
import com.shinhan.util.DBUtil;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class wrkInsertController
 */
@WebServlet("/worker/wkrInsert.do")
public class wkrInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		facilitySERVICE fService = new facilitySERVICE();
		List<facilityDTO> facList = fService.selectAll();
		
		request.setAttribute("facList", facList);
		RequestDispatcher rd = request.getRequestDispatcher("wkrInsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		workerSERVICE wService = new workerSERVICE();
		workerDTO wkr = makeWkr(request);
		int result = wService.wkrInsert(wkr);
		
		request.setAttribute("message", "근무자 정보 등록됨");
		response.addHeader("Refresh", "0;wkrpage.do");
		
	}
	
	private workerDTO makeWkr(HttpServletRequest request){
		Enumeration<String> colnames = request.getParameterNames();
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col+"=>"+request.getParameter(col));
		}
		
		workerDTO wkr = new workerDTO();

		int wkrid = convertInt(request.getParameter("WORKER_ID"));
		String wkrname = request.getParameter("WORKER_NAME");
		int wkrage = convertInt(request.getParameter("WORKER_AGE"));
		String wkrgender = request.getParameter("WORKER_GENDER");
		String wkrphone = request.getParameter("WORKER_PHONE");
		Date hiredate = DateUtil.getSQLDate(request.getParameter("WORKER_HIREDATE"));
		int wkrplaceid = convertInt(request.getParameter("WORKER_WORKPLACE_ID"));
		String work = request.getParameter("WORKER_WORK");
		int salary = convertInt(request.getParameter("WORKER_SALARY"));
		
		wkr.setWORKER_ID(wkrid);
		wkr.setWORKER_NAME(wkrname);
		wkr.setWORKER_AGE(wkrage);
		wkr.setWORKER_GENDER(wkrgender);
		wkr.setWORKER_PHONE(wkrphone);
		wkr.setWORKER_HIREDATE(hiredate);
		wkr.setWORKER_WORKPLACE_ID(wkrplaceid);
		wkr.setWORKER_WORK(work);
		wkr.setWORKER_SALARY(salary);

		return wkr;
	}

	private int convertInt(String parameter) {
		if(parameter=="") return 0;
		return Integer.parseInt(parameter);
	}
}
