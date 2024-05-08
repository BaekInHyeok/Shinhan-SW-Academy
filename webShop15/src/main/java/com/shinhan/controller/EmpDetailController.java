package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
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
import com.shinhan.job.JobService;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class EmpDetailController
 */
@WebServlet("/emp/empDetail.do")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpDetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("=====get요청====");
		EmpService eService = new EmpService();
		String empid = request.getParameter("empid");
		if (empid == null)
			return;

		int i_empid = Integer.parseInt(empid);
		EmpDTO emp = null;

		try {
			emp = eService.selectById(i_empid);
			System.out.println(emp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 요청문서에 Data를 저장한다.
		request.setAttribute("empInfo", emp);
		// Java code는 servlet 담당 ... 비지니스 로직 수행 후
		// View(HTML)는 JSP 담당 ... JSP에 넘긴다

		// 모든 부서
		// 모든 job
		// 모든 매니저
		DepService dservice = new DepService();
		List<DepDTO> dlist = dservice.selectAll();
		request.setAttribute("dlist", dlist);

		EmpService eservice = new EmpService();
		List<HashMap<String, Object>> mlist = eservice.selectAllManger();
		request.setAttribute("mlist", mlist);

		JobService jservice = new JobService();
		List<HashMap<String, Object>> jlist = jservice.selectAllJob();
		request.setAttribute("jlist", jlist);

		// Browser가 요청->서블릿이 받음->JSP에게 우임함(forward)
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * 404 : page가 존재하지 않음. 주소 확인 405 : 지원하지 않는 요청방식. get/post 확인 500 : 서버오류. 프로그램
	 * 실행 오류이므로 서버의 console창 확인 200 : 성공
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청 문서에 내용을 담아서 온다. 자동 encoding 안됨
		//request.setCharacterEncoding("utf-8");// 1문자가 3byte임을 설정
		//==>Filter로 대체
		
		EmpDTO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empUpdate(emp);
		System.out.println(result + "건 수정됨");
		request.setAttribute("message", result + "건 수정됨");

		// 1.JSP에 응답을 위임하는 경우(MVC2모델)
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);

		// 2.서블릿이 직접 응답을 하는 경우
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

	// doGet(). doPost() 코드가 같다면 service()메서드에서 코드하면 된다.
}
