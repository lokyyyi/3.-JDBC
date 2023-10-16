package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. DB 연결
		Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버등록
		
		String url = "jdbc:mysql://localhost:3306/multi";
		String id = "root";
		String pw = "1234";
		
		Connection con = DriverManager.getConnection(url,id,pw); //dbms와 연결
		
		//2.sql실행 및 결과 리턴
		Statement stmt = con.createStatement(); //쿼리 실행 하기 위한 statment객체 생성
		
		String sql = "SELECT * FROM EMPLOYEE;";
		ResultSet rs = stmt.executeQuery(sql);	//쿼리 실행 및 결과값 리턴
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getInt("SALARY"));
		}
		
		//4. db종료
		rs.close();
		stmt.close();
		con.close();
		
		
	}

}
