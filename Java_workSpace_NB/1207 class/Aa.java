package ex01_netsted_class;

public class Aa {

	
	Aa(){
		System.out.println("Aa 객체 생성");
	}
	
	void methodAa() {
		System.out.println("Aa class의 methodAa");
	
			// local class
			class Da{
				Da(){
					System.out.println("Da 객체 생성");
				}
				int field1;
				
				void MethodDa() {
					System.out.println("Da class method Da");
				}
			} // end Da class
	
		Da da = new Da();
		da.field1 = 10;
		da.MethodDa();
		System.out.println(da.field1);
	} // end methodAa()
	
	// 인스턴스 멤버 클래스 Ba
	public class Ba{
		Ba(){
			System.out.println("Ba 객체 생성");
		}
		
		int filedBa;
		
		void methodBa() {
			System.out.println("Ba method");
			methodAa();
		}
		
		// 일반 내분 클래스에서는 정적 멤버를 사용할 수 없음.
		// static void method2(){}
	} // end Ba
	
	// 정적 멤버 class -> Aa 클래스 선언과 동시에 올라가서 static 사용 가능
	static public class Ca{
		int field1;
		static int field2;
		
		Ca(){
			System.out.println("Ca 객체 생성");
		}
		
		void methodCa() {
			System.out.println("method Ca 호출");
			// method(); -> 정적 멤버이기에 인스턴스 멤버 사용 불가
		}
		
		static void method2() {
			System.out.println("Ca class의 static method2");
		}
	} // end Ca class
} //end class Aa

