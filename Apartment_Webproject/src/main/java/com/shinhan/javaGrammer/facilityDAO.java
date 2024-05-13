package com.shinhan.javaGrammer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

public class facilityDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst;// Statement를 상속받음, 바인딩 변수 지원
	ResultSet rs;

	// 1.시설ID를 입력하면 시설 정보를 출력
	public facilityDTO findBYID(int facID) {
		facilityDTO fac = null;

		String sql = "SELECT F.FACILITY_ID,F.FACILITY_NAME,F.FACILITY_DATE,F.FACILITY_TYPE,F.FACILITY_START_TIME,F.FACILITY_END_TIME,F.FACILITY_MANAGER_ID"
				+ " FROM FACILITY F" + " where f.facility_id=" + facID;
		conn = DBUtil.dbConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				fac = makeFac(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return fac;
	}

	// 1-1.시설 매니저ID를 입력하면 시설 정보를 출력
	public facilityDTO findBYMgrID(int mgrID) {
		facilityDTO fac = null;

		String sql = "SELECT * FROM FACILITY F where F.FACILITY_MANAGER_ID=" + mgrID;
		conn = DBUtil.dbConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				fac = makeFac(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return fac;
	}

	// 2.시설명을 입력하여 해당 시설의 근무자들에 대한 정보를 출력하기
	public List<wrkINfacDTO> findBYfacname(String facname) {
		List<wrkINfacDTO> wrkINfaclist = new ArrayList<wrkINfacDTO>();

		String sql = "SELECT * FROM WORKER w where w.worker_workplace_id= (select facility.facility_id"
				+ " from facility" + " where facility.facility_name='" + facname + "')";

		conn = DBUtil.dbConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				wrkINfacDTO wrkINfac = makeWrkINFac(rs);
				wrkINfaclist.add(wrkINfac);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return wrkINfaclist;

	}

	// 3.시설 정보 입력(시설 추가)
	public int facInsert(facilityDTO fac) {
		int result = 0;

		String sql = "insert into facility values(?,?,?,?,?,?,?)";

		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, fac.getFacility_id());
			pst.setString(2, fac.getFacility_name());
			pst.setDate(3, fac.getFacility_date());
			pst.setString(4, fac.getFacility_type());
			pst.setString(5, fac.getFacility_start_time());
			pst.setString(6, fac.getFacility_end_time());
			pst.setInt(7, fac.getFacility_manager_id());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	// 4. 시설 정보 수정
	public int facUpdate(facilityDTO fac) {
		int result = 0;
		conn = DBUtil.dbConnection();
		try {
			String sql = "update facility set facility_name = ?, facility_date = ?, facility_type = ?, facility_start_time = ?, facility_end_time = ?, facility_manager_id = ? where facility_id = ?";
			pst = conn.prepareStatement(sql);

			pst.setString(1, fac.getFacility_name());
			pst.setDate(2, fac.getFacility_date());
			pst.setString(3, fac.getFacility_type());
			pst.setString(4, fac.getFacility_start_time());
			pst.setString(5, fac.getFacility_end_time());
			pst.setInt(6, fac.getFacility_manager_id());
			pst.setInt(7, fac.getFacility_id());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	// 4-1.해당 시설의 매니저가 다른 시설로 이동할 경우 시설의 매니저 ID 값을 0으로 변경
	public int eraseMgrId(int mgrid) {
		int result = 0;
		conn = DBUtil.dbConnection();
		try {
			String sql = "UPDATE FACILITY" + " SET FACILITY_MANAGER_ID = 0"
					+ " WHERE FACILITY_MANAGER_ID IN (SELECT WORKER_ID FROM WORKER where WORKER_ID=?)";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, mgrid);

			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	// 5. 시설 정보 삭제
	public int facDelete(int facID) {
		int result = 0;

		String sql = "delete from facility where facility_id = ?";

		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, facID);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	// 6.공용시설 전체 목록
	public List<facilityDTO> selectAll() {
		List<facilityDTO> facList = new ArrayList<facilityDTO>();
		String sql = "select * from facility order by facility_id";

		try {
			conn = DBUtil.dbConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				facilityDTO fac = makeFac(rs);
				facList.add(fac);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return facList;
	}

	private facilityDTO makeFac(ResultSet rs) throws SQLException {
		facilityDTO fac = new facilityDTO();

		fac.setFacility_id(rs.getInt("facility_id"));
		fac.setFacility_name(rs.getString("facility_name"));
		;
		fac.setFacility_date(rs.getDate("facility_date"));
		fac.setFacility_type(rs.getString("facility_type"));
		fac.setFacility_start_time(rs.getString("facility_start_time"));
		fac.setFacility_end_time(rs.getString("facility_end_time"));
		fac.setFacility_manager_id(rs.getInt("facility_manager_id"));

		return fac;
	}

	private wrkINfacDTO makeWrkINFac(ResultSet rs) throws SQLException {
		wrkINfacDTO wrkINfac = new wrkINfacDTO();

		wrkINfac.setWORKER_ID(rs.getInt("WORKER_ID"));
		wrkINfac.setWORKER_NAME(rs.getString("WORKER_NAME"));
		wrkINfac.setWORKER_AGE(rs.getInt("WORKER_AGE"));
		wrkINfac.setWORKER_GENDER(rs.getString("WORKER_GENDER"));
		wrkINfac.setWORKER_PHONE(rs.getString("WORKER_PHONE"));
		wrkINfac.setWORKER_WORK(rs.getString("WORKER_WORK"));

		return wrkINfac;

	}

	private facwnameDTO makefacWname(ResultSet rs) throws SQLException {
		facwnameDTO facWname = new facwnameDTO();

		facWname.setFacility_name(rs.getString("facility_name"));
		facWname.setFacility_type(rs.getString("facility_type"));
		facWname.setFacility_start_time(rs.getString("facility_start_time"));
		facWname.setFacility_end_time(rs.getString("facility_end_time"));
		facWname.setWorker_name(rs.getString("worker_name"));
		return facWname;
	}
}
