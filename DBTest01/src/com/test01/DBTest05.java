package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import static common.JDBCTemplate.*;

public class DBTest05 {

	public static void main(String[] args) {
		//삭제 준비
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "DELETE FROM MYTEST WHERE MNAME=?";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 : ");
		String name = sc.next();
		
		//쿼리 실행 및 리턴
		
		try {
			con = getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				System.out.println("DELETE 성공");
				commit(con);
			} else {
				System.out.println("DELETE 실패");
				rollback(con);
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
