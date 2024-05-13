package com.shinhan.javaGrammer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.shinhan.util.DBUtil;
import com.shinhan.util.DateUtil;

public class storeDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst;// Statement를 상속받음, 바인딩 변수 지원
	ResultSet rs;

	public List<storeDTO> selectAll(){
		List<storeDTO> strlist = new ArrayList<storeDTO>();
		String sql = "select * from store";

		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				storeDTO str = makeRs(rs);
				strlist.add(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return strlist;
	}
	
	// 1.상점ID로 상점 정보 조회
	public storeDTO findBYID(int strID) {
		storeDTO str = null;
		String sql = "select * from store where store_id =" + strID;

		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				str = makeRs(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return str;

	}

	// 2.업종명을 입력하여 리스트 출력
	public List<storeDTO> findByType(String type) {
		List<storeDTO> strlist = new ArrayList<storeDTO>();
		String sql = "select * from store where store_type=? order by store_name";

		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, type);
			rs = pst.executeQuery();

			while (rs.next()) {
				storeDTO str = makeRs(rs);
				strlist.add(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return strlist;
	}

	// 3.상가 정보 입력(상점 추가)
	public int strInsert(storeDTO str) {
		int result = 0;

		String sql = "insert into store values(?,?,?,?,?,?,?,?,?)";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, str.getSTORE_ID());
			pst.setString(2, str.getSTORE_BUSSINESS_NUMBER());
			pst.setString(3, str.getSTORE_NAME());
			pst.setString(4, str.getSTORE_OWNER());
			pst.setString(5, str.getSTORE_PHONE());
			pst.setString(6, str.getSTORE_TYPE());
			pst.setDate(7, str.getSTORE_STARTDATE());
			pst.setString(8, str.getSTORE_START_TIME());
			pst.setString(9, str.getSTORE_END_TIME());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;

	}

	// 4.상가 정보 수정
	public int strUpdate(storeDTO str) {
		int result = 0;
		conn = DBUtil.dbConnection();
		try {
			String sql = "update store set store_bussiness_number = ?, store_name=?, store_owner=?, store_phone=?, store_type=?, store_startdate=?, store_start_time=?, store_end_time=? where store_id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, str.getSTORE_BUSSINESS_NUMBER());
			pst.setString(2, str.getSTORE_NAME());
			pst.setString(3, str.getSTORE_OWNER());
			pst.setString(4, str.getSTORE_PHONE());
			pst.setString(5, str.getSTORE_TYPE());
			pst.setDate(6, str.getSTORE_STARTDATE());
			pst.setString(7, str.getSTORE_START_TIME());
			pst.setString(8, str.getSTORE_END_TIME());
			pst.setInt(9, str.getSTORE_ID());
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 5.상점 정보 삭제
	public int strDelete(int strID) {
		int result = 0;
		String sql = "delete from store where store_id=?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, strID);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	public List<storeDTO> findISOpen() {

		Date today = new Date();
		// 날짜 형식 지정
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 현재 날짜를 문자열로 변환
		String todayStr = dateFormat.format(today);

		List<storeDTO> OpenedStoreList = new ArrayList<storeDTO>();
		String sql = "SELECT * FROM STORE";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				storeDTO str = makeRs(rs);
				String start_time = str.getSTORE_START_TIME();//영업시작시각
				String end_time = str.getSTORE_END_TIME();//영업종료시각
				
				String daystart = todayStr + " " + start_time;//오늘날짜+영업시작시각
				String dayend = todayStr + " " + end_time;//오늘날짜+영업종료시각

				//Timestamp로 변환
				Timestamp start = DateUtil.getSQLDateTime(daystart);
				Timestamp end = DateUtil.getSQLDateTime(dayend);
				
				//야간 영업을 하는 경우에 영업종료시간의 날짜를 다음 날짜로 이동 
				if(end.before(start)) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(end);
					
					cal.add(Calendar.DAY_OF_MONTH, 1);
					
					end = new java.sql.Timestamp(cal.getTimeInMillis());
				}

				// 현재 시간을 Timestamp 형태로 가져오기
				Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
				
				//비교해서 현재시각이 두 시각 사이일 경우에 리스트에 넣기
				boolean isBetween = currentTimestamp.after(start) && currentTimestamp.before(end);

				if(isBetween) {
					OpenedStoreList.add(str);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return OpenedStoreList;
	}

	//모든 상점 유형 출력(중복 X)
	public List<String> allType(){
		List<String> typeList = new ArrayList<String>();
		String sql = "select distinct store_type from store";
		
		try {
			conn = DBUtil.dbConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String type = rs.getString("STORE_TYPE");
				typeList.add(type);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return typeList;
	}
	
	private storeDTO makeRs(ResultSet rs) throws SQLException {
		storeDTO str = new storeDTO();

		str.setSTORE_ID(rs.getInt("store_id"));
		str.setSTORE_NAME(rs.getString("store_name"));
		str.setSTORE_BUSSINESS_NUMBER(rs.getString("store_bussiness_number"));
		str.setSTORE_OWNER(rs.getString("store_owner"));
		str.setSTORE_PHONE(rs.getString("STORE_PHONE"));
		str.setSTORE_TYPE(rs.getString("store_type"));
		str.setSTORE_STARTDATE(rs.getDate("store_startdate"));
		str.setSTORE_START_TIME(rs.getString("store_start_time"));
		str.setSTORE_END_TIME(rs.getString("store_end_time"));

		return str;
	}

}
