package chat05;

import java.util.Calendar;

public class Exam230 {

	public static void main(String[] args) {
		// 요일 
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		
		week day = null;
		int dayNo = today.get(Calendar.DAY_OF_WEEK);
		
		switch(dayNo) {
		case 1:
			day = week.일요일;
			break;
		case 2:
			day = week.월요일;
			break;
		case 3:
			day = week.화요일;
			break;
		case 4:
			day = week.수요일;
			break;
		case 5:
			day = week.목요일;
			break;
		case 6:
			day = week.금요일;
			break;
		case 7:
			day = week.토요일;
			break;
		
		
		
		}
		System.out.println("오늘은"+day+"입니다");
	}

}
