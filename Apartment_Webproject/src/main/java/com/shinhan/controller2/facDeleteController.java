package com.shinhan.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.facilityDTO;
import com.shinhan.javaGrammer.facilitySERVICE;
import com.shinhan.javaGrammer.residentSERVICE;
import com.shinhan.javaGrammer.workerDTO;
import com.shinhan.javaGrammer.workerSERVICE;
import com.shinhan.javaGrammer.wrkINfacDTO;

/**
 * Servlet implementation class facDeleteController
 */
@WebServlet("/facility/facDelete.do")
public class facDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int facid = Integer.parseInt(request.getParameter("facid"));
		facilitySERVICE fService = new facilitySERVICE();
		workerSERVICE wService = new workerSERVICE();
		facilityDTO fac =fService.findBYID(facid);
		String facName = fac.getFacility_name();
		
		List<wrkINfacDTO> wrkInFAC = fService.findBYfacname(facName);
		System.out.println(wrkInFAC);
		
		for(wrkINfacDTO dto:wrkInFAC) {
			int workerID = dto.getWORKER_ID();
			int result2 = wService.eraseWorkplaceId(facid);
		}
		
		
		int result=fService.facDelete(facid);
		
		response.addHeader("Refresh", "1;facpage.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
