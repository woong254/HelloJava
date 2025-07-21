package chap06;

import java.util.Scanner;

public class StudentDao {
	//학생데이터 생성
	//필드
	Scanner sc = new Scanner(System.in);
	//생성자
	//메소드
	Student[] stData() { 
			Student[] students = {
			 new Student("홍길동",100,100,100),
			 new Student("황길동",90,100,86),
			 new Student("김길동",50,88,78),
			 new Student("이길동",80,70,90),
			 new Student("최길동",69,65,57)
			};
		return students;
	}
}