package f05_reader_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class AReadWriterExample {

	public static void main(String[] args) {
		String path = "C:\\Temp\\data.hwp";
		
		Reader reader = null;
		Writer writer = null;
		
		try {
			// 주의해야할 문장. 여기서 이미 파일에 내용이 삭제되기에 하단으로 내려 실행해야 결과값 도출 가능
			//writer = new FileWriter(path);
			reader = new FileReader(path);
			
			char[] chars = new char[100];
			
			int readChar;
			String result = "";
			
			while((readChar = reader.read(chars)) != -1) {
				result += new String(chars, 0, readChar);
			}
			System.out.println(result);
			
			writer = new FileWriter(path);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("추가할 문자를 입력해주세요 >>");
			String add = sc.nextLine();
			result += add;
			writer.write(result);
			writer.flush();
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) reader.close();
			} catch (IOException e) {}
				
			try {
				if(writer != null) writer.close();
			} catch (IOException e) {}
		}
	}

}
