package ex01_netsted_class;

import java.util.*;

public class AMain {

	public static void main(String[] args) {
		Aa a = new Aa();
		a.methodAa();
		
		// Aa정적 멤버에서 바로 접근해서가 안됨
		System.out.println("--------------");
		// Aa.Ba b = new Aa.Ba();
		// 해당 멤버에 인스턴스 멤버가 있어야 생성이 가능하기에 아래와 같이 표현
		Aa.Ba b = a.new Ba();
		b.methodBa();
		
		System.out.println("--------------");
		
		Aa.Ca c = new Aa.Ca();
		c.field1 = 5;
		c.methodCa();
		
		Aa.Ca.field2 = 40;
		Aa.Ca.method2();
		
		System.out.println("----------------");
		Map<String, Integer> maps = new HashMap<>();
		Set<Map.Entry<String,Integer>> entrySet = maps.entrySet();
	}

}
