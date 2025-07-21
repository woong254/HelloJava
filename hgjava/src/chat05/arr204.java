package chat05;

public class arr204 {

	public static void main(String[] args) {
		// 배열 생성,배열 데이터 활용
		// p204 예제
		int[] scores;
		scores = new int[] { 83, 90, 87 };
		int sum2 = add(new int[] {83, 90, 87});
		System.out.println("총합 : "+ sum2);
		System.out.println();
	
	//int 형의 배열 선언, 크기 : 5
	//배열에 50~100사이의 난수 5개 입력
	//배열의 합 계산 
		int[] scorse2 = new int [5];
		int hap= 0;
		for(int i=0; i<=4; i++) {
			int random = (int)(Math.random()*51)+50;
			scorse2[i] = random;
			hap += random;
		}
		System.out.println("배열의 합 = " + hap);
	System.out.println();
	}//end main

	public static int add(int[] scores) {
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += scores[i];
		}
		return sum;
		
	}//end add	
	
	
	
	
}//end class
