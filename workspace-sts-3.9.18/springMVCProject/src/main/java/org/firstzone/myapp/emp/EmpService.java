package org.firstzone.myapp.emp;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Controller -> Service -> DAO
//			 <- 		<-

//Service
@Service
public class EmpService {

	//Ÿ���� ������ �ڵ����� ������
	@Autowired
	EmpDAO empDAO;
	
	public EmpDTO loginChk(String email, String phone){
		return empDAO.loginChk(email, phone);
	}
	
	public int selectByEmail(String email){
		return empDAO.selectByEmail(email);
	}
	
	public List<HashMap<String,Object>> selectAllManger(){
		return empDAO.selectAllManger();
	}

	// 1.직원 모두 조회
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 2.?��?�� 직원 조회
	public EmpDTO selectById(int empId) throws ClassNotFoundException, SQLException {

		return empDAO.selectById(empId);
	}

	// 3.?��?�� �??�� 직원 조회
	public List<EmpDTO> selectByDepId(int eid) {
		return empDAO.selectByDepId(eid);
	}

	// 4.?��?�� JOB 직원 조회
	public List<EmpDTO> selectByJobId(String jobId) {
		return empDAO.selectByJobId(jobId);
	}

	// 5.?��구하?�� 조건?��?�� ?��?��?��?�� 조회?���?
	// �??���?, 직책�?, ?��?��?���?(>=), 급여(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	// 6.직원 추�?
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}

	// 7.직원 ?��?��
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}

	// 8.직원 ?��?��
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}

	public Map<String, Object> empInfo(int empid){
		return empDAO.empInfo(empid);
	}
	
	public double callFunction(int empid) {
		return empDAO.callFunction(empid);
	}
	
	public List<JobDTO> selectAllJob(){
		return empDAO.selectAllJob();
	}
	
	
}
