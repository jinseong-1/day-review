package ex03_lambda_expression.basic;

public class ALambdaExample {
	
	
	public static void main(String[] args) {
	
		AMyInterface Interface = new AMyInterface() {
		@Override
		public void method() {
			System.out.println("myInterface method");
		}
	};
	Interface.method();
	
	// method 에서 수행할 작업이 실행문 하나라면 {} 실행 블럭 생략 가능
	Interface = ()->System.out.println("rambda method 호출");
	
	Interface.method();
	
	Interface = () ->{
		String str = "method call";
		System.out.println(str+"실행블록");
	};

	Interface.method();
	}

}
