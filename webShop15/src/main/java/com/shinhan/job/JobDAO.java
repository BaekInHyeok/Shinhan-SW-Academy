package com.shinhan.job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.shinhan.emp.EmpDTO;
import com.shinhan.util.DBUtil;

public class JobDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;// Statement를 상속받음, 바인딩 변수 지원
	ResultSet rs;
	
	//전체 job에 대한 id와 이름만 조회
	public List<HashMap<String,Object>> selectAllJob(){
		List<HashMap<String,Object>> joblist = new ArrayList<HashMap<String,Object>>();
		String sql ="select job_id, job_title from jobs";
		
		try {
			conn = DBUtil.dbConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				HashMap<String,Object> data = new HashMap<String, Object>();
				data.put("job_id", rs.getString(1));
				data.put("job_title", rs.getString(2));
				joblist.add(data);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return joblist;
	}
	
	public List<JobDTO> selectAll(){
		List<JobDTO> jlist = new ArrayList<JobDTO>();
		
		String sql = "select * from jobs";
		
		try {
			conn = DBUtil.dbConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				JobDTO job = makeJob(rs);
				jlist.add(job);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return jlist;
		
	}

	private JobDTO makeJob(ResultSet rs) throws SQLException{
		JobDTO job = new JobDTO();
		
		job.setJOB_ID(rs.getString("JOB_ID"));
		job.setJOB_TITLE(rs.getString("JOB_TITLE"));
		job.setMIN_SALARY(rs.getInt("MIN_SALARY"));
		job.setMAX_SALARY(rs.getInt("MAX_SALARY"));
		
		return job;
	}


}
