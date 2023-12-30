package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AloneCController implements Initializable{

	@FXML private TextArea txtDisplay;
	@FXML private ListView<String> listView;
	@FXML private TextField txtIp, txtPort, txtNick, txtInput;
	@FXML private Button btnConn, btnSend;
	
	Socket server;
	InetAddress ip;
	int port;
	PrintWriter priter;
	BufferedReader bfr;
	String nickName;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnConn.setOnAction(e->{
			String ip = txtIp.getText().trim();
			if(ip.equals("")) {
				txtDisplay.appendText("IP 주소를 작성해주세요");
				txtIp.requestFocus();
				return;
			}
			
			try {
				this.ip = InetAddress.getByName(ip);
			} catch (UnknownHostException e1) {
				txtDisplay.appendText("사용할 수 없는 주소입니다.");
				txtIp.clear();
				txtIp.requestFocus();
				return;				
			}
			// IP 확인 완료
			
			String textPort = txtPort.getText().trim();
			if(textPort.equals("")) {
				txtDisplay.appendText("포트번호를 입력해주세요");
				txtPort.requestFocus();
				return;
			}
			for(char c : textPort.toCharArray()) {
				if(c < 48 || c > 57) {
					txtDisplay.appendText("잘못된 포트번호입니다.");
					txtPort.requestFocus();
					return;
				}
				this.port = Integer.parseInt(textPort);
				if(port < 1024 || 65535 < port) {
					txtDisplay.appendText("잘못된 포트번호입니다.");
					txtPort.clear();
					txtPort.requestFocus();
					return;
				}
			}
			// port number 확인
			
			String nick = txtNick.getText().trim();
			if(nick.equals("")) {
				txtDisplay.appendText("닉네임을 작성해주세요.");
				txtNick.requestFocus();
				return;
			}
			this.nickName = nick;
			// nickname 확인
			
			try {
				server = new Socket(ip, this.port);
				txtDisplay.appendText("[연결 완료 : "+server.getRemoteSocketAddress());
				
				priter = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(server.getOutputStream())),
					true
				);
				
				bfr = new BufferedReader(new InputStreamReader(server.getInputStream()));
				
				send(0, nickName);
			}catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
		}); // end btnConn
	}

	public void send(int i, String nick) {
		priter.println(i+"|"+nick);
		txtInput.clear();
		txtInput.requestFocus();
	} // end send
	
}
