package f08_print;

import java.io.*;

public class APrintExample {

	public static void main(String[] args) {
		File file = new File("data.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(file,true);
			PrintStream ps = new PrintStream(fos,true);	// auto flush
			ps.println(); // 줄바꿈
			ps.println("[프린트 보조 스트림]");
			ps.print(100);
			ps.print("이것은");
			ps.print("마치~~");
			ps.println("magic?!");
			ps.println("을 출력합니다.");
			ps.printf("이것이 저의 키(%d)입니다.", 180);
			ps.println();
			ps.close();
			
			PrintWriter// pw = new PrintWriter(fos,true);
			pw = new PrintWriter(new FileWriter(file,true),true);
			pw.println("PrintWriter 사용방법은 동일");
			pw.print('D');
			pw.printf("%s입니다. %n", "자객");
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
