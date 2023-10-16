package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//연결
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multi"
				, "root", "1234");
		
		//sql 실행 및 리턴
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM DEPARTMENT");
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+ " : " + rs.getString(2) + "\t[" + rs.getString("LOCATION_ID") +"]");
		}
		
		//종료
		rs.close();
		stmt.close();
		con.close();
		
		

	}

}
