import java.util.Scanner;

public class Practice01StringPrint {

	// 프로그램의 실행과 끝
	public static void main(String[] args) {
		
		String str = "Hello Java";
		System.out.println(str);
		
		// int str;  -> 중복선언으로 컴파일 에러
		
		String abc;
		abc = "Hello JAVA";
		System.out.println(abc);
		
		
		// System.out == 운영체제의 터미널과 연결된 객체
		/*
 			print(); - 넘겨받은 값을 출력하고 줄바꿈을 하지않음.
 			println(); - 출력하고 줄바꿈을 자동으로 처리함.
 			printf(); - 지정된 형식에 따라 출력
		*/
		System.out.print("안녕");
		System.out.print("하세요. 행복한 아침입니다!");
		// 자동으로 줄바꿈이 있어서 컴파일에러가 나오지않음.
		System.out.println();		
		System.out.println("\"안녕하세요\"");
		
		/*
			escape 문자
			\'
			\"
			\r 		캐리지 리턴
			\n 		new line or line feed
			\t		"\t안녕" -> tab키를 눌린거 만큼 간격을 표현
			\\		역슬러쉬 라는 특수문자 표현
		*/
		
	/*
		안녕하세요.
		반갑습니다. 오늘은 날씨가 덥네요..
		
		"		안녕하세요.\r\n"
		+ "		반갑습니다. 오늘은 날씨가 덥네요.."
	*/
		System.out.println("안녕\t하세요...");
		System.out.println("정말\t반갑네요...");
		
		// printf : 형식(format)을 지정해서 출력하는 메소드
		int score = 100;
		String name = "박진성";
		// ~님의 점수는 ~점 입니다.
		System.out.println(name+"님의 점수는"+score+"점 입니다.");
		System.out.printf("%s님의 점수는 %d입니다.\n",name,score);
		// 데이터 타입이 틀리면 실행 시 오류 발생
		//System.out.printf("%s님의 점수는 %d입니다.",score,name);
		
		/*
			데이터 타입 형식 지정
			%d - int 10진법의 정수
			%o - 8진법 정수
			%x - 16진법 정수
			%b - boolean 타입
			%f - float - 실수형태로 출력(소수점 자리)
			%c - Character	하나의 문자
			%s - String 문자열
			%n - new line 줄바꿈 표현
			
			Optional
			%[-][n][.m][,n]
			%[-] : 전체 자리수가 지정된 경우 왼쪽으로 정렬하고 빈칸에 공백 출력
			%-5d, 1000 == 1000[ ]
			%[n] : 출력할 전체 자리수를 지정(오른쪽 정렬)
			%5d, 1000 == [ ]1000
			%[0] : 전체 자리수가 지정되어 있을 때 빈자리를 0으로 표현
			%5d, 1000 == 01000
			%[.m] : 소수점 아래 자리수를 지정. 잘리는 소수점 자리는 반올림하여 표현
			%.2f, 82.687 == 82.69
			%[,] : 정수의 자리수 표현
			%,08d, 1000000 = 01,000,000
		*/
		
		String title = "Java";
		int price = 10000000;	//0 -> 7개
		System.out.printf("%s의 교재는 %,020d입니다. %n",title,price);
		System.out.printf("%s의 교재는 %-,20d입니다. %n",title,price);
		
		System.out.printf("%f %n",1234.123);		// %f를 그냥 쓰면 7자리에서 반올림하게 됨
		System.out.printf("%,.2f %n",1234.123);
		
		
		// 문자열(String)의 동등 비교
		// name1 변수에 문자열 홍길동 저장
		String name1 = "홍길동";
		// name2 변수에 문자열 홍길동 저장		
		String name2 = "홍길동";
		
		System.out.printf("name1 : %s %n", name1);
		System.out.printf("name2 : %s %n", name2);
		System.out.printf("name1 == name2 : %b %n", (name1 == name2));
		
		String name3 = new String("홍길동");
		System.out.printf("name3 : %s %n", name3);
		System.out.printf("name1 == name3 : %b %n", (name1 == name3));
		
		String name4 = "박진성";
		System.out.printf("name4 : %s %n", name4);
		System.out.printf("name1 == name4 : %b %n", (name1 == name4));
		
		// 문자열 데이터가 일치하는지 비교할 때는 equals() 함수를 이용
		boolean isEquals = name1.equals(name3);
		System.out.println(isEquals);
		
		Scanner sc = new Scanner(System.in);
		// 사용자에게 id와 password를 입력받아 임의로 지정한 값과 일치하는지 비교하는 조건문
		String uid = "id001";
		String upw = "pw001";
		
		System.out.println("ID를 입력해 주세요 >");
		String id = sc.next();	// 단어 입력
		
		System.out.println("비밀번호를 입력해 주세요 >");
		String pw = sc.next();
		
		System.out.println("입력하신 ID : " + id);
		System.out.println("입력하신 PW : " + pw);
		
		// 비교
		//if(uid == id && upw == pw) {
		if(uid.equals(id) && upw.equals(pw)) {
			System.out.println("정상적으로 로그인 되었습니다.");
		}else {
			System.out.println("아이이도아 패스워드가 일치하지 않습니다.");
		}
	}
}


















