package com.shinhan.dept;

import java.sql.SQLException;
import java.util.List;

public class DepService {

	DepDAO depDAO = new DepDAO();

	// 1.전체 부서 조회
	public List<DepDTO> selectAll() {
		return depDAO.selectAll();
	}

	// 2.부서 ID로 검색
	public DepDTO selectById(int depId) throws ClassNotFoundException, SQLException {
		return depDAO.selectById(depId);
	}

	// 3.매니저 ID로 검색
	public DepDTO selectByMId(int mId) {
		// TODO Auto-generated method stub
		return depDAO.selectByMId(mId);
	}

	// 4.부서 추가
	public int depInsert(DepDTO dep) {
		return depDAO.depInsert(dep);
	}

	// 4.부서 추가
	public int depUpdate(DepDTO dep) {
		return depDAO.depUpdate(dep);
	}

	// 4.부서 추가
	public int depDelete(int depid) {
		return depDAO.depDelete(depid);
	}

}
