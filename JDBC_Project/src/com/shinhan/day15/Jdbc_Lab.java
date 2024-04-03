package com.shinhan.day15;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_Lab {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		boolean isStop = false;

		while (!isStop) {
			int selectJob = menu();

			switch (selectJob) {
			case 1 -> {
				String sql = "select salary, hire_date" + " from employees" + " where first_name = initcap('adam')";
				method1(sql);
			}
			case 2 -> {
				String sql = "select region_id from countries where lower(country_name)='united states of america'";
				method2(sql);
			}
			case 3 -> {
				String sql = "select first_name||'의 입사일은 '||hire_date||'이고, 급여는 '||salary||' 입니다.'" + " from employees";
				method3(sql);
			}
			case 4 -> {
				String sql = "select first_name, salary, hire_date" + " from employees" + " where length(first_name)<=";
				method4(sql);
			}
			case 5 -> {
				String sql = "select first_name, hire_date" + " from employees" + " where to_char(hire_date,'yyyy')=";
				method5(sql);
			}
			case 6 -> {
				String sql = "select first_name, hire_date, salary, ceil(MONTHS_BETWEEN(SYSDATE,hire_date)/12)년차"
						+ " from employees" + " where round(MONTHS_BETWEEN(SYSDATE,hire_date)/12,1)>=";
				method6(sql);
			}
			case 7 -> {
				isStop = true;
			}
			default -> {
				System.out.println("입력된 작업은 지원하지 않음. 다시 선택~");
			}
			}
		}
	}

	private static void method6(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = dbConnection();
		Statement st = conn.createStatement();
		System.out.print("근속년수 : ");
		int su = sc.nextInt();
		ResultSet rs = st.executeQuery(sql + su);
		while (rs.next()) {
			String name = rs.getString(1);
			Date hdate = rs.getDate(2);
			int sal = rs.getInt(3);
			int year = rs.getInt(4);

			System.out.println(name + "\t" + hdate + "\t" + sal + "\t" + year);
		}
		dbDisconnect(conn, st, rs);

	}

	private static void method5(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = dbConnection();
		Statement st = conn.createStatement();

		System.out.print("조회년도? : ");
		int su = sc.nextInt();
		ResultSet rs = st.executeQuery(sql + su);
		while (rs.next()) {
			String name = rs.getString(1);
			Date hdate = rs.getDate(2);

			System.out.println(name + "\t" + hdate);
		}
		dbDisconnect(conn, st, rs);
	}

	private static void method4(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = dbConnection();
		Statement st = conn.createStatement();
		System.out.print("몇 글자 이하의 이름을 찾으시나요? : ");
		int su = sc.nextInt();
		ResultSet rs = st.executeQuery(sql + su);
		while (rs.next()) {
			String name = rs.getString(1);
			int sal = rs.getInt(2);
			Date hdate = rs.getDate(3);
			System.out.println(name + "\t" + sal + "\t" + hdate);
		}
		dbDisconnect(conn, st, rs);
	}

	private static void method3(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = dbConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			String result = rs.getString(1);
			System.out.println(result);
		}
		dbDisconnect(conn, st, rs);

	}

	private static void method2(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = dbConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int regionID = rs.getInt("region_id");
			System.out.println(regionID);
		}
		dbDisconnect(conn, st, rs);

	}

	private static void method1(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = dbConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

//		ResultSetMetaData metaData = rs.getMetaData();
//		System.out.println(metaData.getColumnTypeName(1));
//		System.out.println(metaData.getColumnTypeName(2));

		while (rs.next()) {
			int sal = rs.getInt(1);
			Date hdate = rs.getDate(2);
			System.out.println(sal + "\t" + hdate);
		}
		dbDisconnect(conn, st, rs);

	}

	private static void dbDisconnect(Connection conn, Statement st, ResultSet rs) throws SQLException {
		rs.close();
		st.close();
		conn.close();
		System.out.println("3.실행 후 DB 해제");

	}

	private static Connection dbConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hr";
		String password = "hr";
		Connection conn = null;

		// 1.JDBC Driver Load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1.JDBC Driver Load 성공");

		// 2.Connection 생성
		conn = DriverManager.getConnection(url, userid, password);
		System.out.println("2.DB Connection 성공");

		return conn;
	}

	private static int menu() {
		// TODO Auto-generated method stub

		System.out.println("===============================================================");
		System.out.println("1.INITCAP 2.lower 3.concat 4.length 5.to_char 6.months_between 7.End");
		System.out.print("작업 선택 >");
		int job = sc.nextInt();
		System.out.println("===============================================================");

		return job;

	}

}
