package f03_input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class AImputStreamExample {

	public static void main(String[] args) {
		// 파일을 불러오고 -1이 되면(더이상 읽어올게 없으면) 멈춤
		InputStream is = null;
		
		try {
			File file = new File("C:\\temp\\file2.txt");
			is = new FileInputStream(file);
			int readByte = 0;
			
			while(true) {
				// byte 단위로 읽어와서 읽은 byte를 int type로 반환
				readByte = is.read();
				System.out.println(readByte);
				if(readByte == -1) break;
			}	// end while
			
			is.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
