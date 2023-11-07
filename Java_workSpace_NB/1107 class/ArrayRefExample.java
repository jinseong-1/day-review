package array;

/**
 * 배열의 기본타입과 참조타입의 항목이 저장된 배열 확인.
 */

public class ArrayRefExample {
	public static void main(String[] args) {
		
		// 배열 선언과 동시에 초기화 - new 생략가능. 없는게 아님
		int[] scores = {70,60,50,40,60,60};
		System.out.println(scores);
		
		int[] scores2 = scores;	// scores와 scores2가 스텍에서 같은 곳을 바라보게 됨 즉, 같은 값을 가지게 됨
		// [70][60][50][40][60][60]
		scores[0] = 80;
		
		System.out.println(scores[0]);
		System.out.println(scores2[0]);
		System.out.println(scores2);
		System.out.println(scores == scores2);
		
	System.out.println("==");
	
		int a = 10;
		int b = a;
		
		b = 20;
		System.out.println(a);
		System.out.println(b);
		
		// 알파벳은 26자
		char chars[] = new char[26];
		char c = 'A'; // 65		'a' == 97
		for(int i = 0; i<chars.length; i++, c++) {
			chars[i] = c;
		}
		
		for(int i = 0; i< chars.length; i++) {
			System.out.print(chars[i]+ " ");
		}
		System.out.println();
		
		// 향상된 for문
		for(char ch : chars) {
			System.out.print("["+ch+"]");
		} //for
	System.out.println("==============");
	
		// 실수
		double[] doubles = new double[3];
		doubles[1] = 3.141592;
		for(double d : doubles) {
			System.out.println(d);
		}
		
		
		// 논리 타입
		boolean[] tasks = new boolean[5];
		for(boolean bool : tasks) {
			System.out.println(bool);
		}
		
		// 참조 타입
		String[] strs = new String[3];
		strs[1] = "Java";
		for(String s : strs) {
			System.out.println(s);
		}
		System.out.println("strs의 값은 :"+strs);
		
		int[] arrays[] = new int[3][];
		// [null] [null] [null]
		arrays[0] = new int[4];
		arrays[1] = new int[3];
		arrays[2] = new int[3];
		int num = arrays[0][0];
		/*
		 arrays[0] [0][1][2][3]
		 arrays[1] [0][1][2]
		 arrays[2] [0][1][2]
 		*/
		// 			   저장할 배열의 갯수|배열 안에 갯수
		int[][] arrays2 = new int[2][3];
		// [0][1]
		// arrays2[0] - [0][0][0]
		// arrays2[1] - [0][0][0]
		
		int arrays3 [][] = new int[3][2];
		// [0][1][2]
		// arrays3[0] - [0][0]
		// arrays3[1] - [0][0]
		// arrays3[2] - [0][0]
		
		int[][] scoresArray = new int[][] {
			{10,20,30},
			{70,80,90,100}
		};
		
		System.out.println(scoresArray.length);
		System.out.println(scoresArray[0].length);
		System.out.println(scoresArray[1].length);
		
		for(int i = 0; i<scoresArray[0].length; i++) {
			System.out.print(scoresArray[0][i] + " ");
		} //for
		
		for(int i = 0; i<scoresArray[1].length; i++) {
			System.out.print(scoresArray[1][i] + " ");
		} //for
		
		System.out.println();
		System.out.println(scoresArray);
		for(int i = 0; i< scoresArray.length; i++) {
			System.out.print(scoresArray[i] + " ");
			for(int j = 0; j < scoresArray[i].length;j++) {
				System.out.print(scoresArray[i][j]+" "+" ");
			}
			System.out.println();
		}
		
		// 향상된 for문 적용
		for(int[] arr : scoresArray) {
			System.out.print(arr+" ");
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
	} // main
} // class










