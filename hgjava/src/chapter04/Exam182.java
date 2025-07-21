package chapter04;

public class Exam182 {

	public static void main(String[] args) {
		// p182 문제3
		//1에서 100까지 정수 중 3의 배수 합, 3의 배수의 갯수
		int sum = 0;
		int baesu = 0;
		for(int i=1; i<=100; i++) {
			if(i % 3 ==0) {
				sum += i;
				baesu ++;
			} 
		}
		System.out.println("3의 배수의 합은 >"+ sum +"\n3의 배수의 갯수는 >"+ baesu);
	}

}
