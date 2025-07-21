package chapter04;

import java.util.Scanner;

public class Bank183 {

	public static void main(String[] args) {
		//p183 7번 while문 활용
		//은행 업무
		//잔고 변수
		//실행제어 변수
		//업무 1. 예금 2. 출급 3. 조회 4. 종료
		//종료가 될 때까지 반복
		
		int balance = 0;
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int money;
		
		while(run) {
			System.out.println("-------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.조회 | 4.종료");
			System.out.println("-------------------------------");
			
			System.out.print("선택>");
			int selNum = Integer.parseInt(sc.nextLine());
			
			switch(selNum) {
			case 1 :
				System.out.print("예금액>");
				money = Integer.parseInt(sc.nextLine());
				balance += money;
				break;
			case 2 :
				// 출금액이 부족할 경우 작앤 부족 출력
				// 출금 가능 금액 출력
				System.out.print("출금액>");
				money = Integer.parseInt(sc.nextLine());
				if (balance - money < 0) {
					System.out.println("잔액부족!!");
					System.out.println("출금 가능액 : "+balance);
				} else {
					balance -= money;
					System.out.println("출금완료");
				}
				break;
			case 3 :
				System.out.println("잔액 : "+balance);
				break;
			default :
				run = false;
			}
		}
		System.out.println("프로그램 종료");

	}//end main

}//end class
