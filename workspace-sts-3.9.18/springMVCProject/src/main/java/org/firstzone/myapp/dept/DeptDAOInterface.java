package org.firstzone.myapp.dept;

import java.util.List;

public interface DeptDAOInterface {
	public List<DepDTO> selectAll();
	public DepDTO selectById(int depID);
	public List<DepDTO> selectByName(String DepName);
	public int depInsert(DepDTO dep);
	public int depUpdate(DepDTO dep);
	public int depDelete(int depid);
}
