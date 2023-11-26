package j_practice;

public class p5_StringMethodInteger {

	public static void main(String[] args) {
		
		String scores = "100,11,35,41";
		// 총점과 평균
		int total = 0;
		double avg = 0.0;
		// 작성
		Integer obj = Integer.valueOf(scores);
		System.out.println(obj);
		
		
		
		System.out.println(scores);
		System.out.println("총점 : " + total + "점");
		System.out.printf("평균 : %.1f점", avg);
	}
}
