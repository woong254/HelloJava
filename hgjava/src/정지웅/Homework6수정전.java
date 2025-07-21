package 정지웅;

import java.util.Scanner;

public class Homework6 {

	public static void main(String[] args) {
		//가위,바위,보 게임 프로그램
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.print("##가위(0) 바위(1) 보(2) : ");
			int cpu =(int)(Math.random()*3)+0;
			int me = Integer.parseInt(sc.nextLine());
			switch (me) {
			case 0:
				if(cpu == 0) {
					System.out.println("사람: 가위, 컴퓨터 : 가위, 비김");
				} else if(cpu == 1) {
					System.out.println("사람: 가위, 컴퓨터 : 바위, 패배");
				} else {
					System.out.println("사람: 가위, 컴퓨터 : 보, 승리");
				}
				break;
			case 1:
				if(cpu == 0) {
					System.out.println("사람: 바위, 컴퓨터 : 가위, 승리");
				} else if(cpu == 1) {
					System.out.println("사람: 바위, 컴퓨터 : 바위, 비김");
				} else {
					System.out.println("사람: 바위, 컴퓨터 : 보, 패배");
				}
				break;
			case 2:	
				if(cpu == 0) {
					System.out.println("사람: 보, 컴퓨터 : 가위, 패배");
				} else if(cpu == 1) {
					System.out.println("사람: 보, 컴퓨터 : 바위, 승리");
				} else {
					System.out.println("사람: 보, 컴퓨터 : 보, 비김");
				}
				break;
			default:
				System.out.println("game over");
				run=false;
			}

			
		}
		
		
	}
  }

