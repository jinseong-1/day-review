package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AChatClient {
	
	public static final String IP ="172.30.1.67";
	public static final int PORT = 5003;
	
	// server 와 연결된 socket
	Socket server;
	
	// 서버로 출력할 스트림
	PrintWriter apw;
	
	// 서버에서 입력받을 스트림
	BufferedReader abr;
	
	// console 에서 출력할 메세지 입력받을 스트림
	BufferedReader areader;
	
	// console 반복문 탈출용 flag
	boolean isRun = true;
	
	public AChatClient() {
		try {
			connect();
		} catch (Exception e) {
			System.out.println("서버와 연결이 종료되었습니다.");
			stopClient();
		}
	}
	
	// server connect
	public void connect() throws Exception{
		System.out.println("***** 클라이언트 *****");
		System.out.println("연결요청 : "+IP+":"+PORT);
		server = new Socket(IP,PORT);
		String serverIP = server.getInetAddress().getHostAddress();
		System.out.println("연결 성공 : " + serverIP);
		
		// 입출력 스트림 초기화
		
		// 1. console 에서 문자열 입력받을 스트림
		InputStream im = System.in;
		InputStreamReader areader = new InputStreamReader(im);
		this.areader = new BufferedReader(areader);
		
		// 2. server 에서 출력된 내용을 읽어들일 입력 스트림
		InputStream sis = server.getInputStream();
		InputStreamReader sisr = new InputStreamReader(sis);
		this.abr = new BufferedReader(sisr);
		
		// 3. server 에 메세지를 출력할 스트림
		OutputStream os = server.getOutputStream();
		OutputStreamWriter osm = new OutputStreamWriter(os);
		this.apw = new PrintWriter(osm,true);
		
		// 서버에 전달된 데이터를 수신 대기 및 처리
		receive();
		
		System.out.println("사용할 이름(아이디)를 입력해주세요.");
		while(true) {
			String sendDate;
			// console 에서 사용자가 서버에 전달할 메세지를 입력받음
			sendDate = this.areader.readLine();
			// 메세지 입력
			apw.println(sendDate);
		}
	}
	
	// 메세지 수신
	public void receive() {
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					String receiveData;
					try {
						if((receiveData = abr.readLine()) != null) {
							System.out.println(receiveData);
						}
					} catch (IOException e) {
						System.out.println("서버 통신 오류 : " +e.getMessage());
						stopClient();
						break;
					}
				}	// end while
				System.out.println("스레드 종료");
			} // end run
		}); // end thread
		a.start();
	}
	
	// server 자원 해제
	public void stopClient() {
		if(server != null && !server.isClosed()) {
			try {
				server.close();
				System.out.println("client 종료");
			} catch (IOException e) {}
		}
	}

	public static void main(String[] args) {
		new AChatClient();
	}

}
