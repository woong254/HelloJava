package chat05;

public class Exam05 {

	public static void main(String[] args) {
		String[] card1 = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] card2 = {"2","3","4", "5", "6","7","8","9","10","Jack","Queen","King","Ace"};
		for(int i=1; i<=5; i++) {
			int random1 = (int)(Math.random()*card1.length);
			int random2 = (int)(Math.random()*card2.length);
			System.out.print(card1[random1]+"의 "+card2[random2]+"\n");
		}

	}

}
