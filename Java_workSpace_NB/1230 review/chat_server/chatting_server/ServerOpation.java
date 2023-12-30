package chatting_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerOpation implements Runnable {
	
	Socket clients;
	
	AloneSController asc;
	
	PrintWriter printer;
	
	BufferedReader reader;
	
	String nickName;
	
	boolean isRun = true;
	
	public ServerOpation(Socket clients, AloneSController asc) {
		this.clients = clients;
		this.asc = asc;
		
		try {
			OutputStream os = clients.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter writer = new BufferedWriter(osw);
			printer = new PrintWriter(writer, true);
			
			reader = new BufferedReader(
					new InputStreamReader(clients.getInputStream())
			);
		} catch (IOException e) {
//			asc.displayText.appendText("Client 연결 오류 : " + e.getMessage());
		}
		
	}

	// 메세지 수신
	@Override
	public void run() {
		asc.printTxt(clients.getRemoteSocketAddress()+"receive 시작");
		while(isRun) {
			try {
				String receiveData = reader.readLine();
				if(receiveData == null) {
					break;
				}
				asc.printTxt(receiveData);
				String[] data = receiveData.split("\\|");
				
				String code = data[0];
				String text = data[1];
				if(code == "0") {
					if(asc.clients.containsKey(text)) {
						asc.printTxt(text+"-사용할 수 없는 닉네임 요청");
						this.printer.println(text+"는 사용할 수 없는 닉네임입니다.");
						
						isRun = false;
						clients.close();	// 소켓 자원 해제
						break;
					} // 닉네임 중복확인
					this.nickName = text;
					asc.clients.put(text, printer);
					String sendData = "";
					for(String name : asc.clients.keySet()) {
						sendData += name+",";
					}
					broadCast(0, sendData);
					broadCast(1, nickName+"님이 입장하셨습니다. 현재인원 : "+asc.clients.size());
					 // 닉네임 등록
					break;
				}else if(code == "1") {
					broadCast(1,nickName+":"+text);
					break;
				}
					
			}	
			 catch (IOException e) {
				 asc.printTxt("client 연결 종료 : "+e.getMessage());
				 isRun = false;
			}
		} // end while
		if(clients != null && !clients.isClosed()) {
			try {
				clients.close();
			} catch (IOException e) {}
		}
		asc.clients.remove(this.nickName);
		
		String list = "";
		for(String name : asc.clients.keySet()) {
			list += name+",";
		}

		// 접속자 목록 갱신
		broadCast(0,list);
		String result = nickName+"님이 나가셨습니다. 방인원 : " + asc.clients.size();
		broadCast(1, result);
		asc.printTxt(result);
	} // end run

	public void broadCast(int i, String string) {
		for(PrintWriter p : asc.clients.values()) {
			p.println(i+":"+string);
		}
		
	}

}
