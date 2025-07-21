package chapter01;

import java.util.Scanner;

public class Ex149 {

	public static void main(String[] args) {
//		// p149 문제1
//		byte b = 5;
//		b = -b; //- 연산때문에 바이트가 인트로 바꼈기때문에 인트로 값을 받아주거나 값을 바이트로 바꿔야함
//		int result = 10 / b;
//		System.out.println(result);
		
		byte b = 5;
		b = (byte)-b; 
		int result = 10 / b;
		System.out.println(result);
		
		// p149 문제2
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(z); // z=31
		
		//p150 문제3
		boolean stop = true;
		while(!stop) {
			
		}
		System.out.println("반복종료");
		
		//p150 문제4
		int pencils = 534;
		int students = 30;
		
		//학생 1명이 가지는 연필 개수
		int pencilsPerStudent = (pencils/students);
		System.out.println("학생 1명이 가지는 연필 개수 "+pencilsPerStudent+"개");
		
		//남은 연필 개숫
		int pencilsLeft = (pencils%students);
		System.out.println("남은 연필 개수 "+pencilsLeft+"개");
		
		//p150 문제5
		int var1 = 5;
		int var2 = 2;
//		double var3 = var1 / var2 ; // va1 이나 va2 를 더블로 변환 해야함
		double var3 = var1 / (double)var2 ;
		int var4 = (int) (var3 * var2);
		System.out.println(var4);
		
		//p151 문제6
		int value = 356;		
		System.out.println(value / 100 * 100);
	
		//p151 문제7
//		float var01 = 10f; //더블로 바꾸면 됨
		double var01 = 10; //더블로 바꾸면 됨
		double var02 = var01 / 100;
		if(var02 == 0.1) {
			System.out.println("10%입니다.");
		} else {
			System.out.println("10%가 아닙니다.");
		}
		
		//p151 문제8
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = ((lengthTop + lengthBottom) * (double)height /2);
		System.out.println(area);
		
		//p151 문제9
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("실수를 입력 하세요.");
//		System.out.print("첫 번째 수: ");
//		double silsu1 = Double.parseDouble(sc.nextLine());
//		
//		System.out.print("두 번째 수: ");
//		double silsu2 = Double.parseDouble(sc.nextLine());
//		
//		double result00 = silsu1 / silsu2 ;
//		if (silsu2 == 0 | silsu2 == 0.0) {
//			System.out.println("결과:무한대");
//		}
//		System.out.println("결과:"+ result00);
		
		//입력된 년도가 윤년인지 계산하는 프로그램 작성
		//4로 나누어 떨어지고, 100으로 나누어 떨어지지 않으면 윤년
		//400으로 나누어 떨어지면 윤년
		System.out.println("년도를 입력하세요.");
		System.out.print("##년도 입력 : ");
		int years = Integer.parseInt(sc.nextLine());
		if (years % 4 == 0 && years % 100 >= 1 || years % 400 == 0) {
			System.out.println(years+"년은 윤년입니다.");
		} else {
			System.out.println(years+"년은 평년입니다.");
		}
	}
 }
