package 정지웅;

import java.util.Scanner;

public class Homework1 {

	public static void main(String[] args) {
		// 윤년 계산 프로그램 
		Scanner sc = new Scanner(System.in);
		System.out.println("##년도 입력 : ");
		int years = Integer.parseInt(sc.nextLine());
		if (years % 4 == 0 && years % 100 != 0 || years % 400 == 0) {
			System.out.println(years+"년은 윤년입니다.");
			}else {
				System.out.println(years+"년은 평년입니다.");
			}
		
		sc.close();
		
		
		
		
		
		
		
		
		
	}//end main

} //end class
