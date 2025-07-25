package com.yedam;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.BookMapper;
import com.yedam.vo.Book;

public class BookControl {
	Scanner sc = new Scanner(System.in);
	SqlSession sqlSession = DBUtil.getInstance().openSession();
	BookMapper mapper = sqlSession.getMapper(BookMapper.class);

	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("도서정보 관리");
			System.out.println("1.도서목록");
			System.out.println("2.도서등록");
			System.out.println("0.이전메뉴");
			System.out.print("선택>>> ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				bookList();
				break;
			case 2:
				addBook();
				break;
			case 0:
				return;
			default:
				System.out.println("메뉴를 선택하세요");
			}
		}
	}

	void bookList() {
		int page = 1;
		List<Book> list = mapper.selectList(page);
		System.out.println("도서ID 도서제목 가격");
		System.out.println("================");
		for (Book book : list) {
			System.out.println(book.showBrief());
		}
		System.out.println("이전(p) 다음(n) 선택>> ");
		String p = sc.nextLine();
		if(p.equals("n")) {
			page ++;
		} else if(p.equals("p")) {
			page --;
		}
//		bookSearch(); // 상세조회
	} // end of bookList()

	void bookSearch() {
		// 상세조회
		while (true) {
			System.out.println("================");
			System.out.print("상세보기(ID입력), 최소(q) 선택>> ");
			// try 블럭 실행하다가 예외 발생하면 catch 블럭을 실행.
			try {
				int bno = Integer.parseInt(sc.nextLine());
				Book book = mapper.selectBook(bno);
				if (book == null) {
					System.out.println("검색결과 없음.");
				} else {
					System.out.println(book.showDetail());
					System.out.print("삭제하시겠습니까? Y/N");
					String flag = sc.nextLine();
					if(flag.equals(" ") || flag.equals("N")) {
						// 삭제안함.
						continue;
					}
					// 삭제 기능.
					if(mapper.deleteBook(bno) == 1) {
						System.out.println("성공");
						break;
					}
				}
			} catch (NumberFormatException e) {
				return;
			}
		} // end of while
	} // end of bookSearch

	void addBook() {
		System.out.print("도서ID입력>> ");
		String id = sc.nextLine();
		System.out.print("도서제목>> ");
		String title = sc.nextLine();
		System.out.print("도서저자>> ");
		String author = sc.nextLine();
		System.out.print("도서가격>> ");
		String price = sc.nextLine();

		Book book = new Book();
		book.setId(Integer.parseInt(id));
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(Integer.parseInt(price));

		if (mapper.insertBook(book) == 1) {
			sqlSession.commit(); // 커밋처리.
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	} // end of addBook

} // end of bookControl
