package f05_reader_writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AWriteExample {

	public static void main(String[] args) {

		try {
			Writer writer = new FileWriter("C:\\Temp\\data1.hwp");
			String strs = "홍길동";
			char[] chars = strs.toCharArray();
			/*
			for(char c : chars) {
				writer.write(c);
			}
			*/
			// writer.write(chars);
			// writer.write(chars,2,1);
			writer.write("호형호제");
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
