package com.shinhan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DBUtil {

	public static Connection dbConnection() {
		Context initContext;
		Connection conn=null;
		
		try {
			initContext= new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			
		}catch(NamingException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
		
	}
	//DB 연결
	public static Connection dbConnection2() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hr";
		String password = "hr";
		Connection conn = null;

		// 1.JDBC Driver Load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2.Connection 생성
		try {
			conn = DriverManager.getConnection(url, userid, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return conn;
	}
	
	public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
