package com.shinhan.day15;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Controller -> Service -> DAO
//			 <- 		<-

//Service : 비즈니스 로직을 수행함
public class EmpService {

	EmpDAO empDAO = new EmpDAO();

	// 1.직원 모두 조회
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 2.특정 직원 조회
	public EmpDTO selectById(int empId) throws ClassNotFoundException, SQLException {

		return empDAO.selectById(empId);
	}

	// 3.특정 부서 직원 조회
	public List<EmpDTO> selectByDepId(int eid) {
		return empDAO.selectByDepId(eid);
	}

	// 4.특정 JOB 직원 조회
	public List<EmpDTO> selectByJobId(String jobId) {
		return empDAO.selectByJobId(jobId);
	}

	// 5.요구하는 조건들을 입력하여 조회하기
	// 부서별, 직책별, 입사일별(>=), 급여(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	// 6.직원 추가
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}

	// 7.직원 수정
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}

	// 8.직원 삭제
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}

}
