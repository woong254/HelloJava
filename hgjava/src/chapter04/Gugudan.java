package chapter04;

public class Gugudan {

	public static void main(String[] args) {
		// 구구단
		// 단 반복
//		for(int dan = 2; dan<= 9; dan++) {
//			System.out.println("****"+ dan + "****");
//			for(int gob = 1; gob <=9; gob++) {
//				System.out.println(dan + " x " + gob + " = " + dan*gob );
//			}
//			System.out.println();
//		}
		int dan;
		 for(dan = 2; dan <=9; dan++) {
			 System.out.print("  "+dan+"단"+"\t");
		 }
		 System.out.println();
		 for(int gob = 1; gob <=9; gob++) {
			for(dan=2; dan<=9; dan++) {
				System.out.print(dan + "x" + gob + "= "+ dan*gob+"\t");	
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
	}//end main

}//end class
