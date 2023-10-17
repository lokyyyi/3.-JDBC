package com.homework02.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	
	public static Connection getConnection() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("[1] 드라이버 등록 실패");
				e.printStackTrace();
			}		
			String url = "jdbc:mysql://localhost:3306/multi";
			String id = "root";
			String pw = "1234";
			
			Connection con = null;
			
			try {
				con = DriverManager.getConnection(url,id,pw);
				con.setAutoCommit(false);
			} catch (SQLException e) {
				System.out.println("[error]db 연결 실패");
				e.printStackTrace();
			}
		return con;
		}
		
		public static void close(Connection con) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("[error]Connection close 에러");
				e.printStackTrace();
			}
		}
		
		public static void close(Statement stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("[error]Statement close 에러");
				e.printStackTrace();
			}
		}
		public static void close(ResultSet rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("[error]ResultSet close 에러");
				e.printStackTrace();
			}
		}
		
		public static void commit(Connection con) {
			try {
				con.commit();
			} catch(SQLException e	) {
				System.out.println("[error] commit 에러");
				e.printStackTrace();
			}
		}
		public static void rollback(Connection con) {
			try {
				con.rollback();
			} catch (SQLException e) {
				System.out.println("[error] rollback 에러");
				e.printStackTrace();
			}
		}
}
