# Objects
- Object의 기능을 도와주는 유틸리티 클래스(Objects)
```
import java.util.Objects;

    String a = null;
    String a1 = null;
		
	boolean isChecked = Objects.isNull(a);
		
	// a는 null 인가? true : false;
	System.out.println(isChecked);      // true
	System.out.println("1----------------------");
		
	// a1은 null이 아닌가? true : false;
		isChecked = Objects.nonNull(a1);
	System.out.println(isChecked);      // false
	System.out.println("2----------------------");
		
	// isChecked = a.equals(a1);		NullPointerException
	isChecked = Objects.equals(a,a1);
	System.out.println(isChecked);      // false
	System.out.println("3---------------------");
		
	String c = new String("홍길동");
	String d = new String("홍길동");
	System.out.println(c == d);         // false
	System.out.println("4---------------------");
		
	isChecked = Objects.equals(a, c);
	System.out.println(isChecked);      // false
	System.out.println("5---------------------");
	isChecked = Objects.equals(c, d);
	System.out.println(isChecked);      // true
	System.out.println("6---------------------");
		
	int[] arr1 = new int[]{1,2,3,4,5};
	int[] arr2 = new int[]{1,2,3,4,5};
		
	// 주소값을 비교 arr1 == arr2 와 동일
	isChecked = Objects.equals(arr1,  arr2);
	System.out.println(isChecked);      //false
	System.out.println("7--------------------");
	
	// 항목에 있는 값을 비교
	isChecked = Objects.deepEquals(arr1, arr2);
	System.out.println(isChecked);      //true
	System.out.println("8--------------------");
		
	// System.out.println(a.toString());		NullPointerException
	System.out.println(Objects.toString(a));        // null
	System.out.println(Objects.toString(a1,"a1은 참조하는 값이 없습니다."));
		
	int code = Objects.hashCode(arr2);
	System.out.println(code);
	System.out.println(arr2.hashCode());
	System.out.println(a);
	// null 인 참조값은 hashcode호출 시 0을 반환
	System.out.println(Objects.hashCode(a));
```

# Arrays

## ToString
`java.util.Arrays utility class` : 배열을 쉽게 다룰 수 있도록 기능을 정의해놓은 class
```
public static void main(String[] args) {
	int[] scores = {99,10,97,96,98};
	System.out.println(scores);
	//for(int i = 0; i<scores.length;i++) {
	for(int i : scores) {
		System.out.print(i + " ");
	}
	System.out.println();
		
	String result = Arrays.toString(scores);
	System.out.println(result);
    }
}
```

## Sort
- 정렬해주는 클래스
- sorting == 정렬, 분류
```
import java.util.Arrays;
import java.util.Comparator;
```
##### 오름차순 정렬
```
int[] scores = {100,99,98,60,97};
	Arrays.sort(scores,2,4);		// 지정한 위치만 정렬하는 것 indexnumber~indexnumber
	// {100,99,98,60,97};
	System.out.println(Arrays.toString(scores));
	
	Arrays.sort(scores);
	System.out.println(Arrays.toString(scores));
	
	String[] names = {"홍길동","박종현","김규민","이준호"};
	System.out.println(Arrays.toString(names));
	Arrays.sort(names);
	System.out.println(Arrays.toString(names));
```
##### 역순 정렬
```		
	Arrays.sort(names,new Comparator<String>() {
	@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	});
	
	System.out.println(Arrays.toString(names));
```

### fill
 - 1번째 인덱스부터 3번째 인덱스 이전까지 배열의 값을 매개변수로 전달한 값으로 채운다.
```
Arrays.fill(names,1,3, "연");
System.out.println(Arrays.toString(names));

// 모든 항목을 null로 채운다.
Arrays.fill(names, null);
System.out.println(Arrays.toString(names));
```

### Search
- search : 지정된 값이 배열의 몇번째 index에 존재하는지 검색
- 2진 탐색 tree : 가운데에서부터 시작해서 검색해나가는 것
```
import java.util.Arrays;

	int[] scores = {1, 10, 5, 7, 9};
	//				0	1  2  3  4
	//			   -1  -2 -3 -4 -5 -6
	
	int index = Arrays.binarySearch(scores, 10);
	System.out.println("찾은 인덱스 : " + index);		// -6
    index = Arrays.binarySearch(scores, 8);
	System.out.println("찾은 인덱스 : " + index);		// -5

    Arrays.sort(scores);
	int index = Arrays.binarySearch(scores, 10);
	System.out.println("찾은 인덱스 : " + index);		// 4
	index = Arrays.binarySearch(scores, 8);
	System.out.println("찾은 인덱스 : " + index);		// -4
```
