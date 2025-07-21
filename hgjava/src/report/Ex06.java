package report;

public class Ex06 {
	public static void main(String[] args) {
		int[][] arr= new int [3][5];
		for(int i=1; i<=5; i++) {
			int random1 = (int)(Math.random()*3);
			int random2 = (int)(Math.random()*5);
			if(arr[random1][random2] != 1) {
				arr[random1][random2] = 1;
			} else i--;
		}
		for(int i=0; i<=2; i++) {
			for(int j=0; j<=4; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

