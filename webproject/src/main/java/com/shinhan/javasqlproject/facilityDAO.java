package com.shinhan.javasqlproject;

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

	// 1.시설ID를 입력하면 시설 정보를 출력하되, 매니저의 ID 대신 매니저의 이름을 출력
	public facwnameDTO findBYID(int facID) {
		facwnameDTO facWname = null;
		
		String sql="SELECT F.FACILITY_NAME,F.FACILITY_TYPE,F.FACILITY_START_TIME,F.FACILITY_END_TIME,W.WORKER_NAME"
				+ " FROM FACILITY F, WORKER W"
				+ " where f.facility_manager_id = w.worker_id and f.facility_id="+facID;
		conn = DBUtil.dbConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				facWname = makefacWname(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return facWname;
	}

	// 2.시설명을 입력하여 해당 시설의 근무자들에 대한 정보를 출력하기
	public List<wrkINfacDTO> findBYfacname(String facname) {
		List<wrkINfacDTO> wrkINfaclist = new ArrayList<wrkINfacDTO>();

		String sql = "SELECT w.WORKER_NAME, w.WORKER_AGE, w.WORKER_GENDER, w.WORKER_PHONE, w.WORKER_WORK"
				+ " FROM WORKER w"
				+ " where w.worker_workplace_id="
				+ " (select facility.facility_id"
				+ " from facility"
				+ " where facility.facility_name='"+facname+"')";

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
	public int facUpdate(int key, int facid, Object obj) {
		int result = 0;
		conn = DBUtil.dbConnection();
		try {
			switch (key) {
			case 1 -> {
				String sql = "update facility set facility_name = ? where facility_id =?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, facid);
			}
			case 2 -> {
				String sql = "update facility set facility_date = ? where facility_id =?";
				pst = conn.prepareStatement(sql);
				pst.setDate(1, (Date) obj);
				pst.setInt(2, facid);
			}
			case 3 -> {
				String sql = "update facility set facility_type = ? where facility_id =?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, facid);
			}
			case 4 -> {
				String sql = "update facility set facility_start_time = ? where facility_id =?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, facid);
			}
			case 5 -> {
				String sql = "update facility set facility_end_time = ? where facility_id =?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, facid);
			}
			case 6 -> {
				String sql = "update facility set facility_manager_id = ? where facility_id =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, (int) obj);
				pst.setInt(2, facid);
			}
			default -> {}
			}
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

	private wrkINfacDTO makeWrkINFac(ResultSet rs) throws SQLException {
		wrkINfacDTO wrkINfac = new wrkINfacDTO();

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
