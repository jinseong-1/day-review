package sec01;

import java.util.Scanner;

public class e01If {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 점수를 입력해주세요 : ");
		int score = sc.nextInt();
		
		if(100>=score && score>=90) {
			System.out.println("등급은 A입니다.");
		}else if(90>score && score >= 80) {
			System.out.println("등급은 B입니다.");
		}else if(80>score && score>=70) {
			System.out.println("등급은 C입니다.");
		}else if(70>score && score>60) {
			System.out.println("등급은 D입니다.");
		}else {
			System.out.println("내년에 다시봐요");
		}
		
		int num = score / 10;
		switch(num){
			case 1 : case 9 :
				System.out.println("등급은 A입니다.");
				break;
			case 8 :
				System.out.println("등급은 B입니다.");
				break;
			case 7 :
				System.out.println("등급은 C입니다.");
				break;
			case 6 :
				System.out.println("등급은 D입니다.");
				break;
			default:
				System.out.println("내년에 다시 봐요.");
				break;
				
		} //switch
		
		
	}
}
