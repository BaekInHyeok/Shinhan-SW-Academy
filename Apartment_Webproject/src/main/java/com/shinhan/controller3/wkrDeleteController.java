package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.facilityDTO;
import com.shinhan.javaGrammer.facilitySERVICE;
import com.shinhan.javaGrammer.residentSERVICE;
import com.shinhan.javaGrammer.workerSERVICE;

/**
 * Servlet implementation class wkrDeleteController
 */
@WebServlet("/worker/wkrDelete.do")
public class wkrDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int wkrid = Integer.parseInt(request.getParameter("wkrid"));
		workerSERVICE wService = new workerSERVICE();
		facilitySERVICE fService = new facilitySERVICE();

		
		// 근로자가 매니저를 맡고 있었던 시설을 끌고 온다
		facilityDTO fac = fService.findBYMgrID(wkrid);
		if(fac!=null) {
			//시설의 ID
			int facID = fac.getFacility_id();
			//시설의 매니저 ID
			int facMgrID  = fac.getFacility_manager_id();

			int result2=fService.eraseMgrId(facMgrID);
		}
		
		int result = wService.wrkDelete(wkrid);
		

		response.addHeader("Refresh", "1;wkrpage.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
