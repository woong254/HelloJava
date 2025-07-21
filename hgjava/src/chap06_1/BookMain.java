package chap06_1;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookDao bookdao = new BookDao();
		Book[] books = null;
		boolean run = true;
		int bookno = 0;
		while(run) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1.도서수 입력 2.도서정보 등록 3.도서정보 전체조회 4.도서정보 분석 5.종료");
			System.out.println("------------------------------------------------------------");
			
			System.out.print("선택 > ");
			int selNum = Integer.parseInt(sc.nextLine());
			switch(selNum) {
			case 1:
				System.out.print("도서 수 > ");
				bookno = Integer.parseInt(sc.nextLine());
				break;
			case 2:
				books = bookdao.bookData(bookno);
				break;
			case 3:
				for(int i=0; i<books.length; i++) {
					System.out.println("도서번호 : "+books[i].num+" 가격 : "+books[i].price+"원");
				}
				break;
			case 4:
				int exprice = 0;
				int chprice = books[0].price;
				double sum = 0;
				for(int i=0; i<books.length; i++) {
					if(exprice < books[i].price) exprice = books[i].price;
					if(chprice > books[i].price) chprice = books[i].price;
					sum += (double)books[i].price;
				}
				System.out.println("최고 가격 : "+exprice+"원");
				System.out.println("최저 가격 : "+chprice+"원");
				System.out.printf("평균 가격은 %.1f원 입니다.\n",sum/bookno);
				break;
			default:
				System.out.println("프로그램 종료");
				run=false;
			}
			
		}
		sc.close();


	}

}
