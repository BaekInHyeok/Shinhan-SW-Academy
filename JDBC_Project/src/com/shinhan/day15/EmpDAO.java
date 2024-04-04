package com.shinhan.day15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

//DAO(Data Access하는 비즈니스 로직을 처리하는 object)
public class EmpDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst;//Statement를 상속받음, 바인딩 변수 지원
	ResultSet rs;

	// 1.직원 전체 조회
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees";

		try {
			conn = DBUtil.dbConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}

	// 2.특정 직원에 대한 상세보기
	public EmpDTO selectById(int empId) throws ClassNotFoundException, SQLException {
		EmpDTO emp = null;

		String sql = "select * from employees where employee_id=" + empId;
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	// 3. 특정 부서의 전체 직원 목록 조회
	public List<EmpDTO> selectByDepId(int eid) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		String sql = "select * from employees where department_id=?" ;

		try {
			conn = DBUtil.dbConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, eid);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return emplist;
	}

	// 4. 특정 Job 직원 목록 조회
	public List<EmpDTO> selectByJobId(String jobId) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
//		String sql = "select * from employees where job_id=" + "'" + jobId + "'";
		String sql = "select * from employees where job_id= ?||'%'";//?는 바인딩 변수

		try {
			conn = DBUtil.dbConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1,jobId);//첫 번째 ?에 jobId를 넣어라.
			rs=pst.executeQuery();
			
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return emplist;
	}

	private EmpDTO makeEmp(ResultSet rs) throws SQLException {
		EmpDTO emp = new EmpDTO();

		emp.setCommission_pct(rs.getDouble("commission_pct"));
		emp.setDepartment_id(rs.getInt("department_id"));
		emp.setEmail(rs.getString("email"));
		emp.setEmployee_id(rs.getInt("employee_id"));
		emp.setFirst_name(rs.getString("first_name"));
		emp.setHire_date(rs.getDate("hire_date"));
		emp.setJob_id(rs.getString("job_id"));
		emp.setLast_name(rs.getString("last_name"));
		emp.setManager_id(rs.getInt("manager_id"));
		emp.setPhone_number(rs.getString("phone_number"));
		emp.setSalary(rs.getInt("salary"));

		return emp;
	}

	// 특정 부서 근무 직원 조회

	// 입력
	// 수정
	// 삭제

}
