package sec01;

import java.util.Scanner;

public class e03IfElseIfElseExample {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력해주세요 : ");
		int score = sc.nextInt();
		if(100>=score || score>=90) {
			System.out.println("A등급입니다.");
		}else if(90>score || score>=80) {
			System.out.println("B등급입니다.");
		}else if(80>score || score>=70) {
			System.out.println("C등급입니다.");
		}else if(70>score || score>=60) {
			System.out.println("D등급입니다.");
		}else {
			System.out.println("내년에 다시 만나요");
		}
	} // main
}  //class
