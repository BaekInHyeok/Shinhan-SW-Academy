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
	EmpDAOMybatis empDAO;
	
	public EmpDTO loginChk(String email, String phone){
		return empDAO.loginChk(email, phone);
	}
	
	public int selectByEmail(String email){
		return empDAO.selectByEmail(email);
	}
	
	public List<HashMap<String,Object>> selectAllManager(){
		return empDAO.selectAllManager();
	}

	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	public EmpDTO selectById(int empId) throws ClassNotFoundException, SQLException {

		return empDAO.selectById(empId);
	}

	public List<EmpDTO> selectByDepId(int eid) {
		return empDAO.selectByDepId(eid);
	}

	public List<EmpDTO> selectByJobId(String jobId) {
		return empDAO.selectByJobId(jobId);
	}

	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}

	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}

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
