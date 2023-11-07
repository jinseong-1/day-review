package sec02.exam03;

public class LongExample {
	public static void main(String[] args) {
		long var1 = 10;
		long var2 = 20L;	// L을 쓰는건 더 크게 할당하여 쓰려고
		//long var3 = 1000000000000;	// 이는 long이라는 변수에 값을 넣기에 초과했기에 오류난 것.
		// 기본적으로 상수를 변수로 넣을시엔 int 타입으로 들어가기에 L을 넣고 안넣고가 차이가 있음
		long var4 = 1000000000000L;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var4);
	}
}
