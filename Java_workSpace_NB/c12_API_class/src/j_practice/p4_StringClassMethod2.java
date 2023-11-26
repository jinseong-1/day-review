package j_practice;

import java.util.Scanner;

public class p4_StringClassMethod2 {
	public static void main(String[] args) {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		String num = "1234567890";		
		
		System.out.println("문자나 숫자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
	
		String str = sc.next();
		System.out.println("입력받은 문자 : " + str);
		
		// 소문자로 변환
		String lower = str.toLowerCase();
		
		int index = chars.indexOf(lower);
		// -1은 숫자,한글.  0이상의 숫자는 영어
		int index1 = num.indexOf(str);
		// -1은 영어,한글.  0이상은 숫자는 숫자
		
		boolean a = true;
		if(index != -1) {
			a = true;
		}else {
			a = false;
		}
		boolean b = true;
		if(index1 != -1) {
			b = true;
		}else {
			b = false;
		}
	
		
		System.out.println("영어문자 : " + a);
		System.out.println("숫자 : " + b);
		sc.close();
	}	// main
} // class
