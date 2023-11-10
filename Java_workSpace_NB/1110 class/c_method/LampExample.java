package c_method;
/**
 * 실행 클래스
 */
public class LampExample {

	public static void main(String[] args) {
		// isOnOff = true;  생성된 인스턴스로 접근해야하기에 잘못된 예
		// new 연산자를 이용하여 DarkLamp 객체 생성
		DarkLamp myLamp = new DarkLamp();
		myLamp.turnOn();
		myLamp.isOnOff = false;
		
		DarkLamp lamp = new DarkLamp();
		lamp.isOnOff=true;
		lamp.turnOff();
		
		
	}

}
