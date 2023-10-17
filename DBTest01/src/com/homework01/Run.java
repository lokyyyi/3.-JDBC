package com.homework01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Run {

	public static void main(String[] args) {

		List<Board> list = new ArrayList<Board>();
		list.add(new Board(1,"멀티캠퍼스", "최현록", new Date(), "여러분"));
		list.add(new Board(2,"멀티캠퍼스", "주현록", new Date(), "안녕하세요"));
		list.add(new Board(3,"멀티캠퍼스", "김현록", new Date(), "제이름은"));
		list.add(new Board(4,"멀티캠퍼스", "이현록", new Date(), "주현록"));
		list.add(new Board(5,"멀티캠퍼스", "박현록", new Date(), "입니다"));
		
		
		for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		}
}

