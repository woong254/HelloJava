package com.yedam.app;

import java.util.ArrayList;
import java.util.Scanner;

// 사용자 입력 => DB반영
// DM결과 => 콘솔출력
// 컨드롤 역할
public class Main {
	public static void main(String[] args) {
		boolean run = true; //반복조건에 사용
		Scanner sc = new Scanner(System.in);
		BookDao dao = new BookDao();
		while(run) {
			System.out.println("도서 관리 시스템");
			System.out.println("1. 도서목록");
			System.out.println("2. 도서등록");
			System.out.println("3. 도서수정");
			System.out.println("4. 도서삭제");
			System.out.println("9. 종료");
			System.out.print("선택: ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1: //도서목록
				ArrayList<Book> list = dao.findAll(); // 반환: ArrayList<Book>
				System.out.println("도서번호 도서명       저자    가격");
				System.out.println("=============================");
				for(int i=0; i<list.size(); i++) {
					System.out.println(list.get(i).getId()+" "+list.get(i).getTitle()+" "+list.get(i).getAuthor()+" "+list.get(i).getPrice());
				}
				break;
			case 9: // 종료
				run = false;
			}
		}
		System.out.println("end of program");
		sc.close();
	}//end main()
}//end Main
