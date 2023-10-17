package com.homework02.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.homework02.dto.Board;
import static com.homework02.connection.Connect.*;

public class Run {

	public static void main(String[] args) {
		int no = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println();
			System.out.println("****[메뉴]****");
			System.out.println("1. 전체출력");
			System.out.println("2. 추가");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			System.out.println();
			
			System.out.println("번호 선택: ");
			no = sc.nextInt();
			
			switch(no) {
				case 1:
					List<Board> list = selectAll();
					System.out.println("****전체출력****");
					for(Board board : list) {
						System.out.printf("%-2d %-7s\t %-5s\t %-15s\t %-10s\n", board.getBoardno(), board.getBoardtitle(),
								board.getBoardwriter(), board.getBoardcontent(), board.getBoarddate());
					}
					break;
				case 2:
					insert();
					break;
				case 3:
					update();
					break;
				case 4:
					delete();
					break;
				case 5:
					System.out.println("프로그램 종료");
					break;
			}
		} while(no != 5);
	}
	
	public static List<Board> selectAll(){
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		
		String sql = "SELECT * FROM BOARD";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public static void insert() {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		
		int res = 0;
		
		String sql = "INSERT INTO BOARD VALUES (NULL,?,?,?,NOW())";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			System.out.println("제목 입력");
			pstmt.setString(1, sc.next());
			System.out.println("작성자 입력");
			pstmt.setString(2, sc.next());
			System.out.println("내용 입력");
			pstmt.setString(3, sc.next());
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				con.commit();
				System.out.println("등록 성공.");
			} else {
				con.rollback();
				System.out.println("등록 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstmt);
		}		
	}
	
	//나머지도 작성해봤습니다
	
	public static void update() {
		Scanner sc = new Scanner(System.in);
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "UPDATE BOARD SET BOARDTITLE = ?, BOARDWRITER = ?, BOARDCONTENT = ? WHERE BOARDNO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			System.out.println("수정 할 글의 번호를 입력하세요");
			System.out.println("현재 보유 중인 글 목록");
			List<Board> list = selectAll();
			for(Board board : list) {
				System.out.print(board.getBoardno()+"번 ");
			}
			int num = sc.nextInt();
			System.out.println("글 제목 변경 : ");
			String bt = sc.next();
			System.out.println("글 작성자 변경 : ");
			String bw = sc.next();
			System.out.println("글 내용 변경 : ");
			String bc = sc.next();
			
			pstmt.setString(1, bt);
			pstmt.setString(2, bw);
			pstmt.setString(3, bc);
			pstmt.setInt(4, num);
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				con.commit();
				System.out.println("수정 성공.");
			} else {
				con.rollback();
				System.out.println("수정 실패.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstmt);
		}
	}
	
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "DELETE FROM BOARD WHERE BOARDNO = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			System.out.println("삭제 할 글의 번호를 입력하세요");
			System.out.println("현재 보유 중인 글 목록");
			List<Board> list = selectAll();
			for(Board board : list) {
				System.out.print(board.getBoardno()+"번 ");
			}
			int num = sc.nextInt();
			
			pstmt.setInt(1, num);
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				con.commit();
				System.out.println("삭제 성공.");
			} else {
				con.rollback();
				System.out.println("삭제 실패.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstmt);
		}
	}
	
}
