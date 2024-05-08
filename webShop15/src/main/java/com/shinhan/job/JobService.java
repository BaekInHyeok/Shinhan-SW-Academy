package com.shinhan.job;

import java.util.HashMap;
import java.util.List;

public class JobService {

	JobDAO jobDAO = new JobDAO();
	
	public List<HashMap<String,Object>> selectAllJob(){
		return jobDAO.selectAllJob();
	}
	
	public List<JobDTO> selectAll(){
		return jobDAO.selectAll();
	}
}
