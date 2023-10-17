package com.test02.dto;

public class MyTest {
	//필드
	private int mno;
	private String mname;
	private String nickname;
	
	//생성자
	public MyTest() {
	}
	
	public MyTest(int mno, String mname, String nickname) {
		this.mno = mno;
		this.mname = mname;
		this.nickname = nickname;
	}
	//getter@setter
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "[" + mno + ", " + mname + ", " + nickname + "]";
	}
	
	
}
