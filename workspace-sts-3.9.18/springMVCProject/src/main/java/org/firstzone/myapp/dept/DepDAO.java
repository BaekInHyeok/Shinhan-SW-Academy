package org.firstzone.myapp.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.util.DBUtil;

@Repository
public class DepDAO {

	@Autowired
	@Qualifier("dataSource")
	DataSource ds;
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	public List<DepDTO> selectAll() {
		List<DepDTO> deplist = new ArrayList<DepDTO>();
		String sql = "select * from departments";

		try {
			conn = ds.getConnection();
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

	// 2.ë¶??„œ IDë¡? ê²??ƒ‰
	public DepDTO selectById(int depID){

		DepDTO dep = null;

		String sql = "select * from departments where department_id=" + depID;
		
		try {
			conn = ds.getConnection();
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

	// 3.ë§¤ë‹ˆ?? IDë¡? ë¶??„œ ê²??ƒ‰
	public DepDTO selectByMId(int mId) {
		DepDTO dep = null;
		String sql = "select *from departments where manager_id=" + mId;
		
		try {
			conn = ds.getConnection();
			st= conn.createStatement();
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

	// 4.?ž…? ¥(insert)
	public int depInsert(DepDTO dep) {
		int result = 0;
		String sql = "insert into departments values(?,?,?,?)";
		

		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dep.getDepartment_id());
			pst.setString(2, dep.getDepartment_name());
			pst.setInt(3, dep.getManager_id());
			pst.setInt(4, dep.getLocation_id());

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

		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(4, dep.getDepartment_id());
			pst.setString(1, dep.getDepartment_name());
			pst.setInt(2, dep.getManager_id());
			pst.setInt(3, dep.getLocation_id());
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
		try {
			conn = ds.getConnection();
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

		dep.setDepartment_id(rs.getInt("department_id"));
		dep.setDepartment_name(rs.getString("department_name"));
		dep.setManager_id(rs.getInt("manager_id"));
		dep.setLocation_id(rs.getInt("location_id"));
		return dep;
	}

}
