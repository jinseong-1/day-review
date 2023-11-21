# Object
- 자바의 최상위 부모 클래스
    - 다른 클래스 상속하지않으면 java.lang.Object 클래스 상속 암시
    - Object의 메소드는 모든 클래스에서 사용 가능

## toString()
- 객체를 문자열로 표현한 값
- Object 클래스의 toString() 메소드는 객체의 문자 정보 리턴
```
Object obj = new Object();
System.out.println(obj,toString());

[실행 결과]
java.lang.Object@de6ced     -> 주소값이 나오게 됨
```
- 일반적으로 의미있는 문자정보가 나오도록 재정의함
```
// alt + s + a      생성자
public Person(String name, int height, double weight) {
	super();
	this.name = name;
	this.height = height;
	this.weight = weight;
}

// alt + s + s + s      toString
@Override
public String toString() {
	return "Person [name=" + name + ", height=" + height + ", weight=" + weight + "]";
}
```
```
public class ToStringExample {	
	public static void main(String[] args) {
		Object obj = new Object();
		String result = obj.toString();
		System.out.println(result);     결과값 : java.lang.Object@626b2d4a
		System.out.println(obj);        결과값 : java.lang.Object@626b2d4a
		
		Person p = new Person("홍길동", 193, 80.1);
		System.out.println(p);          
        결과값 : Person [name=홍길동, height=193, weight=80.1]
	}
}
```

## equals()
- 저장된 위치는 다르지만 논리적인 값을 비교하기위해 사용하는 메소드
```
boolean result = obj1.equals(obj2);
                기준 객체   비교 객체
// 위의 문장과 아래 문장의 결과값은 같다
boolean result = (obj1 == obs2)
```
- 논리적 동등 위해 <u>오버라이딩</u> 필요
    - 논리적 동등 : 같은 객체이건 다른 객체이건 상관없이 객체 저장 데이터 동일
    - Object의 equals() 메소드 : 재정의하여 논리적 동등 비교할때 이용

## 객체 해시코드(hashCode())
- 객체 해시코드
    - 객체 식별할 하나의 정수값
    - 객체의 메모리 번지를 이용해 해시코드를 만들고 리턴
    - 개별 객체는 해시코드가 모두 다름
```
public class Key {
	int number;
	// number를 넘겨받는 생성자
	public Key(int number) {
		this.number = number;
	}

	// alt + s + v
	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key key = (Key)obj;
			if(this.number == key.number) {
				return true;
			}
		}
		return super.equals(obj);
	}	
}
```

```
import java.util.HashSet;

public class KeyExample {
	public static void main(String[] args) {
		Key key1 = new Key(1);
		Key key2 = new Key(2);
		Key key3 = new Key(1);
		
		System.out.println("key1 : " + key1.hashCode());
		System.out.println("key2 : " + key2.hashCode());
		System.out.println("key3 : " + key3.hashCode());
		
	// 나중에 배울 내용
		HashSet<Key> set = new HashSet<>();
		set.add(key1);
		set.add(key2);
		set.add(key3);
		
		System.out.println(set);
	}
}
```
## 객체 복제(clone())
- 기존의 데이터를 그대로 들고오는 것
- 복제 종류
    - 얕은 복제 : 필드 값만 복제
        - 동일한 필드 값을 가진 얕은 복제된 객체 리턴
    ```
    protected Object clone() throws CloneNotSupportedException {
		Member cloned = (Member)super.clone();  // 얕은 복제
    }
    ```
    - 깊은 복제 : 참조하고 있는 객체도 복제
        - clone() 메소드 재정의하고 참조 객체도 복제해야함
    ```
    protected Object clone() throws CloneNotSupportedException {
		Member cloned = (Member)super.clone();  // 얕은 복제
		// scores 새로운 공간 생성
		int[] scores = new int[cloned.scores.length];
		for(int i = 0; i<cloned.scores.length; i++) {
			scores[i] = this.scores[i];
		}
		cloned.scores = scores;
		Car car = new Car(this.car.model);
		cloned.car = car;
		return cloned;
	}
    ```

## 객체 소멸자(finalize())
- 객체를 소멸하기 직전에 객체 소멸자(finalize())실행
- 될수있으면 소멸자는 사용하지 않는게 좋음
    - GC(Garbage Collector)의 구동 시점은 일정하지않고 본인이 원할때만 일하기 때문