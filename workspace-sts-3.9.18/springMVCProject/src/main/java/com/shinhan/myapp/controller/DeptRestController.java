package com.shinhan.myapp.controller;

import java.util.List;

import org.firstzone.myapp.dept.DepDTO;
import org.firstzone.myapp.dept.DepService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	//@Controller+@ResponseBody
@RequestMapping("/dept/api/*")
public class DeptRestController {
	
	@Autowired
	DepService dService;
	
	Logger logger = LoggerFactory.getLogger(DeptRestController.class);
	
	//����
	@DeleteMapping(value="/delete/{deptid}", produces="text/plain;charset=utf-8")
	public String delete(@PathVariable("deptid") Integer deptid) {
		int result = dService.depDelete(deptid);
		return result>0?"��������":"��������";
	}
	
	//����
	@PutMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE, produces="text/plain;charset=utf-8")
	public String update(@RequestBody DepDTO dept) {
		int result = dService.depUpdate(dept);
		return "���� �Ǽ�:"+result+"��";
	}
	
	//Post�� ��û ������ body�� data�� ���´�
	@PostMapping(value="/insert", consumes=MediaType.APPLICATION_JSON_VALUE, produces="text/plain;charset=utf-8")
	public String insert(@RequestBody DepDTO dept) {
		logger.info("���� dept:"+dept);
		int result = dService.depInsert(dept);
		return "insert:"+result;
	}
	
	//JSON���� ��������
	//jackson-databind�� �̿��ؼ� �ڹ��� ��ü�� Json���� convert
	//produces = "application/json"
	@GetMapping(value="/deptAll", produces = "application/json")
	public List<DepDTO> selectAll() {
		List<DepDTO> deptlist = dService.selectAll();
		return deptlist;
	}
	
	//JSON���� ��������
	//jackson-databind�� �̿��ؼ� �ڹ��� ��ü�� Json���� convert
	//produces = MediaType.APPLICATION_JSON_VALUE
	@GetMapping(value="/detail/{deptid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DepDTO selectById(@PathVariable("deptid") Integer did) {
		DepDTO dept = dService.selectById(did);
		return dept;
	}
	
	//�������� : consumes ����
	//�������� : produces ����
	@GetMapping(value = "/test1", produces="text/plain;charset=utf-8")
	public String test1() {
		return "Restful ��� ����";
	}
}
