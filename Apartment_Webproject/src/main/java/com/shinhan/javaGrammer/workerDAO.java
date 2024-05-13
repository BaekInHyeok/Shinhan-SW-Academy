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
				wrk = makeWrk(rs);
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
		String sql = "SELECT w.WORKER_ID, w.WORKER_NAME, w.WORKER_AGE, w.WORKER_GENDER, w.WORKER_PHONE, f.FACILITY_NAME"
				+ " FROM WORKER w"
				+ " LEFT OUTER JOIN FACILITY f ON w.WORKER_WORKPLACE_ID = f.FACILITY_ID"
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
	public int wrkUpdate(workerDTO wkr) {
		int result = 0;
		conn = DBUtil.dbConnection();

		try {
			String sql = "update worker set WORKER_NAME = ?, WORKER_AGE = ?, WORKER_GENDER = ?, WORKER_PHONE = ?, WORKER_HIREDATE = ?, WORKER_WORKPLACE_ID = ?, WORKER_WORK = ?, WORKER_SALARY = ? where WORKER_ID=?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, wkr.getWORKER_NAME());
			pst.setInt(2, wkr.getWORKER_AGE());
			pst.setString(3, wkr.getWORKER_GENDER());
			pst.setString(4, wkr.getWORKER_PHONE());
			pst.setDate(5, wkr.getWORKER_HIREDATE());
			pst.setInt(6, wkr.getWORKER_WORKPLACE_ID());
			pst.setString(7, wkr.getWORKER_WORK());
			pst.setInt(8, wkr.getWORKER_SALARY());
			pst.setInt(9, wkr.getWORKER_ID());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}
	
	//4-1.관리담당자로 배정받은 근로자의 담당시설ID을 자동으로 바꾸기
	public int mgrUpdate(int mgrID, int facID) {
		int result = 0;
		conn = DBUtil.dbConnection();
		
		String sql = "update worker set WORKER_WORKPLACE_ID = ? where WORKER_ID=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, facID);
			pst.setInt(2, mgrID);
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		
		return result;
	}
	
	//4-2.근무하고 있던 시설이 삭제되는 경우 근로자의 근무시설ID를 0으로 바꾸기
	public int eraseWorkplaceId(int workplaceid) {
		int result=0;
		conn = DBUtil.dbConnection();
		String sql =  "update worker set WORKER_WORKPLACE_ID=0"
				+ " where WORKER_WORKPLACE_ID IN (select facility_id from facility where facility_id=?)";
		
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, workplaceid);
			
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	//6.전체 근로자 목록 출력
	public List<workerDTO> selectAll(){
		List<workerDTO> workerList = new ArrayList<workerDTO>();
		String sql = "select * from worker";
		
		try {
			conn = DBUtil.dbConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				workerDTO wrk = makeWrk(rs);
				workerList.add(wrk);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return workerList;
	}
	
	//6-1.시설 매니저를 맡고 있는 근로자들을 제외한 근로자 목록을 출력하기
	public List<workerDTO> selectNotMgrList(){
		List<workerDTO> workerNotMgrList = new ArrayList<workerDTO>();
		String sql = "SELECT * FROM WORKER WHERE WORKER_ID NOT IN (SELECT FACILITY_MANAGER_ID FROM FACILITY)";
		
		try {
			conn = DBUtil.dbConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				workerDTO wrk = makeWrk(rs);
				workerNotMgrList.add(wrk);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return workerNotMgrList;
	}
	
	//모든 업무명 출력(중복 X)
	public List<String> allWork(){
		List<String> workList = new ArrayList<String>();
		String sql = "select distinct worker_work from worker";
		try {
			conn = DBUtil.dbConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String job = rs.getString("WORKER_WORK");
				workList.add(job);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return workList;
	}
	
	
	

	private workerDTO makeWrk(ResultSet rs) throws SQLException {
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

		wrkfac.setWORKER_ID(rs.getInt("WORKER_ID"));
		wrkfac.setWORKER_NAME(rs.getString("WORKER_NAME"));
		wrkfac.setWORKER_AGE(rs.getInt("WORKER_AGE"));
		wrkfac.setWORKER_GENDER(rs.getString("WORKER_GENDER"));
		wrkfac.setWORKER_PHONE(rs.getString("WORKER_PHONE"));
		wrkfac.setFACILITY_NAME(rs.getString("FACILITY_NAME"));

		return wrkfac;
	}

}
