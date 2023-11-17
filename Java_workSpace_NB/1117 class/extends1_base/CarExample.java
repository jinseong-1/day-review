package extends1_base;

class Car{
	
	String company;
	int maxSpeed;
	
	Car(){
		System.out.println("Car 기본 생성자 호출");
	}
	
	Car(String company){
		this.company = company;
		System.out.println("Car company를 넘겨받는 생성자");
	}
	
	public String toString() {
		return "Car [company : " + this.company +"]";
	}
	
}	// class Car

//is a
class Taxi extends Car{
	Taxi(){
		super();	// 생략해도 사용가능. 부모객체가 먼저 호출되고 자식객체가 호출되기때문. but 아래줄과 순서는 바뀔수없음
		System.out.println("Taxi 기본 생성자 호출");
	}
}

// 버스는 차다
class Bus extends Car{
	
	Bus(String company){
		super(company);
		System.out.println("Bus 생성자 호출");
	}
}



public class CarExample {

	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		taxi.company = "KIA";
		taxi.maxSpeed = 180;
		System.out.println(taxi.toString());
		
		Bus bus = new Bus("HYUNDAI");
		bus.maxSpeed = 200;
		String str = bus.toString();
		System.out.println(str);
		
	}

}
