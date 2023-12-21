package e01_controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AloneController implements Initializable{
	
// fxml 파일의 ID값 지정하기
	@FXML private Button btn1;
	@FXML private Button btn2;
	@FXML private Button btn3;
	
// event 지정하기
// 1. class에 implements Initalizable 을 먼저 정의해주기
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Initializable 호출");
		System.out.println(btn1);
		System.out.println("FXML 위치 정보 : " + location);
		System.out.println(resources);
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("버튼 1 클릭");
				Button btn1 = (Button)event.getTarget();
				System.out.println(btn1.getId());
				System.out.println(btn1.getStyleClass());
			}
		});
			btn2.setOnAction(event ->{
				System.out.println("버튼 2 클릭");
				Button btn2 = (Button)event.getTarget();
			});
		
		
		System.out.println("Initalizable 종료");
		} // Initalizable
	
	public void closeEvent() {
		System.out.println("closeEvent");
		Platform.exit();
	}
	
}
