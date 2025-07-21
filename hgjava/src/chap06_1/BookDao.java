package chap06_1;

import java.util.Scanner;

public class BookDao {
	Scanner sc = new Scanner(System.in);
	Book[] bookData(int n){
			Book[] books = new Book[n];//길이
			
			for(int i=0; i<n; i++) {
				System.out.print("도서번호 > ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.print("도서제목 > ");
				String name = sc.nextLine();
				System.out.print("도서가격 > ");
				int price = Integer.parseInt(sc.nextLine());
					
				books[i] = new Book(num, name, price);//객체 넣기
			}
			return books;
	}
	

}
