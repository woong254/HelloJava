package com.yedam.movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		MovieDao dao = new MovieDao();
		
		while(run){
			System.out.println("=======================================================================");
			System.out.println("1.영화목록 | 2.영화등록 | 3.영화수정 | 4.영화삭제 | 5.영화검색 | 6.감독분석 | 7.종료");
			System.out.println("=======================================================================");
			System.out.print("선택>>> ");
			int select = sc.nextInt();
			
			switch(select) {
			//전체목록조회
			case 1:
				ArrayList<Movie> list = dao.findAll();
				if(list.size()==0) {
					System.out.println("영화가 등록되어 있지 않습니다.");
					break;
				}
				System.out.println("============================================================================");
				System.out.println("   번호   |         제목         |        감독        |     장르     |    평점    ");
				System.out.println("============================================================================");
				for(int i=0; i<list.size(); i++) {
					System.out.printf("%-8d  %-20s  %-17s  %-10s  %5.1f\n",
							list.get(i).getMoNo(),list.get(i).getTitle(),list.get(i).getDirector(),list.get(i).getGenre(),list.get(i).getRaiting());
				}
				System.out.println();
				break;
			//영화등록
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
			//영화수정
			case 3:
				System.out.print("수정할 영화의 제목을 입력하세요>>> ");
				sc.nextLine();
				String updateTitle = sc.nextLine();
				ArrayList<Movie> found = dao.find("title",updateTitle);
				if(found.size() == 0) {
					System.out.println("해당 제목의 영화가 존재하지 않습니다.");
					break;
					
				} else if (found.size() == 1) {
					System.out.println();
					System.out.println("동일한 제목의 영화가 "+found.size()+"개 존재합니다.");
					System.out.println("============================================================================");
					System.out.println("   번호   |         제목         |        감독        |     장르     |    평점    ");
					System.out.println("============================================================================");
					for(int i=0; i<found.size(); i++) {
						System.out.printf("%-8d  %-20s  %-17s  %-10s  %5.1f\n",
								found.get(i).getMoNo(),found.get(i).getTitle(),found.get(i).getDirector(),found.get(i).getGenre(),found.get(i).getRaiting());
					}
					System.out.println();
					String daoField ="";
					boolean run2 = true;
						while(run2) {
						System.out.print("수정할 항목을 입력하세요>>> ");
						String options = sc.nextLine();
						switch(options) {
						case "번호":
							daoField = "moNo";
							run2 = false;
							break;
						case "제목":
							daoField = "title";
							run2 = false;
							break;
						case "감독":
							daoField = "director";
							run2 = false;
							break;
						case "장르":
							daoField = "genre";
							run2 = false;
							break;
						case "평점":
							daoField = "raiting";
							run2 = false;
							break;
						default:
							System.out.println("잘못된 항목 입니다.");
							break;
						}
						}
						System.out.print("수정할 내용을 입력하세요>>> ");
						String daoValue = sc.nextLine();
						
						boolean titleUpdate = dao.update(daoField, daoValue, "title", updateTitle);
						
						if(titleUpdate) {
							System.out.println("수정이 완료 되었습니다.");
						} else {
							System.out.println("수정에 실패 했습니다.");
						}
						break;
						
				} else {
					System.out.println("동일한 제목의 영화가 "+found.size()+"개 존재합니다.");
					System.out.println("============================================================================");
					System.out.println("   번호   |         제목         |        감독        |     장르     |    평점    ");
					System.out.println("============================================================================");
					for(int i=0; i<found.size(); i++) {
						System.out.printf("%-8d  %-20s  %-17s  %-10s  %5.1f\n",
								found.get(i).getMoNo(),found.get(i).getTitle(),found.get(i).getDirector(),found.get(i).getGenre(),found.get(i).getRaiting());
					}
					System.out.println();
						System.out.print("수정할 영화의 번호를 입력 하세요>>> ");
						int updateMoNo;
						Movie foundMoNo = null;
						
						while (true) {
							updateMoNo = sc.nextInt();
							sc.nextLine();
							for(Movie m : found) {
								if(m.getMoNo() == updateMoNo) {
									foundMoNo = m;
									break;
								}
							}
							if(foundMoNo != null) {
								break;
							} else {
								System.out.println("목록에 존재하지 않는 번호입니다!");
								System.out.print("목록에 존재하는 번호를 입력하세요>>> ");
							}
						}
						String daoField ="";
						boolean run3 = true;
						while(run3) {
						System.out.print("수정할 항목을 입력하세요>>> ");
						String options = sc.nextLine();
						switch(options) {
						case "번호":
							daoField = "moNo";
							run3= false;
							break;
						case "제목":
							daoField = "title";
							run3= false;
							break;
						case "감독":
							daoField = "director";
							run3= false;
							break;
						case "장르":
							daoField = "genre";
							run3= false;
							break;
						case "평점":
							daoField = "raiting";
							run3= false;
							break;
						default:
							System.out.println("잘못된 항목 입니다.");
							break;
						}
						}
						System.out.print("수정할 내용을 입력하세요>>> ");
						String daoValue = sc.nextLine();
						
						boolean moNoUpdate = dao.update(daoField, daoValue, "moNo", String.valueOf(updateMoNo));
						
						if(moNoUpdate) {
							System.out.println("수정이 완료 되었습니다.");
						} else {
							System.out.println("수정에 실패 했습니다.");
						}
						break;
				}
			//영화삭제
			case 4:
				System.out.print("삭제할 영화의 제목을 입력하세요>>> ");
				sc.nextLine();
				String titleName = sc.nextLine();
				ArrayList<Movie> found2 = dao.find("title",titleName);
				if(found2.size() == 0) {
					System.out.println("해당 제목의 영화가 존재하지 않습니다.");
					break;
				} else if (found2.size() == 1) {
					boolean delete = dao.deleteMovie("title",titleName);
					if(delete) {
						System.out.println("삭제완료.");
						break;
					} else {
							System.out.println("삭제실패.");
						break;	
					}
				} else {
					System.out.println("동일한 제목의 영화가 "+found2.size()+"개 존재합니다.");
					System.out.println("============================================================================");
					System.out.println("   번호   |         제목         |        감독        |     장르     |    평점    ");
					System.out.println("============================================================================");
					for(int i=0; i<found2.size(); i++) {
						System.out.printf("%-8d  %-20s  %-17s  %-10s  %5.1f\n",
								found2.get(i).getMoNo(),found2.get(i).getTitle(),found2.get(i).getDirector(),found2.get(i).getGenre(),found2.get(i).getRaiting());
					}
					System.out.println();
						System.out.print("삭제할 영화의 번호를 입력 하세요>>> ");
						int deleteMoNo;
						Movie foundMoNo = null;
						
						while (true) {
							deleteMoNo = sc.nextInt();
							sc.nextLine();
							for(Movie m : found2) {
								if(m.getMoNo() == deleteMoNo) {
									foundMoNo = m;
									break;
								}
							}
							if(foundMoNo != null) {
								break;
							} else {
								System.out.print("목록에 존재하는 번호를 입력하세요>>> ");
							}
							}	
							boolean delMv = dao.deleteMovie("moNo", String.valueOf(deleteMoNo));
							if(delMv) {
								System.out.println("삭제완료");
							} else {
								System.out.println("삭제실패");
							}
							break;
						}
			//검색기능
			case 5:
				boolean search = true;
				while(search) {
					System.out.println("==========================================");
					System.out.println("1.제목검색 | 2.장르검색 | 3.평점검색 | 4.뒤로가기 ");
					System.out.println("==========================================");
					System.out.print("선택>>> ");
					int searchSel = sc.nextInt();
					switch(searchSel) {
					case 1:
						System.out.print("조회하실 영화의 제목을 입력해주세요>>> ");
						sc.nextLine();
						String searchTitle = sc.nextLine();
						ArrayList<Movie> found3 = dao.find("title",searchTitle);
						if(found3.size() == 0) {
							System.out.println("해당 제목의 영화가 존재하지 않습니다.");
							break;
						} else {
							System.out.println("조회결과 : "+found3.size()+"편");
							System.out.println("============================================================================");
							System.out.println("   번호   |         제목         |        감독        |     장르     |    평점    ");
							System.out.println("============================================================================");
							for(int i=0; i<found3.size(); i++) {
								System.out.printf("%-8d  %-20s  %-17s  %-10s  %5.1f\n",
										found3.get(i).getMoNo(),found3.get(i).getTitle(),found3.get(i).getDirector(),found3.get(i).getGenre(),found3.get(i).getRaiting());
							}
							System.out.println();
							break;
						}
					case 2:
						System.out.print("조회하실 영화의 장르를 입력해주세요>>> ");
						sc.nextLine();
						String searchGenre = sc.nextLine();
						ArrayList<Movie> found4 = dao.find("genre", searchGenre);
						if(found4.size()==0) {
							System.out.println("해당하는 장르의 영화가 존재하지 않습니다.");			
						} else {
							System.out.println("조회결과 : "+found4.size()+"편");
							System.out.println("============================================================================");
							System.out.println("   번호   |         제목         |        감독        |     장르     |    평점    ");
							System.out.println("============================================================================");
							for(int i=0; i<found4.size(); i++) {
								System.out.printf("%-8d  %-20s  %-17s  %-10s  %5.1f\n",
										found4.get(i).getMoNo(),found4.get(i).getTitle(),found4.get(i).getDirector(),found4.get(i).getGenre(),found4.get(i).getRaiting());
							}
							System.out.println();
						}
						break;
					case 3:
						Double maxRaiting;
						Double minRaiting;
						System.out.print("조회하실 평점의 최소값을 입렵하세요>>> ");
						while(true) {
							minRaiting = sc.nextDouble();
							sc.nextLine();
							if(minRaiting >= 0.0 && minRaiting <= 10.0) {
								break;
							} else {
								System.out.print("0.0이상 10.0이하의 수를 입력하세요>>> ");
							}
						}
						System.out.print("조회하실 평점의 최대값을 입렵하세요>>> ");
						while(true) {
							maxRaiting = sc.nextDouble();
							sc.nextLine();
							if(maxRaiting <= 10.0 && maxRaiting >= 0.0 && maxRaiting>minRaiting) {
								break;
							} else {
								System.out.print(minRaiting+"이상 10.0이하의 수를 입력하세요>>> ");
							}
						}
						ArrayList<Movie> found5 = dao.minmax(minRaiting,maxRaiting);
						if(found5.size()==0) {
							System.out.println("해당 범위안의 영화가 존재하지 않습니다");
							break;
						}
						System.out.println("조회결과 : "+found5.size()+"편");
						System.out.println("============================================================================");
						System.out.println("   번호   |         제목         |        감독        |     장르     |    평점    ");
						System.out.println("============================================================================");
						for(int i=0; i<found5.size(); i++) {
							System.out.printf("%-8d  %-20s  %-17s  %-10s  %5.1f\n",
									found5.get(i).getMoNo(),found5.get(i).getTitle(),found5.get(i).getDirector(),found5.get(i).getGenre(),found5.get(i).getRaiting());
						}
						System.out.println();
						break;
					case 4:
						search = false;
						break;
					default :
						System.out.println("1~4의 숫자를 입력해주세요!");
				}
			}
				break;
			//장르로 조회
			//평점 최소값 최대값 조회
			//감독분석(평균 평졈)
			case 6:
				ArrayList<Movie>found6 = dao.avgDirector();
				if(found6.size() == 0) {
					System.out.println("감독이 등록된 영화가 없습니다.");
					break;
				}
				System.out.println("========================================================================");
				System.out.println("      평균평점이 가장 높은 BEST 감독     |     평균평점이 가장 낮은 WORST 감독      ");
				System.out.println("========================================================================");
				String bestDir =  found6.get(0).getDirector();
				String worstDir =  found6.get(0).getDirector();
				double sum = 0.0;
				Double max = 0.0;
				Double min = found6.get(0).getRaiting();
				for(int i=0; i<found6.size(); i++) {
					sum += found6.get(i).getRaiting();
					if(max < found6.get(i).getRaiting()) {
						max = found6.get(i).getRaiting();
						bestDir =  found6.get(i).getDirector();
						}
					if(min > found6.get(i).getRaiting()) {
						min = found6.get(i).getRaiting();
						worstDir =  found6.get(i).getDirector();
					}
				}
				System.out.printf("\t감독명 : %s\t\t\t감독명 : %s\t\n",bestDir,worstDir);
				System.out.printf("\t평균평점 : %.1f\t\t\t\t평균평점 : %.1f\t\n",max,min);
				System.out.println();
				System.out.printf("p.s) 총 %d명의 감독들의 전체 평균 평점은 %.1f점 입니다.\n",found6.size(),sum/found6.size());
				System.out.println();
				break;
			case 7:
				System.out.println("프로그램 종료!");
				run = false;
				break;
			default:
				System.out.println("1~7까지의 숫자를 입력하세요!");
				break;
			
			}
		}
		sc.close();
		
	}

}
