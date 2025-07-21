package 정지웅;

import java.util.Scanner;

public class Homework6 {

	public static void main(String[] args) {
		//가위,바위,보 게임 프로그램
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.print("##가위(0) 바위(1) 보(2) : ");
			int cpu =(int)(Math.random()*3);
			int me = Integer.parseInt(sc.nextLine());
			if((me+2)%3 == cpu%3) {
				System.out.println("("+me+","+cpu+")"+"승리");
			} else if((me+1)%3 == cpu%3) {
				System.out.println("("+me+","+cpu+")"+"패배");
			} else if(cpu == me){
				System.out.println("("+me+","+cpu+")"+"비김");
			} if (me > 2) {
				System.out.println("프로그램 종료");
				run=false;
			}
		}
		sc.close();
		
	}
  }
//가위 0 +1 % 3 =1 바위=1 =진다
