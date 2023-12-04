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

## OutputStream
- 바이트 기반 출력 스트림의 최상위 클래스로 추상 클래스

```
String path = "C:\\Temp\\file2.txt";
```
```
try {
	// 파일은 직접 생성. 파일 새로 쓰기, 기존파일 덮어쓰기
	OutputStream os = new FileOutputStream(path(,fauls));		
	// 기본값은 false. 즉, 새로쓰고, true를 쓰면 기존데이터는 삭제하지않고 이어쓰는 것
	OutputStream os = new FileOutputStream(path,true);		
	String s = "한글";
		byte[] strs = s.getBytes();
		System.out.println(Arrays.toString(strs));		결과값 : [-19, -107, -100, -22, -72, -128]
		/*
		for(int i =0;i<strs.length;i++) {
			// 1byte씩 출력
			os.write(strs[i]);
		}
		*/
		// 매개변수로 넘겨받은 모든 byte배열을 출력
		// os.write(strs);
		os.write(strs,3,3);			
		os.flush();
		os.close();
	} 

	// FileNotFoundException : 디렉토리 파일이 없을때
	catch (FileNotFoundException e) {		
		e.printStackTrace();
	} 
	// 입출력 제외
	catch (IOException e) {		
		e.printStackTrace();
}
```

## inputStream

### 파일 읽어오기
```
// 없으면 에러가 나오게 됨. 굳이 없는 데이터를 다시 만들어서 읽을 필요가 없기 때문
InputStream is = null;		

	try {
		File file = new File("C:\\temp\\file2.txt");
		is = new FileInputStream(file);
		int readByte = 0;
			
		while(true) {
			byte 단위로 읽어와서 읽은 byte를 int type으로 반환
			readByte = is.read();
			System.out.println(readByte);
			// EOF 	=> End Of File == -1
			if(readByte == -1) break;
		} end while
			
		is.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
```

### 파일 읽어오면서 길이(용량) 확인
```
try {
	InputStream is = new FileInputStream("C:\\temp\\file2.txt");
	int readBytes = 0;
	연결된 파일에서 읽어 들일수 있는 데이터 크기(byte 크기)
	읽어올수있는 파일의 크기확인
	int size = is.available();		
			
	byte[] bytes = new byte[100];
	
	String data = "";
	
	while(true) {
		readBytes = is.read(bytes);
		System.out.println("읽어들인 바이트 크기 : "+readBytes);
		if(readBytes == -1) break;
		data += new String(bytes,0,readBytes);
		//data += new String(bytes);
	}
	System.out.println(data);
	System.out.println(data.length());
	
	is.close();
	System.out.println(size);
} catch (IOException e) {
	e.printStackTrace();
}
```

### 파일 읽고 쓰기
```
File file = new File("src\\f03_input\\ReadExample.java");
	System.out.println(file.length());
		
	try {
		InputStream is = new FileInputStream(file);
		
		int data;
			
		// Console에 출력
		OutputStream os = System.out;		
		while((data = is.read())!= -1) {
			os.write(data);
		}
			
		os.flush();
		System.out.println("끝");
		os.close();
		is.close();
		close로 닫았기때문에 아래 문장들은 나오지않음
		System.out.println("끝");
		System.out.println("끝");
	} catch (IOException e) {
		e.printStackTrace();
	}
```

### 같은 파일을 다른 디렉토리에 복사하기
```
String original = "C:\\Temp\\cat1.jpg"; 원본데이터
String targetDir = "C:\\Temp\\images"; 복사한 파일을 저장할 디렉토리
String copyFile = "copy.jpg"; 복사한 파일명
		
	File file = new File(targetDir);
	// file 객체에 지정된 위치에 파일 또는 디렉토리가 존재하지 않을 경우
	if(!file.exists()) {
		file.mkdirs();
		System.out.println("디렉토리 생성 완료");
	}
		
	File target = new File(targetDir,copyFile);
	System.out.println(target.getAbsolutePath());
		
	try(InputStream is = new FileInputStream(original);
		OutputStream os = new FileOutputStream(target);){
		
		while(true) {
			int read = is.read();
			if(read == -1 )break;
			os.write(read);
		}
		os.flush();
		
		위에 while문을 간단하게 한줄로 표현
		is.transferTo(os);

	} catch (IOException e) {
		System.out.println("copy 실패 : " + e.getMessage());
	}
```