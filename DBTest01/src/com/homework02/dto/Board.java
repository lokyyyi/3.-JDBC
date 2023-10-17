package com.homework02.dto;

import java.util.Date;

public class Board {

	private int boardno;
	private String boardtitle;
	private String boardwriter;
	private String boardcontent;
	private Date boarddate;
	
	public Board() {
	}

	public Board(int boardno, String boardtitle, String boardwriter, String boardcontent, Date boarddate) {
		this.boardno = boardno;
		this.boardtitle = boardtitle;
		this.boardwriter = boardwriter;
		this.boardcontent = boardcontent;
		this.boarddate = boarddate;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public String getBoardwriter() {
		return boardwriter;
	}

	public void setBoardwriter(String boardwriter) {
		this.boardwriter = boardwriter;
	}

	public String getBoardcontent() {
		return boardcontent;
	}

	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}

	public Date getBoarddate() {
		return boarddate;
	}

	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}
	
}
