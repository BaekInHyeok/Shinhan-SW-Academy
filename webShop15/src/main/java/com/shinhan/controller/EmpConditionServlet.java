package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DepDTO;
import com.shinhan.dept.DepService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.job.JobDTO;
import com.shinhan.job.JobService;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class JobListServlet
 */
@WebServlet("/emp/retrieve.do")
public class EmpConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모든 job 조회
		//1.객체 생성 why? 인스턴스에서도 호출하기 위해 객체 생성, static 메서드였으면 생성 없이 호출 가능
		JobService jService = new JobService();
		List<JobDTO> joblist = jService.selectAll();
		request.setAttribute("AllJobInfo", joblist);
		
		DepService dService = new DepService();
		List<DepDTO> deptlist = dService.selectAll();
		request.setAttribute("AllDeptInfo", deptlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("retrieve.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobid=request.getParameter("jobid");
		int deptid=Integer.parseInt(request.getParameter("deptid"));
		int salary=Integer.parseInt(request.getParameter("salary"));
		Date hiredate=DateUtil.getSQLDate(request.getParameter("hiredate"));
		System.out.println(jobid);
		System.out.println(deptid);
		System.out.println(salary);
		System.out.println(hiredate);
		
		EmpService eService = new EmpService();
		List<EmpDTO> emplist = eService.selectByCondition(deptid, jobid, hiredate, salary);
		request.setAttribute("emplist", emplist);
		System.out.println("1");
		RequestDispatcher rd = request.getRequestDispatcher("empList2.jsp");
		System.out.println("2");
		rd.forward(request, response);
		System.out.println("3");
		
	
	}
	
	
}
