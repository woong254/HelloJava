package chap06;

public class SungjuckMain {

	public static void main(String[] args) {
		//객체 생성 => 배열 데이터 받아 옴
		StudentDao stdao = new StudentDao();
		Student[] students = stdao.stData();
		
		//객체 사용
		for(int i=0; i<students.length; i++) {
		System.out.printf
		("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\n",
				students[i].name,
				students[i].kor,
				students[i].math,
				students[i].eng,
				students[i].total(),
				students[i].avg(),
			students[i].grade());
		}
	}

}
