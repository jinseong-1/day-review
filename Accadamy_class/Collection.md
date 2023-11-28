# Collection Framework
- 다수의 데이터를 쉽고 효과적으로 처리할 수 있도록 표준화된 방법을 제공하는 class의 집합
- 데이터를 저장하는 자료구조와 데이터를 처리하는 알고리즘을 구조화하여 class로 구현한 것.

## 리스트(List)
- 순서가 있는 데이터들의 집합.
- 인덱스로 관리되며 중복해서 객체 저장이 가능
- 동적으로 크기가 정해지며 데이터의 삽입 삭제가 배열에 비해 용이하고 메모리의 재사용성이 높다.
- 구현 클래스 : `ArrayList, Vector, LinkedList`
- 주요 메소드
    - 객체 추가
        - boolean add (E e) : 객체 맨 끝에 추가
        - void add : 주어진 인덱스에 객체 추가 -> 기존 값을 뒤의 인덱스로 밀어내면서 추가
        - set(int index) : 주어진 인덱스에 값을 대체하여 추가
    - 객체 검색
        - boolean contains : 주어진 객체가 저장되어있는지 여부
        - e get(int index) : 주어진 인덱스에 저장된 객체를 리턴
        - isEmpty() : 사용할 수 있는 데이터가 있는지 찾는 것
        - int size() : 저장되어있는 전체 객체수를 리턴
    - 객체 삭제
        - void clear() : 모두 삭제
        - E remove(int index) : 주어진 인덱스에 저장된 객체를 삭제
        - boolean remove : 주어진 객체를 삭제. equals를 사용함
```
import java.util.ArrayList;
    public class ArrayListExample {
        public static void main(String[] args) {	
            ArrayList array = new ArrayList();
            array.add("문자열");
            array.add(100);
            System.out.println(array);
            
            String str = (String)array.get(0);
            System.out.println(str);
            
            ArrayList<String> strs = new ArrayList<>(20);
            // strs.add(100); : String타입이 아니여서 컴파일 오류
            strs.add("java");
            strs.add("JDBC");
            strs.add(null);
            int size = strs.size();
            System.out.println("size : " + size);       결과값 size : 3
            strs.add("MySQL");
            strs.add("mysql");
            String str2 = strs.get(0);
		    System.out.println("0 : " + str2);          결과값 0 : java
            System.out.println(strs.get(5));        아래와같이 오류가 나오게 됨
            // java.lang.IndexOutOfBoundsException: Index 5 out of bounds for length 5
            }
            for(int i =0; i<strs.size();i++) {
			System.out.println(strs.get(i));
            }
            
            for(String s : strs) {
                System.out.print(s + " ");
            }
            
            strs.add(2, "Servlet/JSP");
            System.out.println(strs);

            strs.add(2, "Servlet/JSP");
            System.out.println(strs);       //[java, JDBC, Servlet/JSP, null, MySQL, mysql]
            strs.add("JDBC");
            System.out.println(strs);       // [java, JDBC, Servlet/JSP, null, MySQL, mysql, JDBC]

        - remove
        boolean isChecked = strs.remove("JDBC");
        System.out.println("isChecked : " + isChecked);     // isChecked : true
        System.out.println(strs);       // [java, Servlet/JSP, null, MySQL, mysql, JDBC]

        String result = strs.remove(2);
        System.out.println(result);     // null
        System.out.println(strs);       // [java, Servlet/JSP, MySQL, mysql, JDBC]
    }
```
- list에 저장된 항목들 중에 매개변수로 전달 받은 객체가 존재하면 true
```
isChecked = strs.contains("mysql");
System.out.println("isChecked tontains : " + isChecked);
```
- 해당 인덱스의 값을 변경하고 기존에 저장되어있던 값을 반환
```
result = strs.set(2, "Oracle");
System.out.println("result : " + result);//result : MySQL
System.out.println(strs);				// [java, Servlet/JSP, Oracle, mysql, JDBC]
```
- list 항목이 비어있으면 true
```
isChecked = strs.isEmpty();
System.out.println("isEmpty : " + isChecked);		// isEmpty : false
```
- list안에 모든 항목을 제거
```		
strs.clear();
System.out.println(strs.size());					// 0
System.out.println("isEmpty : " + strs.isEmpty());	// isEmpty : true

strs.add("JAVA");
strs.add("Java");
strs.add("jAva");
strs.add("jaVa");
System.out.println(strs);						// [JAVA, Java, jAva, jaVa]
```
- List => array
```		
String[] ss = new String[strs.size()];
strs.toArray(ss);
System.out.println(Arrays.toString(ss));		// [JAVA, Java, jAva, jaVa]
```
- array => List
```		
List<String> list = Arrays.asList(ss);
System.out.println(list);						// [JAVA, Java, jAva, jaVa]
```

## 연결 리스트(link) 
- 불연속적인 메모리 공간에 데이터들이 연관되며 포인터(참조 주소값)을 통해 각 데이터들이 연결되는 구조
- array와 기능은 비슷하지만 자주 바뀌는 자료에 빠르게 처리할수있는 방식
- 주요 메소드
    - 객체 추가
        - boolean add (E e) : 객체 맨 끝에 추가
    - 객체 검색
        - boolean contains : 주어진 객체가 저장되어있는지 여부
        - isEmpty() : 사용할 수 있는 데이터가 있는지 찾는 것
        - int size() : 저장되어있는 전체 객체수를 리턴
    - 객체 삭제
        - void clear() : 모두 삭제
        - boolean remove : 주어진 객체를 삭제. equals를 사용함
- <b>index</b>가 존재하지않음.
```
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

    class Board{
        String subject;
        String content;
        String writer;
        
        public Board(String subject, String content, String writer) {
            super();
            this.subject = subject;
            this.content = content;
            this.writer = writer;
        }
    }
    public class LinkedListExample {
        public static void main(String[] args) {
            List<Board> arrayList = new ArrayList<>();
            List<Board> linkedList = new LinkedList<>();
        
            long startTime=0;
            long endTime=0;
            
            int size = 100000;
            
            System.out.println("[ 추가 작업 ]");
            startTime = System.nanoTime();// 10억분의 1초
            for(int i =0; i<size; i++) {
                arrayList.add(0,new Board("제목","내용","작성자"));
            }
            endTime = System.nanoTime();
            System.out.println("array 추가 시간 : " + (endTime - startTime)+"ns");
            
            startTime = System.nanoTime();
            for(int i =0;i<size;i++){
                linkedList.add(0,new Board("제목","내용","작성자"));
            }
            endTime = System.nanoTime();
            System.out.println("linked 추가 시간 : " + (endTime - startTime)+"ns");
            
            System.out.println("[검색 작업]");
            startTime = System.nanoTime();
            for(int i =0;i<size;i++){
                arrayList.get(i);
            }
            endTime = System.nanoTime();
            System.out.println("array 검색 시간 : " + (endTime - startTime)+"ns");
            
            startTime = System.nanoTime();
            for(int i =0; i<size;i++) {
                linkedList.get(i);
            }
            
            endTime = System.nanoTime();
            System.out.println("linked 추가 시간 : " + (endTime - startTime)+"ns");
        }
    }
```

## HashSet
- 수학의 집합에 비유하여 설명을 많이하며, 객체를 중복해서 저장 불가.
- 인덱스를 쓰는 개념이 아닌 주머니에 물건들을 넣어놓고 꺼내쓴다는 개념으로 접근하면 쉬움
- null값도 하나만 가능
```
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		HashSet<String> s1 = new HashSet<>();
		s1.add("A");
		//s1.add(0,"B"); 순서가 없음 - index번호도 없음
		s1.add("D");
		s1.add("B");
		s1.add("C");
		
		boolean isAdd = s1.add("C");
		System.out.println(s1);						// [A, B, C, D]
		System.out.println("isAdd : " + isAdd);		// isAdd : false
		
		// 반복자 내부에 저장하고 있는 데이터를 token처럼 꺼내옴
		Iterator<String> iterator = s1.iterator();
		while(iterator.hasNext()) {
			String s = iterator.next();
			System.out.print(s + " ");				// A B C D
		}
		System.out.println();
		System.out.println(s1.contains("B"));		// true
		
		Set<String> s2 = new HashSet<>();
		s2.add("A");
		s2.add("D");
		s2.add("E");
		System.out.println(s2);						// [A, D, E]
		
		Set<String> s3 = new HashSet<>(s1);
		System.out.println(s3);						// [A, B, C, D]
		System.out.println(s3 == s1);				// false
		
		// s3 : A B C D
		// s2 : A D E
		// 중복을 제외한 합집합
		s3.addAll(s2);
		System.out.println(s3);						// [A, B, C, D, E]
	
        Set<String> s4 = new HashSet<>(s1);
		// s4 : A B C D
		// s2 : A D E
		// 교집합
		s4.retainAll(s2);
		System.out.println("s4 : " + s4); 			// s4 : [A, D]
		
		boolean isDeleted = s1.remove("A");
		System.out.println("isDeleted : " + isDeleted);	// isDeleted : true
		System.out.println(s1); 					// [B, C, D]
		
		for(String s : s1) {
			System.out.print(s + " ");
			if(s.equals("B")) {
//		java.util.ConcurrentModificationException
				//s1.remove(s);
				//s1.add("E");		// 갯수가 바뀌는 연산을 반복문에서 실행하면 안된다
			} // 3번 순회하려했는데 2번빆에 못해 오류가 발생.
		}

        Set<String> hSet = new HashSet<>();
		hSet.add("apple");
		hSet.add("banana");
		hSet.add("kiwi");
		hSet.add("melon");
		System.out.println(hSet);	// [banana, apple, kiwi, melon]
	
		// 들어간 순서를 보장하는 Set
		Set<String> linkedSet = new LinkedHashSet<>();
		linkedSet.add("apple");
		linkedSet.add("banana");
		linkedSet.add("kiwi");
		linkedSet.add("melon");
		System.out.println(linkedSet);		// [apple, banana, kiwi, melon]	
    }
}
```