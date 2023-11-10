package f_object_array;

import java.util.Scanner;

public class StudentManagement {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Student[] students = null;
		
		
		while(true) {
			System.out.println("===========================");
			System.out.println("1.학생수|2.정보입력|3.정보확인|4.분석|5.종료");
			System.out.println("===========================");
			System.out.println("메뉴 번호를 입력해 주세요 >");
			int selectNo = sc.nextInt();
			
			/*
			 1. 학생수를 입력받아 Student객체가 저장될 students 배열 생성 
			 	- 입력 받은 학생 수 만큼
			 2. 생성된 students 배열의 항목 수만큼 학생의 정보를 입력받아 저장
			 	- 학번(int), 이름(String), 점수(int)
			 3. students 배열에 저장된 학생들의 정보(field data)를 출력
			 4. 1. students 배열에 저장된 학생들의 점수를 전체합계, 평균을 구해서 출력
			 	2. students 배열에 저장된 학생들의 점수 중에서 
			 	   최고 득점자 이름, 최저 득점자 이름 출력
			 5. 종료
			*/
			if(selectNo == 1) {
				System.out.println("학생 수를 입력해주세요 >");
				int num = sc.nextInt();
				students = new Student[num];
				System.out.println("입력받은 학생수 : " + students.length);
			}else if(selectNo == 2) {
				for(int i =0;i<students.length;i++) {
					students[i] {
					System.out.println("학생의 정보를 입력해주세요.");
					System.out.print("학번 : ");
					int number = sc.nextInt();
					System.out.println("이름 : ");
					String name = sc.toString();
					System.out.println("점수 : ");
					int score = sc.nextInt();
					}
				}
			}else if(selectNo == 3) {
				
			}else if(selectNo==4) {
				
			}else if(selectNo==5) {
				System.out.println("종료.");
			
			}else {
				System.out.println("제대로 된 값을 입력해주세요.");
				
			}
				
				
				
			
			
			
		} //while
		
		
	} //main
} //class
