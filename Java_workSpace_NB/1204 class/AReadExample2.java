package f03_input;

import java.io.*;
import java.util.Arrays;

public class AReadExample2 {

	public static void main(String[] args) throws IOException {
		
		InputStream is = new FileInputStream("C:\\Temp\\file2.txt");
		byte[] bytes = new byte[100];
		int readBytes = is.read(bytes);
		System.out.println(Arrays.toString(bytes));
		System.out.println(readBytes);
		String result = new String(bytes);
		System.out.println(result);
		is.close();
		
		// 한번 연결이 끊긴 스트림은 재사용 불가
		is = new FileInputStream("C:\\temp\\file2.txt");
		int available = is.available();
		System.out.println("읽어 들일수있는 파일의 크기 : " + available);
		bytes = new byte[available];
		
		readBytes = is.read(bytes,0,bytes.length);
		System.out.println(Arrays.toString(bytes));
		System.out.println(readBytes);
		available = is.available();
		System.out.println("읽어 들일수 있는 파일의 크기 : "+ available); // 상단에 read에서 이미 다 읽었기때문에 여기선 더이상 읽을게 없어 0으로 출력
		is.close();
	}

}
