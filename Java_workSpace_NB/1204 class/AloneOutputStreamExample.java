package f02_output;

import java.io.*;
import java.util.Arrays;

public class AloneOutputStreamExample {

	public static void main(String[] args) {
		
		String path = "C:\\Temp\\file2.txt";
		// 예외처리하는게 중요함
		try {
			OutputStream os = new FileOutputStream(path,true);
			String s = "한글";
			byte[] strs = s.getBytes();
			System.out.println(Arrays.toString(strs));
			/*
			for(int i =0; i<strs.length;i++) {
				os.write(strs[i]);
			}
			*/
			os.write(strs,3,3);
			
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end main

}
