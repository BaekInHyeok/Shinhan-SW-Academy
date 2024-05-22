package org.firstzone.myapp.emp;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmpDAOInterface {
	public EmpDTO loginChk(String email, String phone);
	
	public int selectByEmail(String email);
	
	public List<HashMap<String,Object>> selectAllManager();

	public List<EmpDTO> selectAll();

	public EmpDTO selectById(int empId);

	public List<EmpDTO> selectByDepId(int eid);

	public List<EmpDTO> selectByJobId(String jobId);

	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary);

	public int empInsert(EmpDTO emp);

	public int empUpdate(EmpDTO emp);

	public int empDelete(int empid);

	public Map<String, Object> empInfo(int empid);
	
	public double callFunction(int empid);
	
	public List<JobDTO> selectAllJob();
}
