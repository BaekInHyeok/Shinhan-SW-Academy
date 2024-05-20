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

	//Å¸ÀÔÀÌ °°À¸¸é ÀÚµ¿À¸·Î ÀÎÁ§¼Ç
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

	// 1.ì§ì› ëª¨ë‘ ì¡°íšŒ
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 2.?Š¹? • ì§ì› ì¡°íšŒ
	public EmpDTO selectById(int empId) throws ClassNotFoundException, SQLException {

		return empDAO.selectById(empId);
	}

	// 3.?Š¹? • ë¶??„œ ì§ì› ì¡°íšŒ
	public List<EmpDTO> selectByDepId(int eid) {
		return empDAO.selectByDepId(eid);
	}

	// 4.?Š¹? • JOB ì§ì› ì¡°íšŒ
	public List<EmpDTO> selectByJobId(String jobId) {
		return empDAO.selectByJobId(jobId);
	}

	// 5.?š”êµ¬í•˜?Š” ì¡°ê±´?“¤?„ ?…? ¥?•˜?—¬ ì¡°íšŒ?•˜ê¸?
	// ë¶??„œë³?, ì§ì±…ë³?, ?…?‚¬?¼ë³?(>=), ê¸‰ì—¬(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	// 6.ì§ì› ì¶”ê?
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}

	// 7.ì§ì› ?ˆ˜? •
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}

	// 8.ì§ì› ?‚­? œ
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
