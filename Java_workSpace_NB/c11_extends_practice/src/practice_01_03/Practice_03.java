package practice_01_03;


public class Practice_03 {

	public static void main(String[] args) {
		// code 작성
		/*		내가 푼 것
		int[] arr = new int[10];
		int number = (int)(Math.random() * 100 + 1);
		for(int i = 0; i<arr.length;i++) {
			arr[i]=(int)(Math.random() * 100 +1);
		}
		
		System.out.print("최초의 리스트 : ");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		int temp = 0;
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0; j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		System.out.println();
		System.out.print("정렬된 리스트 : ");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		*/
		
		
		// 선생님 풀이
		int[] numbers = new int[10];
		
		System.out.print("최초의 리스트 : ");
		// 난수 삽입 및 출력
		for(int i = 0; i<numbers.length;i++) {
			numbers[i]=(int)(Math.random() * 100)+1;
			System.out.print(numbers[i]+" ");
			
			for(int j = 0; j<i;j++) {
				if(numbers[i]>numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			} // 정렬
		} // end for
		
		// 정렬된 리스트 출력
		System.out.println();
		System.out.print("정렬된 리스트 : ");
		for(int i : numbers) {
			System.out.print(i+" ");
		} // end 출력
		
	} // main
} //class
