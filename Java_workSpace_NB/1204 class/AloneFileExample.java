package f01_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AloneFileExample {

	public static void main(String[] args) {
		String dir = "D:/Temp/dir/aaa";
		dir = "D:\\Temp\\dir\\aaa";
		
		String separator = File.separator;
		System.out.println(separator); // 운영체제에 따른 디렉토리 구분자 변경
		
		dir = "D : "+File.separator+"dir"+File.separator+"aaa";
		System.out.println(dir);
		
		char separatorChar = File.separatorChar;
		System.out.println(separatorChar);
		
		dir = ""; // 현재 경로의 최상위 경로
		
		System.out.println("dir : " + dir);
		
		File file = new File(dir);
		// 절대경로
		System.out.println(file.getAbsolutePath());	// 출력되지 않음
		// 저장된 경로
		System.out.println(file.getPath());	// 출력되지 않음
		
		file = new File(dir,"Temp");
		// 절대경로
		System.out.println(file.getAbsolutePath());	// C:\Temp
		// 저장된 경로
		System.out.println(file.getPath());			// \Temp
		// file.exists()
		// 해당 위치에 폴더나 파일이 존재하면 true, 존재하지 않으면 false
		
		if(!file.exists()) {
			boolean isMake = file.mkdir();
			System.out.println("디렉토리 생성 여부 : " + isMake); // 디렉토리 생성 여부 : true. 폴더가 없었기에 생성
		}	
		file = new File(file, "dir"+File.separator+"aaa");
		System.out.println("absolute : " + file.getAbsolutePath()); // 디렉토리 생성 여부 : true. 
		
		if(!file.exists()) {
			System.out.println("디렉터리가 존재하지 않음");
			boolean isMake = file.mkdir();
			System.out.println("디렉터리 생성 여부 : "+ isMake);	// 디렉터리 생성 여부 : false
		}
		
		if(!file.exists()) {
			System.out.println("디렉토리가 존재하지 않음");
			boolean isMake = file.mkdirs();
			// mkdirs : 경로상에 정의된 모든 디렉토리를 생성
			System.out.println("디렉토리 생성 여부 : " + isMake);
		}
		String fileName = "test.txt";
		
		file = new File(file, fileName);
		System.out.println("absolute : " + file.getAbsolutePath());
		// C :\Temp\dir\aaa\test.txt
		if(file.exists() == false) {
			System.out.println("파일이 존재하지 않음");
			
			try {
				file.createNewFile();
				System.out.println("새 파일 생성 완료");
			}catch(IOException e) {
				System.out.println("파일 생성 실패 : " + e.getMessage());
			}
		}
		File file1 = new File("C:\\Temp\\file1.txt");
		if(!file1.exists()) {
			try {
				boolean isMake = file1.createNewFile();
				System.out.println("파일 생성 여부 : " + isMake);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String path = file1.getAbsolutePath();
		System.out.println("absolute : " + path);
		
		File temp = new File("C:\\temp");
		File[] temps = temp.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		for(File f : temps) {
			// 폴더나 파일의 마지막 수정 시간을 millis seconds로 반환
			long modified = f.lastModified();
			Date date = new Date(modified);
			String lastModified = sdf.format(date);
			System.out.print(lastModified);
			if(f.isDirectory()) { // 디렉토리 인지아닌지 분별해줌
				System.out.println("\t<dir>\t\t\t"+f.getName());
			}else {
				System.out.println("\t<FILE>\t\t\t"+f.getName());
			}
		}	// end for
		
		// 삭제 - 파일 삭제
		File file2 = new File("C:\\Temp\\dir\\aaa\\test.txt");
		boolean isDeleted = false;
		isDeleted = file2.delete();
		System.out.println("파일 삭제 여부 : " + isDeleted);
		
		// 디렉토리 삭제
		file2 = new File("C:\\Temp\\dir\\aaa");
		isDeleted = file2.delete();
		System.out.println("디렉토리 삭제 여부 : " + isDeleted);
		
	} // end main

}
