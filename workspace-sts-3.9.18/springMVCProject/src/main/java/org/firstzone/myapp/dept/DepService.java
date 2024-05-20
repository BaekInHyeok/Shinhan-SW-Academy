package org.firstzone.myapp.dept;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepService {

	@Autowired
	DepDAO depDAO;

	// 1.?���? �??�� 조회
	public List<DepDTO> selectAll() {
		return depDAO.selectAll();
	}

	// 2.�??�� ID�? �??��
	public DepDTO selectById(int depId){
		return depDAO.selectById(depId);
	}

	// 3.매니?? ID�? �??��
	public DepDTO selectByMId(int mId) {
		// TODO Auto-generated method stub
		return depDAO.selectByMId(mId);
	}

	// 4.�??�� 추�?
	public int depInsert(DepDTO dep) {
		return depDAO.depInsert(dep);
	}

	// 4.�??�� 추�?
	public int depUpdate(DepDTO dep) {
		return depDAO.depUpdate(dep);
	}

	// 4.�??�� 추�?
	public int depDelete(int depid) {
		return depDAO.depDelete(depid);
	}

}
