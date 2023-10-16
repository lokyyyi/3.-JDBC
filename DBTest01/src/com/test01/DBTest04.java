package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static common.JDBCTemplate.*;

public class DBTest04 {

	public static void main(String[] args) {
		//mytest 테이블에 데이터 insert
		
	
		
		//준비
		Connection con = null;
		PreparedStatement pstm = null;
		
		int res = 0;
		String sql = "INSERT INTO MYTEST VALUES(?,?,?)";
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 : ");
		int no = sc.nextInt();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("별명 : ");
		String nickName = sc.next();
		
	
		try {
			//db연결
			con = getConnection();
			//sql 실행 및 결과 리턴
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);
			pstm.setString(2, name);
			pstm.setString(3, nickName);
			// -- query 준비 완료
			res = pstm.executeUpdate();
			if(res>0) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstm);
			sc.close();
		}
		
	}


}
