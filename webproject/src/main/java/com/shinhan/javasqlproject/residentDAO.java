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

//DAO(Data Access하는 비즈니스 로직을 처리하는 object)
public class residentDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst;// Statement를 상속받음, 바인딩 변수 지원
	ResultSet rs;

	// 1.주민 ID로 주민 정보 조회
	public residentDTO findBYID(int resID) {
		residentDTO res = null;
		String sql = "select * from resident where resident_id = " + resID;
		conn = DBUtil.dbConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				res = makeRes(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}

		return res;
	}

	// 2.동별 주민 목록 조회
	public List<residentDTO> findBYDONG(int resDONG) {
		List<residentDTO> reslist = new ArrayList<residentDTO>();
		String sql = "select * from resident where resident_dong = ? order by resident_ho";

		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, resDONG);
			rs = pst.executeQuery();

			while (rs.next()) {
				residentDTO res = makeRes(rs);
				reslist.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return reslist;

	}

	// 3.주민 정보 입력 시 같은 동과 호에서 세대주가 한 명만 존재하도록 하기
	public int resInsert2(residentDTO res) {
		int result = 0;

		conn = DBUtil.dbConnection();

		String sql = "insert into resident values(?,?,?,?,?,?,?,?,?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, res.getResident_id());
			pst.setString(2, res.getResident_name());
			pst.setString(3, res.getResident_phone());
			pst.setInt(4, res.getResident_dong());
			pst.setInt(5, res.getResident_ho());
			pst.setDate(6, res.getResident_date());
			pst.setString(7, res.getResident_car());
			pst.setString(8, res.getResident_fee());
			pst.setInt(9, res.getResident_owner());

			result = pst.executeUpdate();

			if (result == 0) {
				try {
					throw new CustomException("해당 세대에는 이미 세대주가 있습니다.");
				} catch (CustomException e) {

//					e.getMessage();
				}
			}
		} catch (SQLException e) {// 여기서 세대주 중복에 대한 커스텀 예외처리
			System.out.println(e.getMessage());
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	// 4.주민 정보 수정 : 항목 선택해서 업데이트하기
	public int resUpdate(int key, int resid, Object obj) {
		int result = 0;
		conn = DBUtil.dbConnection();
		try {

			switch (key) {
			case 1 -> {// 주민이름
				String sql = "update resident set resident_name = ? where resident_id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, resid);
			}
			case 2 -> {// 주민 H.P
				String sql = "update resident set resident_phone = ? where resident_id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, resid);
			}
			case 3 -> {// 동
				String sql = "update resident set resident_dong = ? where resident_id=?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, (int) obj);
				pst.setInt(2, resid);
			}
			case 4 -> {// 호수
				String sql = "update resident set resident_ho = ? where resident_id=?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, (int) obj);
				pst.setInt(2, resid);
			}
			case 5 -> {// 입주일자
				String sql = "update resident set resident_date = ? where resident_id=?";
				pst = conn.prepareStatement(sql);
				pst.setDate(1, (Date) obj);
				pst.setInt(2, resid);
			}
			case 6 -> {// 세대주 여부
				String sql = "update resident set resident_owner = ? where resident_id=?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, (int) obj);
				pst.setInt(2, resid);
			}
			case 7 -> {// 보유 차량 수
				String sql = "update resident set resident_car = ? where resident_id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, resid);
			}
			case 8 -> {// 관리비
				String sql = "update resident set resident_fee = ? where resident_id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.toString());
				pst.setInt(2, resid);
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

	// 5.주민 정보 삭제
	public int resDelete(int resID) {
		int result = 0;

		String sql = "delete from resident where resident_id = ?";

		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, resID);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	// 6.세대주 중복을 막기 위해 세대주 존재 여부 확인
	public int isOwnerExist(int dong, int ho) {
		int isExist = 0;
		String sql = "select resident_owner" + " from resident" + " where RESIDENT_DONG = ? and RESIDENT_HO = ?";

		return isExist;
	}

	private residentDTO makeRes(ResultSet rs) throws SQLException {
		residentDTO res = new residentDTO();

		res.setResident_id(rs.getInt("resident_id"));
		res.setResident_name(rs.getString("resident_name"));
		res.setResident_phone(rs.getString("resident_phone"));
		res.setResident_dong(rs.getInt("resident_dong"));
		res.setResident_ho(rs.getInt("resident_ho"));
		res.setResident_date(rs.getDate("resident_date"));
		res.setResident_car(rs.getString("resident_car"));
		res.setResident_fee(rs.getString("resident_fee"));
		res.setResident_owner(rs.getInt("resident_owner"));

		return res;

	}
	
	class CustomException extends Exception{
		public CustomException() {
			super();
		}

		public CustomException(String string) {
			super(string);
		}
	}

}
