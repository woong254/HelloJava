package chat05;

import java.util.Scanner;

public class ex223 {

	public static void main(String[] args) {
		// p223 확인문제 6
		// switch문 이용
		boolean run = true;
		int studentNum = 0;
		int[] scores= null;
		Scanner sc = new Scanner(System.in);
		
		while(run){
			System.out.println("---------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택>");
			int selectNo = Integer.parseInt(sc.nextLine());
			switch(selectNo) {
			case 1:
				System.out.print("학생수>");
				studentNum = Integer.parseInt(sc.nextLine());
				scores = new int[studentNum];
				break;
			case 2:
				for(int i=0; i<scores.length; i++) {
					System.out.print("scores"+"["+i+"]"+">");
					scores[i] = Integer.parseInt(sc.nextLine());
				}
				break;
			case 3:
				for(int i=0; i<scores.length; i++) {
					System.out.println("scores"+"["+i+"]"+"> "+scores[i]);
				}
				break;
			case 4:
				int max= 0;
				double sum= 0;
				for(int score : scores) {
					sum += score;
					if(max < score) max = score;
				}
				System.out.println("최고 점수: "+max);
				System.out.println("평균 점수: "+sum/scores.length);
				break;
			case 5:
				run = false;
				break;
			default :
				System.out.println("잘못선택함");
			}
		}
		
		
		
		
		
		
		
		
		
		
	}//end main

}//end class
