package chatting_server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class AloneSController implements Initializable{

	@FXML private TextField txtPort;
	@FXML private Button btnStartStop;
	@FXML private ListView<String> txtList;
	@FXML private TextArea displayText;
	
	// Client Thread 관리하는 스레드 풀
	ExecutorService serverPool;
	// 운영체제에서 요청한 포트로 프로세스 할당받아 client socket 연결관리할 class
	ServerSocket server;
	// 연결된 client 의 닉네임을 key 값으로 서버에 발신할 정보를 value 로 저장하는 MAP 객체
	Hashtable<String, PrintWriter> clients;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStartStop.setOnAction(e->{
			String text = btnStartStop.getText();
			if(text.equals("_Start")) {
				startServer();
				btnStartStop.setText("S_top");
			}else {
				stopServer();
				btnStartStop.setText("_Start");
			}
		});
		
	}

	public void startServer() {
		serverPool = Executors.newFixedThreadPool(20);
		clients = new Hashtable<>();
		
		String port = txtPort.getText().trim();
		for(char c : port.toCharArray()) {
			if(c < 48 || c > 57) {
				displayText.appendText("사용할 수 없는 PORT 번호입니다. \n");
				return;
			}
		}
		int portNumber = Integer.parseInt(port);
		try {
			server = new ServerSocket(portNumber);
		} catch (IOException e) {
			displayText.appendText("이미 사용중인 포트입니다. \n");
			stopServer();
			return;
		}
		
		// Thread 관리용
		Runnable run = new Runnable() {
			@Override
			public void run() {
				displayText.appendText("[StartServer]\n");
				while(true) {
					try {
						displayText.appendText("Client 연결 대기중... \n");
						
						Socket client = server.accept();
						String address = client.getRemoteSocketAddress().toString();
						
						displayText.appendText("[연결 수락 :"+address + "]\n");
						serverPool.submit(new ServerOpation(client, AloneSController.this));
					} catch (IOException e) {
						stopServer();
						break;
					}
				} // end while
			} // end run
		}; // end runnable
		serverPool.submit(run);
	}	// end startServer
	
	public void stopServer() {
		if(clients != null && clients.isEmpty()) {
			for(PrintWriter p : clients.values()) {
				if(p != null) p.close();
			}
		}
		
		if(clients != null) clients.clear();
		
		if(clients != null && !server.isClosed()) {
			try {
				server.close();
			} catch (IOException e) {}
		}
		if(serverPool !=null && !serverPool.isShutdown()) {
			serverPool.shutdownNow();
		}
		displayText.appendText("[서버 중지]");
		System.out.println("서버 중지");
		
	} // end stopServer

	// 작업 스레드에서 textArea에 출력하는 UI 작업 처리
	public void printTxt(String string) {
		Platform.runLater(()->{
			displayText.appendText(string+"\n");
		});
	}

	
	
	
	
}
