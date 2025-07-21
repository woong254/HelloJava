package report;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);	
			StudentDao studao = new StudentDao();
			Student[] students = null;
			int stuNo = 0;
			boolean run = true;
			while(run) {
				System.out.println("----------------------------------------------------------");
				System.out.println("1.학생수 입력 2.학생정보 등록 3.학생정보 전체조회 4.학생정보 분석 5.종료");
				System.out.println("----------------------------------------------------------");
				System.out.print("선택 > ");
				int selNo = Integer.parseInt(sc.nextLine());
				switch(selNo) {
				case 1:
						System.out.print("학생 수 > ");
						stuNo = Integer.parseInt(sc.nextLine()); 
						break;
				case 2:
						students = studao.studentData(stuNo);
						break;
				case 3:
						for(int i=0; i<stuNo; i++) {
						System.out.println(students[i].num+" 학번 점수 : "+students[i].score+"점");
						}
						break;
				case 4:
						int max = 0;
						int min = students[0].score;
						int sum = 0;
						for(int i=0; i<stuNo; i++) {
							if(max < students[i].score) max = students[i].score;
							if(min > students[i].score) min = students[i].score;
							sum += students[i].score;
						}
						System.out.println("최고 점수 : "+max+"점");
						System.out.println("최저 점수 : "+min+"점");
						System.out.printf("평균 점수는 %.2f점 입니다.\n",(double)sum/stuNo);
						break;
				default:
						System.out.println("프로그램 종료");
						run = false;

				}
			}
		sc.close();
				
				

	}

}
