package n2_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 서버 프로그램
public class AServerExample {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(2002);
			while(true) {
				System.out.println("Client 연결 대기중");
				Socket client = server.accept();
				System.out.println("Client 연결 수락");
				
				InetSocketAddress im = (InetSocketAddress)client.getRemoteSocketAddress();
				System.out.println("client - "+im.getHostString());
				System.out.println("client port : "+im.getPort());
				
				byte[] mana = null;
				String message = null;
				
				OutputStream iam = client.getOutputStream();
				message = "집에 보내줘요";
				mana = message.getBytes("UTF-8");
				iam.write(mana);
				iam.flush();
				System.out.println("데이터 출력 완료");
				
				InputStream is = client.getInputStream();
				mana = new byte[100];
				
				System.out.println("blocking");
				int readdr = is.read(mana);
				message = new String(mana,0,readdr,"UTF-8");
				System.out.println("Client에서 발신한 데이터 : " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				if(server != null) server.close();
			} catch (IOException e1) {}
		}
		
	}

}
