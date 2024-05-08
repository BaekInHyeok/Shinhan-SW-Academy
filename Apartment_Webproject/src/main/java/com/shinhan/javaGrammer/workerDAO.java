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

public class workerDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst;// Statement를 상속받음, 바인딩 변수 지원
	ResultSet rs;

	// 1.근로자ID로 근로자 검색
	public workerDTO findBYID(int wrkID) {
		workerDTO wrk = null;
		String sql = "select * from worker where worker_id = " + wrkID;
		conn = DBUtil.dbConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				wrk = makeRes(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return wrk;
	}

	// 2.업무명을 입력하여 해당 업무를 하는 근로자들 목록 찾기
	public List<wrkINworkDTO> findByWork(String work) {
		List<wrkINworkDTO> wrkINworklist = new ArrayList<wrkINworkDTO>();
		String sql = "SELECT w.WORKER_NAME, w.WORKER_AGE, w.WORKER_GENDER, w.WORKER_PHONE, f.FACILITY_NAME"
				+ " FROM WORKER w"
				+ " JOIN FACILITY f ON w.WORKER_WORKPLACE_ID = f.FACILITY_ID"
				+ " where w.WORKER_WORK = '"+work+"'";

		conn = DBUtil.dbConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				wrkINworkDTO wrkINwork = makeWrkwork(rs);
				wrkINworklist.add(wrkINwork);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return wrkINworklist;
	}

	// 3.근로자 정보 입력(근로자 추가)
	public int wrkInsert(workerDTO wkr) {
		int result = 0;
		String sql = "insert into worker values(?,?,?,?,?,?,?,?,?)";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, wkr.getWORKER_ID());
			pst.setString(2, wkr.getWORKER_NAME());
			pst.setInt(3, wkr.getWORKER_AGE());
			pst.setString(4, wkr.getWORKER_GENDER());
			pst.setString(5, wkr.getWORKER_PHONE());
			pst.setDate(6, wkr.getWORKER_HIREDATE());
			pst.setInt(7, wkr.getWORKER_WORKPLACE_ID());
			pst.setString(8, wkr.getWORKER_WORK());
			pst.setInt(9, wkr.getWORKER_SALARY());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	// 4.근로자 정보 수정
	public int wrkUpdate(int key, int wrkid, Object obj) {
		int result = 0;
		conn = DBUtil.dbConnection();

		try {

			switch (key) {
			case 1 -> {// 근로자 이름
				String sql = "update worker set worker_name = ? where worker_id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, wrkid);
			}
			case 2 -> {// 근로자 나이
				String sql = "update worker set WORKER_AGE = ? where worker_id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, wrkid);
			}
			case 3 -> {// 근로자 성별
				String sql = "update worker set WORKER_GENDER = ? where worker_id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, wrkid);
			}
			case 4 -> {// 근로자 전화번호
				String sql = "update worker set WORKER_PHONE = ? where worker_id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, wrkid);
			}
			case 5 -> {// 근로자 근무시작일
				String sql = "update worker set WORKER_HIREDATE = ? where worker_id=?";
				pst = conn.prepareStatement(sql);
				pst.setDate(1, (Date) obj);
				pst.setInt(2, wrkid);
			}
			case 6 -> {// 담당시설 ID
				String sql = "update worker set WORKER_WORKPLACE_ID = ? where worker_id=?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, (int) obj);
				pst.setInt(2, wrkid);
			}
			case 7 -> {// 담당업무
				String sql = "update worker set WORKER_WORK = ? where worker_id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, wrkid);
			}
			case 8 -> {// 급여
				String sql = "update worker set WORKER_SALARY = ? where worker_id=?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, (int) obj);
				pst.setInt(2, wrkid);
			}
			default -> {
			}
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

	// 5.근로자 정보 삭제
	public int wrkDelete(int wrkid) {
		int result = 0;

		String sql = "delete from worker where worker_id = ?";

		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, wrkid);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	private workerDTO makeRes(ResultSet rs) throws SQLException {
		workerDTO wrk = new workerDTO();

		wrk.setWORKER_ID(rs.getInt("WORKER_ID"));
		wrk.setWORKER_NAME(rs.getString("WORKER_NAME"));
		wrk.setWORKER_AGE(rs.getInt("WORKER_AGE"));
		wrk.setWORKER_GENDER(rs.getString("WORKER_GENDER"));
		wrk.setWORKER_PHONE(rs.getString("WORKER_PHONE"));
		wrk.setWORKER_HIREDATE(rs.getDate("WORKER_HIREDATE"));
		wrk.setWORKER_WORKPLACE_ID(rs.getInt("WORKER_WORKPLACE_ID"));
		wrk.setWORKER_WORK(rs.getString("WORKER_WORK"));
		wrk.setWORKER_SALARY(rs.getInt("WORKER_SALARY"));
		return wrk;
	}

	private wrkINworkDTO makeWrkwork(ResultSet rs) throws SQLException {
		wrkINworkDTO wrkfac = new wrkINworkDTO();

		wrkfac.setWORKER_NAME(rs.getString("WORKER_NAME"));
		wrkfac.setWORKER_AGE(rs.getInt("WORKER_AGE"));
		wrkfac.setWORKER_GENDER(rs.getString("WORKER_GENDER"));
		wrkfac.setWORKER_PHONE(rs.getString("WORKER_PHONE"));
		wrkfac.setFACILITY_NAME(rs.getString("FACILITY_NAME"));

		return wrkfac;
	}

}
