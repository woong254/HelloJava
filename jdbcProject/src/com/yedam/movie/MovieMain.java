package com.yedam.movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		MovieDao dao = new MovieDao();
		
		while(run){
			System.out.println("=============================================================================================");
			System.out.println("1.영화목록 | 2.영화등록 | 3.영화수정 | 4.영화삭제 | 5.개별조회 | 6.장르별조회 | 7.평점조회 | 8.감독분석 | 9.종료");
			System.out.println("=============================================================================================");
			System.out.print("선택>>> ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ArrayList<Movie> list = dao.findAll();
				System.out.println("========================================================================");
				System.out.println("   번호   |          제목          |        감독        |    장르    |  평점  ");
				System.out.println("========================================================================");
				for(int i=0; i<list.size(); i++) {
					String moNoLength =" ".repeat((10-(String.valueOf(list.get(i).getMoNo()).length()))/2);
					String titleLength =" ".repeat((22-list.get(i).getTitle().length())/2);
					String directorLength = " ".repeat((18-list.get(i).getDirector().length())/2);
					String genreLength = " ".repeat((13-list.get(i).getGenre().length())/2);
					String raitingLength =" ".repeat((8-String.valueOf(list.get(i).getRaiting()).length())/2);
					System.out.printf("%s%d%s%s%s%s%s%s%s%s%s%s%s%.1f%s%n",
							moNoLength,list.get(i).getMoNo(),moNoLength,titleLength,list.get(i).getTitle(),titleLength,directorLength,list.get(i).getDirector(),directorLength,genreLength,list.get(i).getGenre(),genreLength,raitingLength,list.get(i).getRaiting(),raitingLength);
				}
				break;
			case 2:
				Movie newMovie = new Movie();
				
				System.out.print("번호>>> ");
				int moNo = sc.nextInt();
				newMovie.setMoNo(moNo);
				sc.nextLine();
				
				System.out.print("제목>>> ");
				String titel = sc.nextLine();
				newMovie.setTitle(titel);
				
				System.out.print("감독>>> ");
				String dir = sc.nextLine();
				newMovie.setDirector(dir);
				
				System.out.print("장르>>> ");
				String gr = sc.nextLine();
				newMovie.setGenre(gr);
				
				System.out.print("평점>>> ");
				Double rt = sc.nextDouble();
				newMovie.setRaiting(rt);
				sc.nextLine();
				
				boolean insert = dao.insert(newMovie);
				if(insert) {
					System.out.println("등록 성공!");
				} else {
					System.out.println("등록 실패!");
				}
				break;
			case 3:
				
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				System.out.println("프로그램 종료!");
				run = false;
				break;
			default:
				System.out.println("1~9까지의 숫자를 입력하세요!");
			
			
			
			
			}
		}
		sc.close();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
