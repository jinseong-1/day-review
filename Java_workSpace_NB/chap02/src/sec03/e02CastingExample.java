package sec03;

public class e02CastingExample {
	public static void main(String[] args) {
		int intValue = 44032;		// 값 초기화와 동시에 선언
		char charValue = (char)intValue; 
		// 현재 선언된 값은 char를 넘은 크기이므로 개발자가 확인했다는 의미에서 넣는 것.
		System.out.println(charValue);
		
		long longValue = 500;
		intValue = (int)longValue;
		System.out.println(intValue);
		
		double doubleValue =  3.14;
		intValue = (int) doubleValue;
		System.out.println(intValue);
	}
}
