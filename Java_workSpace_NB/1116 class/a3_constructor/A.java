package a3_constructor;

public class A {
	A a = new A(); // public
	
	A a1 = new A(10); // default
	
	A a2 = new A("이기적인 놈"); // private
	
	public A() {
		System.out.println("pubilc 생성자");
	}
	
	A(int a){
		System.out.println(a + "default 생성자");
	}

	// 자기 내부에서만 접근 가능
	private A(String a) {
		System.out.println(a);
	}
	
	
	
}
