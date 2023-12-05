package f05_reader_writer;

import java.io.*;
import java.util.Arrays;

public class AReaderExample {

	public static void main(String[] args) {

		/*
		
		*/
		try {
			Reader reader = new FileReader("C:\\temp\\data.hwp");
			int readData;
			/*
			while(true) {
				// 2byte의 문자 기반으로 입력 받음
				readData = reader.read();
				// EOF == -1
				if(readData == -1) break;
			}
			*/
			char[] chuf = new char[100];
			while((readData = reader.read(chuf)) != -1) {
				System.out.println(readData);
				System.out.println(Arrays.toString(chuf));
				String result = new String(chuf, 0, readData);
				System.out.println(result);
			}
			// 하단에 close를 빼먹으면 안됨
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
