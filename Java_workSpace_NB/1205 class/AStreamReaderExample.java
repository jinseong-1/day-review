package f06_buttered;

import java.io.*;

public class AStreamReaderExample {

	public static void main(String[] args) {
		
		InputStream is = System.in;
		try {
			Reader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			
			System.out.println("입력 대기중...");
			
			BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(
					new FileOutputStream("C:\\Temp\\fos.txt",true)
				)
			);
			String readData = "";
			while(true) {
				readData = br.readLine();
				// 입력한 문자열이 quit로 시작하면 true
				if(readData.startsWith("quit")) break;
				writer.write(readData);
				// 줄바꿈
				writer.newLine();
			}
			writer.flush();
			writer.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

}
