package n2_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

// 클라이언트 프로그램
public class AClientExample {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("10.100.205.16",2002);
			System.out.println("[Server에 연결 요청]");
			System.out.println("[Server와 연결 성공");
			
			InputStream im = socket.getInputStream();
			
			byte[] bytes = new byte[100];
			String message = "";
			
			System.out.println("Blocking");
			int reads = im.read(bytes);
			message = new String(bytes, 0, reads, "UTF-8");
			System.out.println("[데이터 받기 완료 : "+message+"]");
			
			OutputStream inserte = socket.getOutputStream();
			message = "배고파요";
			bytes = message.getBytes("UTF-8");
			inserte.write(bytes);
			inserte.flush();
			System.out.println("[데이터 발신 완료]");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
