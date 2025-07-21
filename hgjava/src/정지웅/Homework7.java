package 정지웅;

public class Homework7 {

	public static void main(String[] args) {
		// 369게임 프로그램
		for(int i=1; i<=99; i++) {
			int dujari = i / 10;
			int hanjari = i % 10;
			boolean hanjarisick = (hanjari == 3 || hanjari == 6 || hanjari == 9);
			boolean dujarisick = (dujari == 3 || dujari == 6 || dujari == 9);
			if(hanjarisick&&dujarisick){
				System.out.print("♥♥\t");
			}else if(hanjarisick) {
				System.out.print("♥\t");
			}else if(dujarisick) {
				System.out.print("♥\t");
			}else {
				System.out.print(i+"\t");
			}
			if (i % 10 == 0) {
				System.out.println();
			}
	}
			

		
		
		
	}
  }

