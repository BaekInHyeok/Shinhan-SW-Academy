package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.job.JobService;
import com.shinhan.util.DateUtil;
import com.shinhan.dept.*;

/**
 * Servlet implementation class EmpInsertServlet
 */
@WebServlet("/emp/empInsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DepService service = new DepService();
		List<DepDTO> dlist = service.selectAll();
		request.setAttribute("dlist", dlist);
		
		EmpService eService = new EmpService();
		List<HashMap<String,Object>> mlist = eService.selectAllManger();
		request.setAttribute("mlist", mlist);
		
		JobService jService = new JobService();
		List<HashMap<String,Object>> jlist = jService.selectAllJob();
		request.setAttribute("jlist", jlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("empInsert.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//요청 문서에 내용을 담아서 온다. 자동 encoding 안됨
		//request.setCharacterEncoding("utf-8");//1문자가 3byte임을 설정
		//==>Filter로 대체됨
		EmpDTO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empInsert(emp);
		System.out.println(result+"건 입력됨");
		request.setAttribute("message", result+"건 입력됨");
		
		//1.JSP에 응답을 위임하는 경우(MVC2모델)
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
		//2.서블릿이 직접 응답을 하는 경우
		/*
		 * response.setContentType("text/html;charset=utf-8"); PrintWriter out =
		 * response.getWriter(); out.write("<h1>서블릿이 직접 응답하는 경우</h1>");
		 */
	}


	private EmpDTO makeEmp(HttpServletRequest request) {
		//Enumeration:한정된 값의 나열을 의미
		Enumeration<String> colnames = request.getParameterNames();
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col+"=>"+request.getParameter(col));
		}
		
		EmpDTO emp = new EmpDTO();
		int empid = convertInt(request.getParameter("employee_id"));
		int mid = convertInt(request.getParameter("manager_id"));
		int did = convertInt(request.getParameter("department_id"));
		int salary = convertInt(request.getParameter("salary"));
		double commision = convertDouble(request.getParameter("commission_pct"));
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		Date hdate = DateUtil.getSQLDate(request.getParameter("hire_date"));
		
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setLast_name(lname);
		emp.setEmail(email);
		emp.setPhone_number(phone);
		emp.setHire_date(hdate);
		emp.setJob_id(job_id);
		emp.setSalary(salary);
		emp.setCommission_pct(commision);
		emp.setManager_id(mid);
		emp.setDepartment_id(did);

		return emp;
	}


	private double convertDouble(String parameter) {
		if(parameter=="") return 0;
		return Double.parseDouble(parameter);
	}


	private int convertInt(String parameter) {
		if(parameter=="") return 0;
		return Integer.parseInt(parameter);
	}

}
