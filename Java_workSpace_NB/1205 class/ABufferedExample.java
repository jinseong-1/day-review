package f06_buttered;

import java.io.*;

public class ABufferedExample {

	public static void main(String[] args) throws IOException{
		String originalPath = "C:\\Temp\\cat1.jpg";
		File originalFile = new File(originalPath);
		FileInputStream fis = new FileInputStream(originalFile);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		String copyPath = "C:\\Temp\\dir\\copy.jpg";
		File copyFile = new File(copyPath);
		FileOutputStream fos = new FileOutputStream(copyFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		long startTime = 0, endTime = 0;
		
		int data;
		startTime = System.nanoTime();
		while((data = fis.read()) != -1) {
			fos.write(data);
		}
		fos.flush();
		endTime = System.nanoTime();
		System.out.printf("file : %d ns %n",(endTime - startTime));
		
		startTime = System.nanoTime();
		while((data = bis.read()) != -1) {
			bos.write(data);
		}
		endTime = System.nanoTime();
		System.out.printf("Buffered : &d ns %n",(endTime - startTime));
		
		bos.close();
		bis.close();
		
		System.out.println("copy complete");
	}

}
