package org.firstzone.myapp.dept;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.util.DBUtil;

@Repository("depmybatis")//Á¤ÀÇ
public class DepDAOMybatis implements DeptDAOInterface {
	@Autowired
	SqlSession sqlSession;
	
	Logger logger = LoggerFactory.getLogger(DepDAOMybatis.class);
	String namespace = "org.firstzone.myapp.dept.";
	
	public List<DepDTO> selectAll() {
		logger.info("DepDAOMybatis...selectAll()");
		return sqlSession.selectList(namespace+"selectAll");
	}

	public DepDTO selectById(int depID){
		logger.info("DepDAOMybatis...selectById()");
		return sqlSession.selectOne(namespace+"selectById",depID);
	}
	public List<DepDTO> selectByName(String DepName){
		logger.info("DepDAOMybatis...selectByName()");
		return sqlSession.selectList(namespace+"selectByName", DepName);
	}

	public int depInsert(DepDTO dep) {
		logger.info("DepDAOMybatis...depInsert()");
		return sqlSession.insert(namespace+"deptInsert", dep);
	}

	public int depUpdate(DepDTO dep) {
		logger.info("DepDAOMybatis...depUpdate()");
		return sqlSession.update(namespace+"deptUpdate", dep);
	}

	public int depDelete(int depid) {
		logger.info("DepDAOMybatis...depDelete()");
		return sqlSession.delete(namespace+"deptDelete", depid);
	}

}
