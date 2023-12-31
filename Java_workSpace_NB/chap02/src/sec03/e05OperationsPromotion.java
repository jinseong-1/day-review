package sec03;

public class e05OperationsPromotion {
	public static void main(String[] args) {
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		//byte byteValue3 = byteValue1 + byteValue2;		// 산술연산을 거치게되면 int값이 되므로 성립되지 않은 코드
		int intValue = byteValue1 + byteValue2;
		System.out.println(intValue);
		
		char charValue1 = 'A';
		char charValue2 = 1;
		//char charValue3 = char charValue1 + char charValue2;		// 문자도 유니코드 형식으로 숫자로 변환이 가능하고 이 또한 기본적으로 int로 바뀌게 됨
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드 = " + intValue2);
		System.out.println("출력문자 = " + (char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3/4;
		System.out.println(intValue4);
		
		int intValue5 = 10;
		// int intValue6 = 10 / 4.0;  <- int는 정수값만 저장할수있는데 소수점이 붙으면 실수가 됨으로 성립되지 않음
		double doubleValue = intValue5 / 4.0;
		System.out.println(doubleValue);
		
		int x = 1;
		int y = 2;
		double result = (double) x/y;
		System.out.println(result);
	}
}
