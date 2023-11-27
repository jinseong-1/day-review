# 상속(Inheritance)
- 객체 지향 프로그램에서의 상속
    - 자식(하위)클래스가 부모(상위) 클래스의 멤버를 물려받는 것.
    - 자식이 부모를 선택해서 물려받음
    - 상속대상 : 부모의 필드와 메소드
## 상속의 효과
- 부모 클래스를 재사용하여 자식 클래스를 빠르게 개발 가능
- 반복된 코드를 줄임
- 유지 보수가 편함
- 객체 다형성 구현 가능
- 개발은 쉽고 빠르게하며 있던 코드들을 재활용하는 것

## 상속 대상 제한
- 부모 클래스의 private 접근을 갖는 필드와 메소드는 제외
- 부모 클래스가 다른 패키지에 있을 경우, default 접근을 갖는 필드와 메소드도 제외

### expends
- 자식 클래스가 상속할 부모 클래스를 지정하는 키워드
- 부모클래스
```
public class A{
    int field1;
    void method1(){...}
}
```
- 자식 클래스
```
// extends를 이용하여 A클래스에 있는걸 가지고 온다
public class B extends A{
    String field2;
    void method2(){...}
}
```
- <b>상속받을때 여러 부모의 클래스에서 들고오진 못한다</b>

### super
- 부모 클래스를 만들고 자식클래스를 상속받아 만들고 난 후 자식클래스를 생성자로 만들때 자동으로 부모 클래스가 먼저 만들어짐
```
class Taxi extends Car{
	Taxi(){
		super();    // 자동으로 생성되고 아래줄과 바껴선 안됨
		System.out.println("Taxi 기본 생성자 호출");
	}
}
```
- 명시적인 부모 생성자 호출
    - 부모 객체 생성할 때, 부모 생성자 선택해 호출
    ```
    자식클래스(매개변수선언,...){
        super(매개값,...);
        ...
    }
    ```
    - super(매개값,...)
        - 매개값과 동일한 타입, 개수, 순서에 맞는 부모 생성자 호출
        - 부모생성자가 없다면 컴파일 오류가 발생
        - 부모클래스에 기본(매개변수가 없는)생성자가 없다면 필수로 써야함

## 메소드 재정의(Override)
- `@Override` 어노테이션
    - 컴파일러에게 부모 클래스의 메소드 선언부와 동일한지 검사를 지시
- 재정의 효과
    - 부모 메소드는 숨겨지는 효과 발생
    - 재정의된 자식 메소드가 실행
- 예시
```
public class CalculatorExample {
	public static void main(String[] args) {
		Computer com = new Computer();
		int plus = com.sum(30,40);
		System.out.println("com sum : " +plus);
		double area = com.circleArea(7.5);
		System.out.println("area : " + area);
	}
}
```
```
public class Computer extends Calculator{
	@Override	
	public double circleArea(double radius) {
		System.out.println("computer에 존재하는 circleArea");
		return radius * radius * Math.PI;
	}
}
```

## final 클래스와 final 메소드
- final 키워드의 용도
    - final field : 수정 불가 필드
    - final class : 부모로 사용 불가능한 클래스
    - final mathod : 사직이 재정의할 수 없는 메소드