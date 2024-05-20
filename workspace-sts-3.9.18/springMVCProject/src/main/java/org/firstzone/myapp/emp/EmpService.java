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

	//타입이 같으면 자동으로 인젝션
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

	// 1.吏곸썝 紐⑤몢 議고쉶
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 2.?듅?젙 吏곸썝 議고쉶
	public EmpDTO selectById(int empId) throws ClassNotFoundException, SQLException {

		return empDAO.selectById(empId);
	}

	// 3.?듅?젙 遺??꽌 吏곸썝 議고쉶
	public List<EmpDTO> selectByDepId(int eid) {
		return empDAO.selectByDepId(eid);
	}

	// 4.?듅?젙 JOB 吏곸썝 議고쉶
	public List<EmpDTO> selectByJobId(String jobId) {
		return empDAO.selectByJobId(jobId);
	}

	// 5.?슂援ы븯?뒗 議곌굔?뱾?쓣 ?엯?젰?븯?뿬 議고쉶?븯湲?
	// 遺??꽌蹂?, 吏곸콉蹂?, ?엯?궗?씪蹂?(>=), 湲됱뿬(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	// 6.吏곸썝 異붽?
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}

	// 7.吏곸썝 ?닔?젙
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}

	// 8.吏곸썝 ?궘?젣
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
