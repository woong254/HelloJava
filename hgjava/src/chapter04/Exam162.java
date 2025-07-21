package chapter04;

import java.util.Scanner;

public class Exam162 {

	public static void main(String[] args) {
		// 주사위 게임
		// 주사위를 2개 던져서 합이 10을 넘으면 두수를 더하고 > 덧셈결과 :
		// 아니면 두수를 곱한 결과를 출력 > 덧셈결과 :
//		int dice1 =(int)(Math.random()*6) +1;
//		int dice2 =(int)(Math.random()*6) +1;
//		int result =(dice1 + dice2);
//		int result2 =(dice1 * dice2);
//		if (result > 10){
//			System.out.println(dice1 + " + " + dice2 +" = "+result);
//		} else {
//			System.out.println(dice1 + " * " + dice2 +" = "+result2);
//		}
		
		int schedule =(int)(Math.random()*4) +9;
		System.out.println("현재시간: "+schedule+"시");
		switch(schedule) {
		case 9:
			System.out.println("출근합니다");
		case 10:
			System.out.println("회의합니다");
		case 11:
			System.out.println("업무를 봅니다");
		case 12:
			System.out.println("외근을 나갑니다");
		}
		System.out.println("오늘 일정 끝");
		
		//p169 문제3
		int score = 100;		
		System.out.print("등급은 ");
		switch(score / 10) {
		case 6:
			System.out.print("D");
			break;
		case 7:
			System.out.print("C");
			break;
		case 8:
			System.out.print("B");
			break;
		case 9,10:
			System.out.print("A");
			break;
		default :
			System.out.print("E");
		}
		System.out.println(" 입니다.");
		
		// 주사위 게임
		// 주사위 2개 던져서 합이 10이 되면 탈줄
		 // 주사위 수선쌍 출력 ex(5,2)
		// 5회 이상이 되면 게임 오버 출력
		for(int i=1 ; i<=5 ; i++) {
			int rdice1 =(int)(Math.random()*6)+1 ;
			int rdice2 =(int)(Math.random()*6)+1 ;
			int rresult = (rdice1 + rdice2);
			System.out.println(rdice1 + "," + rdice2);
			if(rresult == 10) {
				System.out.println("탈출");
				break;
		 	}
		 }
		System.out.println("게임오버");
	 
		//반복문
//		int i;
//		for(i=1; i<=5; i++) {
//			System.out.println(" i = " + i);
//		}
//		System.out.println("탈출 1~"+(i-1)+"까지");
//		
		//문제3
		// 추가 : 몇 번만에 탈출했는지 출력
		// 횟수 체크 변수 선언
		// 반복문
			//주사위 2개 생성
			//순서쌍 출력
			//합이 5가 되었는지 체크
			//5면 탈출, 아니면 반복
		// 반복 횟수 출력
		int cnt = 0;
		while(true) {
			int dice1 = (int)(Math.random() * 6) + 1;
			int dice2 = (int)(Math.random() * 6) + 1;
			int diceresult = (dice1 + dice2);
			System.out.println("("+ dice1 + "," + dice2 + ")");
			cnt++;
			if(diceresult == 5) {
				break;
			}
		}
		
		//p183 4번
		System.out.println(cnt + "회 반복");
		
		for (int x=1; x<=10; x++) {
			for (int y=1; y<=10; y++) {
				if(4*x + 5*y == 60) {
					System.out.println("("+x+","+y+")");
				}
			}
		}
		
		//p183 6번
		for (int i=1; i<=4; i++) {
			for (int j=4; j>=1; j--) {
				if(j > i) {
					System.out.print(" ");
				} else if(j <= i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		
	}//end main

}//end class
