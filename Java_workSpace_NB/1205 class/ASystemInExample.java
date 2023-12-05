package f05_reader_writer;

import java.io.IOException;
import java.io.InputStream;

public class ASystemInExample {

	public static void main(String[] args) {
		InputStream is = System.in;
		
		try {
			while(true) {
				int i = is.read();
				System.out.println(i);
				if(i=='q') break;
				System.out.println("입력받은 값은 : " + (char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
