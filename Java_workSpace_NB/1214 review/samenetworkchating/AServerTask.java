package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AServerTask implements Runnable{

	// client 저장
	Socket aclient;
	
	// 메세지 전달 스트림
	PrintWriter apw;
	
	// 메세지 입력 스트림
	BufferedReader abr;
	
	// client ID
	String userID;
	
	/**
	 * server 로 부터 객체 생성 시 accept 된 Client Socket 정보를
	 * 생성자의 매개변수로 전달받아 필드 초기화 진행
	 */
	
	public AServerTask(Socket aclient) {
		this.aclient = aclient;
		
		try {
			// apw = new PrintWriter(기반스트림, autoFlush);
			// new OutputStream(File,append); 
			apw = new PrintWriter(
					new BufferedWriter(
						new OutputStreamWriter(
							aclient.getOutputStream()
						) 
					) , true
			);
			
			abr = new BufferedReader(
					new InputStreamReader(aclient.getInputStream())
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		// 사용자 아이디 입력 작업 수행
		Runnable arun = new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println("ID 입력 대기");
					
					try {
					userID = abr.readLine();
					} catch(IOException e){
						System.out.println("연결 종료 : " + e.getMessage());
						break;
					}
					System.out.println(userID);
					
					if(userID.trim().equals("")|| AChatServer.ht.containsKey(userID)) {
						// 아이디를 입력한 client에게 사용 불가능한 아이디라고 출력
						apw.println("사용할수 없는 아이디 입니다. 다시 입력해주세요.");
						continue;
					}
					
					AChatServer.ht.put(userID, apw);
					AChatServer.serverPool.submit(AServerTask.this);
					broadCast(userID + "님이 입장하셨습니다. 방인원은 "+AChatServer.ht.size());
					break;
				} // end while
			} // end run
		}; // end arun
		AChatServer.serverPool.submit(arun);
	} // AServerTask

	// client 에서 출력되 내용을 입력받는 receive 기능 수행
	@Override
	public void run() {
		
		while(true)
		try {
			String receiveData = abr.readLine();
			if(receiveData.trim().equals("/quit")) {
				break;
			}else if(receiveData.trim().startsWith("/w")) {
				// 귓속말
				sendMessage(receiveData);
			}else {
				broadCast(userID+":"+receiveData);
			}
		} catch (IOException e) {
			System.out.println("client 통신 오류");
			break;
		}
		
		// 등록된 사용자 정보 삭제
		AChatServer.ht.remove(userID);
		broadCast(userID + "님이 나가셨습니다. 방인원 : "+ AChatServer.ht.size());
	} // end run
	
	// message 를 전달받아 등록된 모든 client 에게 전달
	public void broadCast(String message) {
		// hashtable 에 저장된 value 들의 묶음들을 순회하면서 등록된 모든 client 에게 메세지 출력
		for(PrintWriter w : AChatServer.ht.values()) {
			// 메세지를 입력한 사용자 제외하고 출력
			if(this.apw != w) w.println(message);
		}
	} // end broadCast
	
	// 특정 사용자에게만 메세지가 가게
	public void sendMessage(String message) {
		int begin = message.indexOf(" ")+ 1;
		int end = message.indexOf(" ", begin);
		
		// 두번째 공백 존재하면
		if(end != -1) {
			String id = message.substring(begin,end);
			String dm = message.substring(end+1);
			
			PrintWriter pw = AChatServer.ht.get(id);
			
			if(pw != null) {
				// 아이디가 일치하는 사용자 존재
				pw.println(userID + "님의 귓속말"+ dm);
			}else {
				// 일치하는 사용자가 없을 때
				this.apw.println(id+"님이 존재하지 않습니다.");
			}
		}
	}
	
	
	
} // end class
