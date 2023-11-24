# Math
- 수학 계산에 사용할 수 있는 정적 메소드를 제공하는 class

```
int v1 = Math.abs(-5);
double v2 = Math.abs(-3.14);
System.out.println("v1 : " + v1);	// 5
System.out.println("v2 : " + v2);	// 3.14
```

## 내림(floor)
```
double v3 = Math.floor(5.3);
double v4 = Math.floor(-5.3);
System.out.println("v3 : " + v4);	// 5.0
System.out.println("v4 : " + v3);	// -6.0
```

## 올림(ceil)
```
double v5 = Math.ceil(5.3);
double v6 = Math.ceil(-5.3);
System.out.println("v5 : " + v5);	// 6.0
System.out.println("v6 : " + v6);	// -5.0
```

## 반올림(rint)
```
// 소수점 첫째자리에서 반올림하고 값을 double type으로 반환
double v11 = Math.rint(5.311);
double v12 = Math.rint(5.511);
System.out.println("v11 : " + v11);	// 5.0
System.out.println("v12 : " + v12);	// 6.0
		
// 반올림하고나서 long 타입의 정수값으로 결과 반환
long v13 = Math.round(5.451352);
System.out.println("v13 : " + v13); // 5
```

## 거듭 제곱(pow)
- a와 b에 대한 제곱 연산
```
double v14 = Math.pow(2, 10);
System.out.println("v14 : " + v14); // 1024
```
- 매개변수의 제곱근을 구함.
```
// 16의 제곱근 4 sqrt(Square Root);
double v15 = Math.sqrt(9);
System.out.println("v15 : " + v15);	// 3.0
```
- 두 수의 값의 차이를 정수로 반환
```		
int v16 = Math.subtractExact(11, -6);
System.out.println("v16 : "+ v16);
```

# Format
- 숫자와 날짜를 원하는 형식의 문자열로 변환 시키는 것.
    - 숫자형식 : DecimalFormat
    - 날짜형식 : SimpleDateFormat
    - 매개변수화 된 문자열 형식 : MessageFormat

## DecimalFormat
- 숫자형식

```
import java.text.DecimalFormat;
    double num = 123456.789;
    //0 or #
	DecimalFormat df = new DecimalFormat("0");
    String str = df.format(num);
    System.out.println("0 : "+str); 	// 0 : 123457
```
```
df = new DecimalFormat("0.0");
str = df.format(num);
System.out.println("0.0 : " + str); 	// 0.0 : 123456.8
df.applyPattern("0.00");
str = df.format(num);
System.out.println("0.00 : " + str); 	// 0.00 : 123456.79
```

#### 10진수의 남은 자리를 0으로 채움
```
df.applyPattern("000000000000000000.00");
str = df.format(num);
System.out.println("0000000000000000.00 : " + str); // 0000000000000000.00 : 000000000000123456.79
```

#### 10진수의 남은 자리를 0으로 채우지 않음
```
df.applyPattern("###############.##");
str = df.format(num);
System.out.println("###############.## : " + str); // ###############.## : 123456.79
```

#### 1000의 자리마다 ","를 찍어주겠다는 표현
```
df.applyPattern("#,###.#");
str = df.format(num);
System.out.println("#,###.## : " + str);		// #,###.## : 123,456.8
```

## MessageFormat
- 매개변수화 된 문자열 형식

#### 하나하나 전부 값을 대입할 경우
```
import java.text.MessageFormat;

    String text = "회원 ID : {0} \n회원이름 : {1} \n전화번호 : {2}";
	String result = MessageFormat.format(text, "id001","홍길동","01012345678");
	System.out.println(result);    
결과값 :
회원 ID : id001 
회원이름 : 홍길동 
전화번호 : 01012345678
```

#### 배열을 이용하여 대입시킬 때
```
String text2 = "학번은 {0}, 이름은 {1}, 전화번호는 {2}";
Object[] arguments = {1, "이몽룡", "01098765432"};
String result2 = MessageFormat.format(text2, arguments);
System.out.println(result2);
결과값 : 학번은 1, 이름은 이몽룡, 전화번호는 01098765432
```

#### 생성자를 이용하여 대입시킬 때
 - 기본생성자가 없기에 꼭 생성자 지정을 해줘야함
```		
MessageFormat format = new MessageFormat(text2);
String result3 = format.format(arguments);
System.out.println(result3);
결과값 : 학번은 1, 이름은 이몽룡, 전화번호는 01098765432
```

## DateFormat

```
//@since 1.0ver 부터
import java.util.Date;
    Date date = new Date();     // system이 가지고있는 현재시간 표시
    String result = String.format("날짜 시간 서식 : %tY년 %<tm월 %<td일 %<tH시 %<tM분 %<tS초",date);
		System.out.println(result);
결과값 : Fri Nov 24 11:10:25 KST 2023
```

위와 같이 표시하는게 귀찮아서 나온게 Simpleformat
```
import java.text.SimpleDateFormat;
    SimpleDateFormat sdf = new SimpleDateFormat();
    String now = sdf.format(date);
    System.out.println(now);
결과값 : 23. 11. 24. 오전 11:10
```
- 표준으로 년월일시로 지정되어있고 이것을 더 직관적으로 바꾸기 위해 아래와같이 양식으로 표시하기도 함
```
//                          년도-월-일 요일 오전/후 시 분 초 밀리초 1년중 현재가 몇일째
sdf = new SimpleDateFormat("yyyy-mm-dd E요일 a KK :mm:ss.SSS D");
now = sdf.format(date);
System.out.println(now);

    // 2023-14-24 금요일 오전 11 :14:02.017 328
```

```
int year = date.getYear();
int month = date.getMonth()+1;
int day = date.getDay();
System.out.println(year+"년"+month+"월"+day+"일");
```
- 위와같은 양식으로 다룰순있지만 곧 없어질 예정이라 왠만하면 안쓰는게 좋음

# time

## Calendar
- 현재 날짜에 대해 조회할수 있음
```
import java.util.Calendar;
import java.util.Date;
    Calendar now = Calendar.getInstance();
    System.out.println(date);
	System.out.println(date.getTime());	// 현재시간을 mille sec로 표시

//년도
int year = now.get(Calendar.YEAR);

// 월 0 ~ 11 : 0 - 1월, 11 - 12월
	int month = now.get(Calendar.MONTH)+1;
	// 월 중 날짜
	int day = now.get(Calendar.DAY_OF_MONTH);
	// 주 중 날짜, 요일
	// SUNDAY : 1, SATURADAY : 7
	int week = now.get(Calendar.DAY_OF_WEEK);
	System.out.println(Calendar.SUNDAY);
	System.out.println(Calendar.MONDAY);
		
	String strWeek = "";
		switch(week) {
			case Calendar.MONDAY : 
				strWeek = "월";
				break;
			case Calendar.TUESDAY : 
				strWeek = "화";
				break;
			case Calendar.WEDNESDAY : 
				strWeek = "수";
				break;
			case Calendar.THURSDAY : 
				strWeek = "목";
				break;
			case Calendar.FRIDAY : 
				strWeek = "금";
				break;
			case Calendar.SATURDAY : 
				strWeek = "토";
				break;
			case Calendar.SUNDAY : 
				strWeek = "일";
				break;
		}	// end week
		
	int hour = now.get(Calendar.HOUR);			// 시
	int minute = now.get(Calendar.MINUTE);		// 분
	int second = now.get(Calendar.SECOND);		// 초
		
	String result = "{0}년 {1}월 {2}일 ({3})요일 {4}시 {5}분 {6}초";
	Object[] arguments = {
		year,month,day,strWeek,hour,minute,second
	};
	String str = MessageFormat.format(result,  arguments);
	System.out.println(str);
```

## LocalDateTime
- 시간 정보를 쉽게 다룰 수 있도록 추가된 class
- LocalDate, LocalTime, LocalDateTime
```
import java.time.LocalDate;
import java.time.LocalTime;

    LocalDate toDay = LocalDate.now();      
	LocalTime present = LocalTime.now();
	System.out.println(toDay);          // 2023-11-24
	System.out.println(present);        // 11:47:16.831191300

    LocalDate birthDay = LocalDate.of(2013, 07, 10);
	System.out.println(birthDay);       // 2013-07-10
		
	LocalTime birthTime = LocalTime.of(02, 02, 10);
	birthTime = LocalTime.of(02, 02,10,100000);
	System.out.println(birthTime);      // 02:02:10.000100

    System.out.println(toDay.getYear());        // 2023
	System.out.println(toDay.getMonthValue());  // 11
	System.out.println(toDay.getDayOfMonth());  // 24
	System.out.println(toDay.getDayOfWeek());   // FRIDAY
	System.out.println(toDay.getDayOfYear());   // 328

    System.out.println(present.getHour()+":"+present.getMinute()+":"+present.getSecond());      // 11:49:50(현재시간)
```

#### 날짜계산

##### 하나씩 떼서 계산할 때
```
// 1년 전
LocalDate target = toDay.minusYears(1);
System.out.println(target);
		
// 10년 후
target = toDay.plusYears(10);
System.out.println(target);
		
// 5달 전
target = toDay.minusMonths(5);
System.out.println(target);
		
// 20일 전
target = toDay.minusDays(20);
System.out.println(target);
		
// 10시간 전
LocalTime targetTime = present.minusHours(10);
System.out.println(targetTime);
		
// 5시간 후
targetTime = present.plusHours(5);
System.out.println(targetTime);
		
// 10분 전
targetTime = present.minusMinutes(10);
System.out.println(targetTime);
		
// 30초 후
targetTime = present.plusSeconds(30);
System.out.println(targetTime);
```

##### 현재 날짜와 시간
```
import java.time.LocalDateTime;
    LocalDateTime targetDateTime = LocalDateTime.now();
    System.out.println(targetDateTime);

    targetDateTime = LocalDateTime.of(target, targetTime);
    targetDateTime = LocalDateTime.of(2023,11,24,12,11,23);
    System.out.println(targetDateTime);
```

##### 지정된 시간을 가지고 객체 생성
```
targetDateTime = targetDateTime
					.withYear(2024)
					.withMonth(10)
					.withDayOfMonth(5)
					.withHour(13)
					.withSecond(20);
System.out.println(targetDateTime);
```
- 지정된 패턴을 이용하여 문자열 생성
- 패턴 지정 클래스
```
import java.time.format.DateTimeFormatter;
    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy년MM월dd일 E요일 a KK시mm분ss초");

결과값 : 2024년10월05일 토요일 오후 01시11분20초
```

- 문자열을 시간 정보로 변환
- 따로 패턴을 지정하지 않으면 기본 타입으로 전달해야함.
<br/>
-  LocaldateTime : 날짜와 시간 모두 확인가능
```
targetDateTime = LocalDateTime.parse("1983-02-07T10:11:10");
System.out.println(targetDateTime);
결과값 : 
1983-02-07T10:11:10

// input type = "date","2023-10-10"
LocalDate date = LocalDate.parse("2023-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

date = LocalDate.parse("2023년11월24일 12시27분30초",DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
System.out.println(date);
```