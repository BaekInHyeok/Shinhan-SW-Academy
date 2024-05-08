package com.shinhan.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.emp.EmpDTO;
import com.shinhan.util.DBUtil;

public class DepDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	// 1.직원 전체 조회
	public List<DepDTO> selectAll() {
		List<DepDTO> deplist = new ArrayList<DepDTO>();
		String sql = "select * from departments";

		try {
			conn = DBUtil.dbConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				DepDTO dep = makeDep(rs);
				deplist.add(dep);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return deplist;
	}

	// 2.부서 ID로 검색
	public DepDTO selectById(int depID) throws ClassNotFoundException, SQLException {

		DepDTO dep = null;

		String sql = "select * from departments where department_id=" + depID;
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				dep = makeDep(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dep;
	}

	// 3.매니저 ID로 부서 검색
	public DepDTO selectByMId(int mId) {
		DepDTO dep = null;
		String sql = "select *from departments where manager_id=" + mId;
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				dep = makeDep(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dep;
	}

	// 4.입력(insert)
	public int depInsert(DepDTO dep) {
		int result = 0;
		String sql = "insert into departments values(?,?,?,?)";
		conn = DBUtil.dbConnection();// 커밋은 자동으로 진행됨 : setAutoComit(true) 상태

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dep.getDEPARTMENT_ID());
			pst.setString(2, dep.getDEPARTMENT_NAME());
			pst.setInt(3, dep.getMANAGER_ID());
			pst.setInt(4, dep.getLOCATION_ID());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	public int depUpdate(DepDTO dep) {
		int result = 0;

		String sql = "update departments set department_name=?, manager_id=?, location_id=? where department_id=?";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(4, dep.getDEPARTMENT_ID());
			pst.setString(1, dep.getDEPARTMENT_NAME());
			pst.setInt(2, dep.getMANAGER_ID());
			pst.setInt(3, dep.getLOCATION_ID());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	public int depDelete(int depid) {
		int result = 0;
		String sql = "delete from departments where department_id=?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, depid);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	private DepDTO makeDep(ResultSet rs2) throws SQLException {
		DepDTO dep = new DepDTO();

		dep.setDEPARTMENT_ID(rs.getInt("department_id"));
		dep.setDEPARTMENT_NAME(rs.getString("department_name"));
		dep.setMANAGER_ID(rs.getInt("manager_id"));
		dep.setLOCATION_ID(rs.getInt("location_id"));
		return dep;
	}

}
