package array;

/**
 * 자료구조(Data Structure)란
 * 데이터를 효율적으로 저장하고 조작하기 위한 방법을 정의한 것.
 * 즉, 데이터를 저장하는 방법과 이를 조작하는 방법을 제공
 * 삽입, 삭제, 검색 등의 연산이 가능해야 함.
 * 효율적인 메모리 사용과 처리속도를 보장 해야함.
 * 구현이 쉽고 이해사기 쉬운 인터페이스를 제공해야 함.
 * 
 * 배열(Array)은 데이터를 저장하는 자료구조의 일종.
 * 동일한 자료형의 데이터를 연속된 공간에 순차적으로 나열 한 것
 * 배열은 메모리상에서 연속된 공간에 데이터를 저장하면 각 데이터는 인덱스(index)라는 숫자로 구분된다.
 * 배열은 메모리에 저장될때 크기가 결정되며 변경할 수 없다.
 */
public class UseArrayExample {
	public static void main(String[] args) {
		/*
		  배열 생성 방법
		  1. 배열에 저장할 값이 있을 시
		*/
		// 나열되어 있는 값으로 크기가 결정 되므로 크기를 지정할 필요가 없음.
		int[] array = new int[] {10, 20, 30, 40, 50};
		
		// 2. 선언과 동시에 값을 지정할 때는 new 연산자를 생략 가능하다.
		int array2[] = {50, 60, 70, 80};
		 // int array2[] = {50, 60, 70, true}; -> 다른 형식의 데이터는 쓰지 못함
		
		// 선언 이후에 배열 항목을 초기화 할 때는 new 연산자를 생략할 수 없다.
		int[] array3;
		// array3 = {10, 20, 30}; -> 컴파일 에러
		array3 = new int[]{10, 20, 30};
		
		// 3. 배열 생성 시에 값이 정해져 있지 않을 때는 저장할 공간만 생성 가능하며 생선된 각 항목의 공간에는 기본값으로 자동으로 초기화 된다.
		// 정수 - 실수 : 0 | boolean - false | 참조타입 - null 로 배열이 저장되어있음
		int[] array4 = new int[5];
		// [0][0][0][0][0]
		//  0  1  2  3  4 ...
		System.out.println(array4);
		// [I@626b2d4a 라고 출력되는데 이는 [=배열 I=변수 @뒤에서부턴 16진수로 표현되어있는 주소값
		
		// 지정된 항목 위치에 값을 저장
		array4[4] = 10;
		int num = array4[4];
		System.out.println(num);
		
		// 아직 배열에 저장될 항목의 크기가 결정되지 않았을때는 null keyword로 초기화 가능
		int[] array5 = null;
		System.out.println(array5);
		int[] array6;
		//if(array6 == null) {} 컴파일 오류
		if(array5 == null) {
			array5 = new int[3]; // 저장공간을 3개로 만드는 것.
		}
		System.out.println(array5);
		
		array5[0] = 10;
		array5[1] = 20;
		array5[2] = 30;
		// 크기를 벗어난 인덱스 번호로 접근하면 오류 발생
		// array5[3] = 40;
		int length = array5.length;
		System.out.println("array5의 길이는 : " + length);
		
		// 배열의 길이는 불변 - 변경할 수 없다.
		// array5.length = 10;
		System.out.println(array5[array5.length-1]);
	
	System.out.println("======");
		
		for(int i = 0; i<array5.length; i++) {
			System.out.print(array5[i] + " ");
		} // for
		
		// final keyword가 붙은 변수는 값의 재할당이 불가능하다.
		final int value = 10;
		// value = 100; -> 재할당이 불가능하다
	} //main
} // class















