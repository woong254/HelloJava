package chat05;

public class Examarr {

	public static void main(String[] args) {
		// 배열 과제 1
		// 배열 생성, 크기 10, 데이터 1~100사이 난수
		// 배열의 값 출력
		// 배열의 합,최대값,최소값 출력
		int[] arr = new int[10];
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			int random = (int)(Math.random()*100)+1;
			sum += random;
			arr[i] = random;
		}
		int min = arr[0];
		int max = arr[0];
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			if(min > arr[i]) min = arr[i];
			if(max < arr[i]) max = arr[i];
		}
			System.out.println("\n"+"배열의 합 = "+sum);
			System.out.println("배열의 최소값 = "+min);
			System.out.println("배열의 최대값 = "+max);
			
			// 배열의 요소 중 4의 배수 출력 
			// 4의 배수 갯수 출력
			int count = 0;			
			for(int i=0; i<arr.length; i++) {
				if(arr[i] % 4 == 0) {
					count++;
					System.out.print(arr[i]+" ");
				}	
		}
				System.out.println("\n"+"4의 배수의 갯수 "+count);
				
				//2차원 배열
				//배열 선언
				int [][] twoArr = {
					{80,90},
					{70,60,50}
				};
				//2차원 출력
				for(int i=0; i<twoArr.length; i++) {
					for(int j=0; j<twoArr[i].length; j++) {
						System.out.printf("| %d ", twoArr[i][j]);
					}
					System.out.println();
				}
				
				//과제2
				int [][] fourArr = {
						{1,2,3},
						{1,2},
						{1},
						{1,2,3}
				};
				for(int i=0; i<fourArr.length; i++) {
					for(int j=0; j<fourArr[i].length; j++) {
						System.out.print(fourArr[i][j]+" ");
					}
				}
				System.out.println();
				System.out.println();
				
				
				//과제3
				int [][] exam3 = new int [3][10];
				int count1 = 0;
				for(int i=0; i<exam3.length; i++) {
					for(int j=0; j<exam3[i].length; j++) {
						int random = (int)(Math.random()*2);
						exam3[i][j] = random;
						System.out.print(exam3[i][j]+" ");
						if(random == 1) count1++ ;
					}
					System.out.println();
				}
					System.out.println("현재 관객 수는 "+count1+"명");
					System.out.println();
				//과제4
					int [][] exam4 = new int [3][5];
					double [] student = new double [3];
					for(int i=0; i<exam4.length; i++) {
						double hap = 0;
						for(int j=0; j<exam4[i].length; j++) {
							int random = (int)(Math.random()*50)+50;
							exam4[i][j] = random;
							hap += random;
							System.out.print(exam4[i][j]+"\t");	
						}
						student[i] = hap/5;
						System.out.println();
					}
					for(int i=0; i<=2; i++) {
						System.out.printf("%d번 학생의 평균 = %5.2f \n", i+1, student[i]);
					}

					//과제5
					
					String[] card1 ={"Clubs", "Diamonds", "Hearts", "Spades"};
					String[] card2 ={"2","3","4", "5", "6","7","8","9","10","Jack","Queen","King","Ace"};
					for(int i=1; i<=5; i++) {
						
					}
 					
	}//end main

	
	
}//end class
