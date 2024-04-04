package com.shinhan.day15;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Controller -> Service -> DAO
//			 <- 		<-

//Service : 비즈니스 로직을 수행함
public class EmpService {

	EmpDAO empDAO = new EmpDAO();
	
	//직원 모두 조회
	public List<EmpDTO> selectAll(){
		return empDAO.selectAll();
	}
	
	//특정 직원 조회
	public EmpDTO selectById(int empId) throws ClassNotFoundException, SQLException {
	
		return empDAO.selectById(empId);
	}
	
	
	//특정 부서 직원 조회
	public List<EmpDTO> selectByDepId(int eid){
		return empDAO.selectByDepId(eid);
	}

	public List<EmpDTO> selectByJobId(String jobId) {
		return empDAO.selectByJobId(jobId);
	}

}
