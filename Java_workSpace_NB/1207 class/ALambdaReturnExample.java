package ex03_lambda_expression.return_type;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@FunctionalInterface
interface AMyInterface{
	int method(int a, int b, String s);
}



public class ALambdaReturnExample {

	public static void main(String[] args) {
		AMyInterface e = new AMyInterface() {
			@Override
			public int method(int x, int y, String s) {
				System.out.println(s);
				return x * y;
			}
		};
		int result = e.method(20, 5, "곱샘연산");
		System.out.println("result : " + result);
		
		e = (a, b, s) ->{
			System.out.println(s+ "+");
			return a + b;
		};
		result = e.method(30,40,"덧셈연산");
		System.out.println("result : " + result);
		
		System.out.println("------------------");
		
		Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 오름차순 정렬
				return o1 - o2;
			}
		});
		set = new TreeSet<>((o1, o2)->{
			// 내림차순
			return o2-o1;
		});
		
		set.add(10);
		set.add(402103);
		set.add(50320);
		
		System.out.println(set);
	} // end main

}
