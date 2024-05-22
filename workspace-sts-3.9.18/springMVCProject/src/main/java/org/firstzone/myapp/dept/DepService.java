package org.firstzone.myapp.dept;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DepService {

	@Autowired
	@Qualifier("depmybatis")
	DeptDAOInterface depDAO;

	public List<DepDTO> selectAll() {
		
		
		return depDAO.selectAll();
	}

	
	public DepDTO selectById(int depId){
		return depDAO.selectById(depId);
	}

	
	public int depInsert(DepDTO dep) {
		return depDAO.depInsert(dep);
	}

	
	public int depUpdate(DepDTO dep) {
		return depDAO.depUpdate(dep);
	}

	
	public int depDelete(int depid) {
		return depDAO.depDelete(depid);
	}

}
