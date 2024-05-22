package com.shinhan.myapp.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.firstzone.myapp.dept.DepService;
import org.firstzone.myapp.emp.EmpDTO;
import org.firstzone.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.myapp.util.DateUtil;

@Controller
@RequestMapping("/emp")
public class EmpController {

	// AutoWired�� Ÿ���� ������ �ڵ� ������
	@Autowired
	EmpService eService;

	@Autowired
	DepService dService;

	@RequestMapping("/empAll.do")
	public String empAll(Model model, Integer deptid, String jobid) {
		List<EmpDTO> emplist2 = null;

		if (deptid == null)
			deptid = 0;
		emplist2 = eService.selectByCondition(deptid, jobid, null, 0);

		model.addAttribute("emplist", emplist2);
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("joblist", eService.selectAllJob());
		// view �̸��� ���ϵ�
		// ViewResolver�� ���λ�+view�̸�+���̻�
		// view�� forward�ȴ�.(�ּҴ� �ٲ��� ����)
		return "emp/emplist";

	}

	// deptSelect=60&jobSelect=MK_MAN&hdate=2005-01-01&salary=5000
	// deptSelect=0 >> ��� �μ��� �ǹ�
	// jobSelect=all >> ��� ��å�� �ǹ�
	@RequestMapping("/empAll2.do")
	public String empConditoin(Model model, HttpSession session, Integer deptSelect, String jobSelect, String hdate,
			Integer salary) {
		Date startDate = DateUtil.getSQLDate(hdate);

		if (salary == null)
			salary = 0;

		List<EmpDTO> emplist2 = eService.selectByCondition(deptSelect, jobSelect, startDate, salary);
		// ������ ������ session�� �����ϱ�
		session.setAttribute("deptSelect", deptSelect);
		session.setAttribute("jobSelect", jobSelect);
		session.setAttribute("hdate", hdate);
		session.setAttribute("salary", salary);

		model.addAttribute("emplist", emplist2);
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("joblist", eService.selectAllJob());
		return "emp/emplist";
	}

	@GetMapping("/empDetail.do")
	public String detail(@RequestParam("empid") Integer empid2, Model model) {

		model.addAttribute("empInfo", eService.selectById(empid2));
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("mlist", eService.selectAllManager());
		model.addAttribute("joblist", eService.selectAllJob());

		return "emp/empDetail";
	}

	@GetMapping("/empInsert.do")
	public void insert(Model model) {
		model.addAttribute("deptlist", dService.selectAll());
		model.addAttribute("mlist", eService.selectAllManager());
		model.addAttribute("jlist", eService.selectAllJob());
	}

	@PostMapping("/empInsert.do")
	public String insertDB(EmpDTO emp) {
		System.out.println("insertȮ��(javabean):" + emp);
		eService.empInsert(emp);
		return "redirect:empAll.do";
	}

	@GetMapping("/empIdCheck.do")
	@ResponseBody
	public String test(int empid) {
		System.out.println(empid);
		EmpDTO emp = null;

		emp = eService.selectById(empid);

		if (emp == null)
			return "0";
		return "1";
	}

	@PostMapping("/empDetail.do")
	public String updateDB(EmpDTO emp) {
		eService.empUpdate(emp);
		return "redirect:empAll.do";
	}

	@GetMapping("/empDelete.do")
	public String delete(Integer empid) {
		eService.empDelete(empid);

		return "redirect:empAll.do";
	}

}
