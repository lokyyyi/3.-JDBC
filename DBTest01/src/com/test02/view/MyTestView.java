package com.test02.view;

import java.util.List;
import java.util.Scanner;


import com.test02.dao.MyTestDao;
import com.test02.dto.MyTest;



public class MyTestView {
	
	public static int getMenu() {
		int select =0;
		
		System.out.println("1. 전체출력");
		System.out.println("2. 추가");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
		
		System.out.println("번호 선택: ");
		select = new Scanner(System.in).nextInt();
		return select;
	}

	public static void main(String[] args) {
		int no = 0;
	
		int mno = 0;
		String mname = null;
		String nickname = null;
		
		Scanner sc = new Scanner(System.in);
		MyTestDao dao = new MyTestDao();
		
		do {
			no = getMenu();
			
			switch(no) {
			//전체출력 select
			case 1:
				List<MyTest> selectRes = dao.selectAll();
				System.out.println("****전체출력****");
				for(MyTest tmp : selectRes) {
					System.out.println(tmp);
				}
				System.out.println("*************");
				break;
			//추가 insert
			case 2:
				System.out.println("추가 할 이름 : ");
				mname = sc.next();
				System.out.println("추가 할 별명 : ");
				nickname = sc.next();
				
				MyTest dto = new MyTest(0, mname, nickname);
				
				
				int insertRes = dao.insert(dto);
				
				if(insertRes>0) {
					System.out.println("입력 성공!!");
				}else {
					System.out.println("입력 실패!!");
				}
				break;
			//수정 update
			case 3:
				System.out.println("수정할 사람 번호: ");
				mno = sc.nextInt();
				System.out.println("수정할 사람 이름: ");
				mname = sc.next();
				System.out.println("수정할 별명");
				nickname = sc.next();
				
				MyTest update = new MyTest(mno, mname, nickname);
				int updateRes = dao.update(update);
				if(updateRes>0) {
					System.out.println("수정 성공!!");
				}else {
					System.out.println("수정 실패!!");
				}
				break;
			//삭제 delete
			case 4:
				System.out.println("삭제할 사람 번호: ");
				mno = sc.nextInt();
				
				if(dao.delete(mno)>0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				break;
			//프로그램 종료
			case 5:
				System.out.println("시스템종료");
			}
		}while(no != 5);
	}
}
