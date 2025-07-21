package 정지웅;

public class Diamond {

	public static void main(String[] args) {
		// 다이아 만들기
		int rows = 5; // 다이아몬드의 높이 (홀수여야 함)

        // 상반부
        for (int i = 1; i <= rows; i++) {
            // 공백 출력
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // 별 출력
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
	}

}
