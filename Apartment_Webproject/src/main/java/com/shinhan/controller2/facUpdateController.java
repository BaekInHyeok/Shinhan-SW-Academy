package com.shinhan.controller2;

import java.io.IOException;
import java.sql.Date;
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
import com.shinhan.javaGrammer.residentDTO;
import com.shinhan.javaGrammer.residentSERVICE;
import com.shinhan.javaGrammer.workerDTO;
import com.shinhan.javaGrammer.workerSERVICE;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class facInsertController
 */
@WebServlet("/facility/facUpdate.do")
public class facUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int facid = Integer.parseInt(request.getParameter("facid"));
		System.out.println(facid);
		request.setAttribute("facinfo", new facilitySERVICE().findBYID(facid));

		workerSERVICE wService = new workerSERVICE();
		List<workerDTO> wkrList = wService.selectNotMgrList();
		request.setAttribute("wkrList", wkrList);
		
		RequestDispatcher rd = request.getRequestDispatcher("facUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		facilitySERVICE fService = new facilitySERVICE();
		facilityDTO fac = makeFac(request);
		int result1 = fService.facUpdate(fac);
		
		workerSERVICE wService = new workerSERVICE();
		int mgrID = fac.getFacility_manager_id();
		int facID = fac.getFacility_id(); 
		int result2 = wService.mgrUpdate(mgrID, facID);

		request.setAttribute("message", "시설 정보 수정됨");
		response.addHeader("Refresh", "0;facpage.do");
	}

	private facilityDTO makeFac(HttpServletRequest request) {
		Enumeration<String> colnames = request.getParameterNames();
		while (colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}

		facilityDTO fac = new facilityDTO();

		int facid = convertInt(request.getParameter("facility_id"));
		String facname = request.getParameter("facility_name");
		Date facdate = DateUtil.getSQLDate(request.getParameter("facility_date"));
		String ftype = request.getParameter("facility_type");
		String facstart = request.getParameter("facility_start_time");
		String facend = request.getParameter("facility_end_time");
		int facmid = convertInt(request.getParameter("facility_manager_id"));

		fac.setFacility_id(facid);
		fac.setFacility_name(facname);
		fac.setFacility_date(facdate);
		fac.setFacility_type(ftype);
		fac.setFacility_start_time(facstart);
		fac.setFacility_end_time(facend);
		fac.setFacility_manager_id(facmid);
		
		return fac;
	}

	private int convertInt(String parameter) {
		if (parameter == "")
			return 0;
		return Integer.parseInt(parameter);
	}

}
