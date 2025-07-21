package 정지웅;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		// 동전 교환 프로그램
		Scanner sc = new Scanner(System.in);
		System.out.println("##교환할 금액 : ");
		int coin = Integer.parseInt(sc.nextLine());		
		int obeak = coin/500;
		int remain = coin%500;
		int beack = remain/100;
		int oship = coin%500%100/50;
		int ship = coin%500%100%50/10;
		int namuji =coin%500%100%50%10;
		int traiding = coin / 10 * 10;
		System.out.println("500원 짜리 : "+obeak+"개");
		System.out.println("100원 짜리 : "+beack+"개");
		System.out.println("50원 짜리 : "+oship+"개");
		System.out.println("10원 짜리 : "+ship+"개");
		System.out.println("교환 금액 : "+traiding+"원");
		System.out.println("남은 금액 : "+namuji+"원");
		sc.close();
	}
	
}
