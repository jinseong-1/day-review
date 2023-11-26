package j_practice;

import java.util.Scanner;

public class p3_StringClassMethod {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		while(isRun){
		System.out.println("문자열을 입력해 주세요 >>");
		String str = sc.next();
		if(str.indexOf("java") == -1) {
			System.out.println("자바가 존재하지 않습니다.");
		}else {
			System.err.println("시스템을 종료합니다.");
			isRun = false;
		}
		}
	}

}
