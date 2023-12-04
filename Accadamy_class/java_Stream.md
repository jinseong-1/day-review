# I.O Stream
- 입력스트림과 출력 스트림을 할때 기준은 현재 작업중인 프로그램 기준

## file class
- 파일 시스템의 파일을 표현하는 클래스
- 파일의 크기, 속성, 이름 등 정보를 제공하며 생성, 삭제 기능도 제공
```
// 특정 경로를 이용해서 찾아갈때. 디렉토리
String dir = "C:/Temp/dir/aaa";

// 윈도우는 경로구분자가 역슬래쉬 2개(\\) : 1개만 쓰면 다른 구분자로 되므로 2개를 쓰면됨
dir = "C:\\Temp\\dir\\aaa";

// 운영체제에 따라 디렉터리 구분자를 변경해주는 정적 구분자
String separator = File.separator;	

dir = "C :"+File.separator+"dir"+File.separator+"aaa";
System.out.println(dir);     결과값 :   C :\dir\aaa

// 현재 경로의 최상위 경로
dir = "";	

File file = new File(dir);	// 경로명 지정
// 절대 경로
System.out.println(file.getAbsolutePath());	// 경로를 지정해주지 않으면 현재 프로젝트의 경로가 나와게 됨
// 저장된 경로
System.out.println(file.getPath());		// 출력되지 않음

// 해당 위치에 폴더나 파일이 존재하면 true, 존재하지 않으면 false
file.exists()
```
- 파일 생성시
```
File file1 = new File("C:\\Temp\\file1.txt");
	if(!file1.exists()) {
		try {		
			boolean isMake = file1.createNewFile();
			System.out.println("파일 생성 여부 : " + isMake); // 파일 생성 여부 : true
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
이렇게 지정하면 C:\\Temp\\file1.txt가 생성됨
```
- 파일 삭제시
```
File file2 = new File("C:\\Temp\\dir\\aaa\\test.txt");
	boolean isDeleted = false;
	isDeleted = file2.delete();
	System.out.println("파일 삭제 여부 : "+isDeleted);
		
	file2 = new File("C:\\Temp\\dir\\aaa");
	isDeleted = file2.delete();
	System.out.println("디렉토리 삭제 여부 : " + isDeleted);
```