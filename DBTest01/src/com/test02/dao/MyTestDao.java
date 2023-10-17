package com.test02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test02.dto.MyTest;
import static common.JDBCTemplate.*;

//DB에 연결
public class MyTestDao {

	//select
	public List<MyTest> selectAll(){
		//준비
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MyTest> res = new ArrayList<MyTest>();
		String sql = "SELECT * FROM MYTEST";
		
		//sql 실행 및 결과리턴
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MyTest tmp = new MyTest(rs.getInt(1), rs.getString(2), rs.getString(3));
				res.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rs);
			close(stmt);
			close(con);
		}
		return res;
	}
	//insert
	public int insert(MyTest mytest) {
		//준비
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "INSERT INTO MYTEST VALUES(NULL,?,?)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, mytest.getMname());
			pstm.setString(2, mytest.getNickname());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con);
			close(pstm);
		}
		return res;
	}
	//update
	public int update(MyTest mytest) {
		//준비
				Connection con = getConnection();
				PreparedStatement pstm = null;
				int res = 0;
				
				String sql = "UPDATE MYTEST SET MNAME =?, NICKNAME=? WHERE MNO=?";
				
				try {
					pstm = con.prepareStatement(sql);
					pstm.setString(1, mytest.getMname());
					pstm.setString(2, mytest.getNickname());
					pstm.setInt(3, mytest.getMno());
					
					res = pstm.executeUpdate();
					
					if(res>0) {
						commit(con);
					}else {
						rollback(con);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(con);
					close(pstm);
				}
				return res;
			}
	//delete
	public int delete(int no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "DELETE FROM MYTEST WHERE MNO = ?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);
			
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}
}
