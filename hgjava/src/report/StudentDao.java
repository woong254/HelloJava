package report;

import java.util.Scanner;

public class StudentDao {
			Scanner sc = new Scanner(System.in);
			Student[] studentData(int n) {
									Student[] students = new Student[n];
									
									for(int i=0; i<n; i++) {
											System.out.print("학번 > ");
											int num = Integer.parseInt(sc.nextLine());
											System.out.print("이름 > ");
											String name = sc.nextLine();
											System.out.print("점수 > ");
											int score = Integer.parseInt(sc.nextLine());
											students[i]= new Student(num,name,score);
									}
									return students;
							}
			}
	