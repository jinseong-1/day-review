package j_practice;

import java.util.Arrays;

public class p2_ArrayCopy {

	public static void main(String[] args) {
		
		int array1[] = {10,20,30,40,50};
		System.out.println(Arrays.toString(array1));
		
		int array2[] = Arrays.copyOfRange(array1, 1, 3);
		System.out.println(Arrays.toString(array2));
		
	}

}
