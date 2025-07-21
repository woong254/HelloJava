package 정지웅;

import java.util.Scanner;

public class Homework3 {

	public static void main(String[] args) {
		// 숫자 추측 게임
		Scanner sc = new Scanner(System.in);
		int random = (int)(Math.random()*100)+1;
		boolean run = true;
		
		while(run){
			System.out.print("숫자 입력 : ");
			int number = Integer.parseInt(sc.nextLine());
		if (number > random) {
			System.out.println("down하세요!!");
		} else if (number < random) {
			System.out.println("up하세요!!");
		} else {
			System.out.println("축하합니다!!");
			run = false;
		}

	}
		sc.close();
  }
}
