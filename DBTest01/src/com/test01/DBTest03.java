package com.test01;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import common.JDBCTemplate;

public class DBTest03 extends JDBCTemplate{

	public static void main(String[] args) {
		//키보드로 입력받은 내용을 db에 저장(insert)
		
		DBTest03 dt = new DBTest03();
		dt.insert();
		dt.select();
		
	}
	
	public void insert() {
		//준비
		Connection con = null;
		Statement stmt = null;
		//ResultSet 준비 안함 > because insert할거기때문
		int res = 0; //dml실행 후 정수를(적용된 row의 숫자) 리턴받는다.
		
		Scanner sc = new Scanner(System.in);
		
		int no = 0;
		String name = null;
		String nickName = null;
		
		System.out.println("번호 : ");
		no = sc.nextInt();
		System.out.println("이름 : ");
		name = sc.next();
		System.out.println("별명 : ");
		nickName = sc.next();
		
		String sql = "INSERT INTO MYTEST VALUES(" + no + ", '" + name + "', '" + nickName + "')";
		
		
		try {
			//1. db 연결
			con = getConnection();
			stmt = con.createStatement();
			res = stmt.executeUpdate(sql);
			
			//3. 실행결과 처리
			if(res>0) {
				System.out.println("insert 성공");
			}else {
				System.out.println("insert 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//4. db종료
			close(stmt);
			close(con);
			sc.close();
		}
	}
	
	public void select() {
		//준비
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MYTEST";
		
		
		try {
			//DB연결
			con = getConnection();
			//쿼리 실행 및 리턴
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			//결과 처리
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//db종료
			close(rs);
			close(stmt);
			close(con);
		}
	}
}
