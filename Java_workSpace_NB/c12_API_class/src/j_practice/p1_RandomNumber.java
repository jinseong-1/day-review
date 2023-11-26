package j_practice;

import java.util.Arrays;
import java.util.Random;

public class p1_RandomNumber {

	public static void main(String[] args) {
		
		Random random = new Random(10);
		System.out.print("최초의 리스트 : ");
		for(int i = 0; i<10; i++) {
			int result = random.nextInt(100) + 1;
			System.out.print(result + " ");
		}

}	// main
	
	
}// class	
