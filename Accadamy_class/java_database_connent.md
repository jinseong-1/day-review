# java_database(MYSQL) connect
- JDBC를 사용한 JAVA와 데이터베이스의 연동
    1. jav.sql.* package import
    2. JDBC 드라이버 로딩, DriverManeger에 Driver 등록
    3. 데이터베이스 접속을 위한 Connection 객체 생성
    4. 쿼리문을 실행하기 위한 Statement/PreparedStatement/CallableStatement 객체 생성
    5. 쿼리 실행
    6. 쿼리 실행의 결과 값(int, ResultSet) 사용
    7. 사용된 객체(ResultSet, statement/PrepareStatement/CallableStatement, Connection) **종료**

### JDBC 드라이버 로딩 및 DBMS 접속
- JDBC 드라이버 로딩 단계에서는 드라이버 인터페이스를 구현하는 작업
- Class.forName() 메소드를 이용하여 JDBC 드라이버를 로딩
```
Class.forName(String className);
```
- JDBC 드라이버가 로딩되면 자동으로 객체가 생성
- DriverManager 클래스에 등록
```
try{
    Class.forName("com.nysql.jdbc.Driver");
} catch(SQLException ex){
    예외 발생 처리
}
```
* Driver가 없는 경우 따로 받아야함
    - <a href="https://dev.mysql.com/downloads/connector/j/">mysql 사이트</a>

#### Connection 객체 생성하기
- JDBC 드라이버에서 데이터베이스와 연결된 커넥션을 가져오기 위해 DriverManager 클래스의 **get**Connection() 메소드 사용
- DriverManager 클래스로 Connection 객체를 생성할때 JDBC 드라이버를 검색하고 검색된 드라이버를 이용하여 Connection 객체를 생성한 후 반환
##### 생성방법
1. 쿼리스트링으로 직접 아이디와 비밀번호를 입력하는 경우
```
Connection conn = DriverManager.getConnection(
									? -> 쿼리스트링
		"jdbc:mysql://localhost: 포트번호 ? user= 지정아이디 & password= 지정패스워드"
);
```
2. 쿼리스트링으로 지정하는게 아닌 위치로 하는 방법
```
conn = DriverManager.getConnection(
	"jdbc:mysql://localhost:포트번호",
	"아이디",
	"패스워드"
);
```
3. Properties 객체 사용
```
Properties prop = new Properties();
	prop.setProperty("user","아이디");
	prop.setProperty("password", "패스워드");
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost:포트번호",prop);
```
4. Properties 파일 사용
```
File file = new File("properties파일이 저장된 위치");
    FileReader reader = new FileReader(file);
    prop = new Properties();			// 예외처리
    prop.load(reader);					// 예외처리
			
    System.out.println(prop);
			
    String url = prop.getProperty("url");
    System.out.println(url);
	
    conn = DriverManager.getConnection(url,prop);
```
- Properties 파일
```
! mysql.properties
# mysql properties profile
url = jdbc:mysql://localhost:포트번호/지정스키마
user=아이디
password=패스워드
```
- **SQL파일을 썻다면 close하는게 매우 중요**

### Statement 객체로 데이터 접근

#### Statement
- 정적인 쿼리에 사용
- 하나의 쿼리를 사용하고나면 더이상 사용불가
- 하나의 쿼리를 끝내면 반드시 **close()**를 사용해서 자원해제를 해야함

#### Statement 의 종류
- executeQuery(String sql) : SELECT 문을 실행할 때 사용(ResultSet 객체 반환)
- excuteUpdate(String sql) : insert, update, delete와 관련된 SQL문 실행시 사용(int 객체 반환)
- executeQuery 사용예시
    ```
    stmt = conn.createStatement();
    rs = stmt.executeQuery(sql);

        while(rs.next()) {
            // 	1		2		 3		 4 		 5		   6		7	   8
            // userID, name, birthYear, addr, mobile1, ,mobile2, height, mDate
            // 순번, 이름 다 사용해도 상관없음
            String userID = rs.getString(1);
            String name = rs.getString(2);
            int birthYear = rs.getInt("birthYear");
            String addr = rs.getString("addr");
            String moblie1 = rs.getString(5);
            String moblie2 = rs.getString(6);
            int height = rs.getInt("height");
            // import java.util.Date;
            Date mDate = rs.getDate(8);
            String result = String.format("%s-%s-%d-%s",userID,name,birthYear,addr);
            System.out.println(result);
            System.out.println("-----------------");
        }
        // 오픈한 순서의 역순으로 닫아주면 됨
        rs.close();
        stmt.close();
    ```
- executeUpdate 사용예시
```
    Scanner sc = new Scanner(System.in);
		System.out.println("userID를 입력해 주세요");
		String id = sc.next();
		System.out.println("이름을 입력해주세요.");
		String name = sc.next();
		System.out.println("생년월일을 입력해주세요 (ex) 1992");
		int birthYear = sc.nextInt();
		System.out.println("주소를 입력해주세요 (도시이름 2글자)");
		String addr = sc.next();
			
		sql ="INSERT INTO userTbl(userID,name,birthYear,addr)"+ "VALUES('"+id+"','"+name+"',"+birthYear+" ,'"+addr+"')";
		System.out.println(sql);
			
		// 질의를 수행하기 위한 statment 객체 생성
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		System.out.println(result + "개의 행 삽입 완료");
```
### PreparedStatement 객체로 데이터 접근하기

#### PreparedStatement 객체
- 동적인 쿼리에 사용
- PreparedStatement 객체는 하나의 객체로 여러번 쿼리를 실행할 수 있으며 동일한 쿼리문을 특정 값만 바꿔서 여러 번 실행해야 할 때 매개변수가 많아서 쿼리문을 정리해야 할 때 유용
- 기본형태
```
PreparedStatement prepareStatement(String sql) throws SQLException
```

#### PreparedStatement 사용방법
- executeQuery() method로 데이터 조회
```
int executeQuery() throws SQLException
```


## eclipse 에서 sql이랑 비슷하게 쓸수있게 하는 방법
- eclipse 에서 상단 메뉴 중 help - install new software - datebase 클릭 후 다운로드 실행