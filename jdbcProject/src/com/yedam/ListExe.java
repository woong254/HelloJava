package com.yedam;

import java.util.ArrayList;

public class ListExe {
	public static void main(String[] args) {
		// ArrayList 클래스. vs . 배열.
		int[] arr = {10, 20, 30,}; // arr[0] = 10;
		for(int i=0; i<arr.length; i++) {
			System.out.println("["+i+"]번째 값 => "+arr[i]);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10); //추가.
		list.add(20);
		list.add(30);
		for (int i=0; i<list.size(); i++) {
			System.out.println("["+i+"]번째 값 => "+list.get(i));
		}
		//학생정보.
		ArrayList<Student> stdList = new ArrayList<Student>();
		Student s1 = new Student();// 인스턴스
		s1.setStdNo(1000); // 학번: 1000
		s1.setStdName("김민식");
		s1.setPhone("010-0000-0000");
		s1.setBloodType("O");
		
		Student s2 = new Student(2000, "최민정", "010-0000-1111", "B");
		
		stdList.add(s1);
		stdList.add(s2);
		stdList.add(new Student(3000, "최우식", "010-0000-2222", "A"));
		
		for (int i=0; i<stdList.size(); i++) {
			System.out.println("학번: "+stdList.get(i).getStdNo());
			System.out.println("이름: "+stdList.get(i).getStdName());
			System.out.println("전화번호: "+stdList.get(i).getPhone());
			System.out.println("혈액형: "+stdList.get(i).getBloodType());
			System.out.println();
		}
		
		System.out.println("end of prog.");
	}
}
