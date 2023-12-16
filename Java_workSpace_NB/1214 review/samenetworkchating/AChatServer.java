package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AChatServer {
	
	public static final String IP ="172.30.1.67";
	public static final int PORT = 5003;

	/**
	 * port 할당 및 client 연결 요청
	 */
	ServerSocket serverSocket;
	
	/**
	 * 연결된 클라이언트의 스레드를 관리할 스레드 풀
	 */
	static ExecutorService serverPool;
	
	/**
	 * 연결된 클라이언트의 정보를 저장
	 */
	static Hashtable<String, PrintWriter> ht;
	
	/**
	 *  생성자를 통해서 필드 초기화 및 클라이언트 연결 수락 및 정보 관리
	 */
	public AChatServer() {
		try {
			serverPool = Executors.newFixedThreadPool(10);
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP,PORT));
		} catch (IOException e) {
			System.out.println("bind 할 수 없는 IP 또는 PORT 번호입니다.");
			System.out.println(e.getMessage());
			return;
		}
		
		ht = new Hashtable<>();
		System.out.println("************ 채팅 서버 오픈************");
		
		while(true) {
			try {
				System.out.println("[ Client 연결 기다리는 중...]");
				// client 연결 수락 완료시까지 blocking
				Socket aclinet = serverSocket.accept();
				// 연결 수락이 완료된 client IP 주소
				String AclientIP = aclinet.getInetAddress().getHostAddress();
				System.out.println(AclientIP + "- 연결 수락");
				new AServerTask(aclinet);
			} catch (IOException e) {
				System.out.println("Server 통신 오류 : " + e.getMessage());
				// 연결된 모든 클라이언트 정보 삭제
				ht.clear();
				// 스레드 풀에 등록된 모든 작업 종료
				serverPool.shutdownNow();
				// 할당받은 포트 반납
				if(serverSocket != null && !serverSocket.isClosed()) {
					try {
						serverSocket.close();
					} catch (IOException e1) {}
				}
			} // while 반복문 종료
			break;
		}
	}
	
	public static void main(String[] args) {
		new AChatServer();
	}

}
