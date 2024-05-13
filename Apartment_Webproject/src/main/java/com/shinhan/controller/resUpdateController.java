package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.javaGrammer.residentDTO;
import com.shinhan.javaGrammer.residentSERVICE;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class resUpdateController
 */
@WebServlet("/resident/resUpdate.do")
public class resUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int resid = Integer.parseInt(request.getParameter("resid"));
		System.out.println(resid);
		request.setAttribute("resinfo", new residentSERVICE().findBYID(resid));

		RequestDispatcher rd = request.getRequestDispatcher("resUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		residentSERVICE rService = new residentSERVICE();
		residentDTO res = makeRes(request);
		int result = rService.resUpdate(res);

		request.setAttribute("message", "입주자 정보 수정됨");

		response.addHeader("Refresh", "0;respage.do");
	}

	private residentDTO makeRes(HttpServletRequest request) {

		Enumeration<String> colnames = request.getParameterNames();
		while (colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}
		residentDTO res = new residentDTO();

		int resid = convertInt(request.getParameter("resident_id"));
		String resname = request.getParameter("resident_name");
		String resphone = request.getParameter("resident_phone");
		int resdong = convertInt(request.getParameter("resident_dong"));
		int resho = convertInt(request.getParameter("resdient_ho"));
		Date resdate = DateUtil.getSQLDate(request.getParameter("resident_date"));
		String resowner = request.getParameter("resident_owner");
		String rescar = request.getParameter("resident_car");
		String resfee = request.getParameter("resident_fee");

		res.setResident_id(resid);
		res.setResident_name(resname);
		res.setResident_phone(resphone);
		res.setResident_dong(resdong);
		res.setResident_ho(resho);
		res.setResident_date(resdate);
		res.setResident_car(rescar);
		res.setResident_fee(resfee);
		res.setResident_owner(resowner);

		return res;

	}

	private int convertInt(String parameter) {
		if (parameter == null || parameter.isEmpty()) return 0;
	    return Integer.parseInt(parameter);
	}

}
