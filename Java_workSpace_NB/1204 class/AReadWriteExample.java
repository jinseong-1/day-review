package f03_input;

import java.io.*;

public class AReadWriteExample {

	public static void main(String[] args) {

		File file = new File("src\\f03_input\\AReadExample.java");
		System.out.println(file.length());
		
		try {
			InputStream is = new FileInputStream(file);
			int data;
			OutputStream os = System.out;
			while((data = is.read())!=-1) {
				os.write(data);
			}
			
			os.flush();
			System.out.println("끝");
			os.close();
			is.close();
			System.out.println("end");
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // end main

} // end class
