package com.shinhan.day14;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.jdbc driver를 class path에 추가
		System.out.println("1.jdbc driver 추가 완료");

		// 2.jcbc 드라이버를 load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("2.oracle driver load 성공");

		// 3.DB 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe", userid = "hr", password = "hr";
		Connection conn = DriverManager.getConnection(url, userid, password);
		System.out.println("3.DB 연결 성공");
		String sql = "select first_name, salary, department_id" + " from employees" + " where salary>=15000";

		// 3.statement:자바와 DB의 대화통로
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			String fname = rs.getString(1);
			int salary = rs.getInt(2);
			int deptid = rs.getInt(3);
			System.out.printf("%-10s\t%d\t%d", fname, salary, deptid);
			System.out.println();
		}
		rs.close();
		st.close();
		conn.close();
	}

}
