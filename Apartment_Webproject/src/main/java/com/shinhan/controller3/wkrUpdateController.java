package com.shinhan.controller3;

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
import com.shinhan.javaGrammer.workerDTO;
import com.shinhan.javaGrammer.workerSERVICE;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class wrkUpdateController
 */
@WebServlet("/worker/wkrUpdate.do")
public class wkrUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int wkrid = Integer.parseInt(request.getParameter("wkrid"));
		System.out.println(wkrid);
		request.setAttribute("wkrinfo", new workerSERVICE().findBYID(wkrid));
		
		facilitySERVICE fService = new facilitySERVICE();
		List<facilityDTO> facList = fService.selectAll();
		
		request.setAttribute("facList", facList);
		
		RequestDispatcher rd = request.getRequestDispatcher("wkrUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		workerSERVICE wService = new workerSERVICE();
		workerDTO wkr = makeWkr(request);
		int result1 = wService.wrkUpdate(wkr);
		
		facilitySERVICE fService = new facilitySERVICE();
		
		int wkrID = wkr.getWORKER_ID();//근로자의 ID
		int newfacID = wkr.getWORKER_WORKPLACE_ID();//근로자가 근무하는 시설 ID
		
		
		//근로자가 매니저를 맡고 있었던 시설을 끌고 온다
		facilityDTO fac = fService.findBYMgrID(wkrID);
		
		if(fac!=null) {
			//시설의 ID
			int facID = fac.getFacility_id();
			//시설의 매니저 ID
			int facMgrID  = fac.getFacility_manager_id();
			
			//시설의 매니저ID와 근로자의 ID가 같지만, 시설 ID와 근로자의 근무 시설 ID가 다르면?
			if(wkrID==facMgrID && facID!=newfacID) {
				//시설의 매니저 ID를 0으로 바꾼다
				int result2=fService.eraseMgrId(facMgrID);
			}
		}
		
		
		
		
		request.setAttribute("message", "근무자 정보 수정됨");
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
