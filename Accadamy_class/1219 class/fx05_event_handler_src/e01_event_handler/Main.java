package e01_event_handler;
	
import java.io.InputStream;
import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			HBox root = new HBox();
			root.setAlignment(Pos.BOTTOM_CENTER);
			root.setSpacing(10.0);
			root.setPadding(new Insets(15.0));
			
		// 버튼1은 따로 클래스로 정의해서 쓰는 방법
			
			Button btn1 = new Button("버튼1");		// 생성자의 매개변수로 text 지정
			btn1.setId("btn1"); 					// 노드에 접근하기 위한 구별 값 ID 지정
			btn1.setPrefSize(200, 100);				// width, height size(width,height) 사이즈를 한번에 지정해줄 수 있음
			
			ButtonActionEventHandler handler = new ButtonActionEventHandler();
			btn1.setOnAction(handler);
			
		// 버튼 2는 직접 정의해서 따로 클래스를 만들 필요가 없음	
			
			Button btn2 = new Button("버튼2");
			EventHandler<ActionEvent> handler2 = new EventHandler<>() {
				@Override
				public void handle(ActionEvent arg0) {
					System.out.println("버튼 2 click !@!@!@!@");
					primaryStage.close();
				}
				
			};
			btn2.setOnAction(handler2);
			
		// 버튼 3은 바로 지정해서 하는 것과 람다표현식
			Button btn3 = new Button("버튼3");
			btn3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					System.out.println("버튼3 클릭");
				}
				
			});
			
			btn3.setOnAction((e)->{
				System.out.println("버튼3 click lambda");
				Platform.exit();
			});
			
			// root container 에 btn1 자식 요소 추가
		/*	
			root.getChildren().add(btn1);
			root.getChildren().add(btn2);
			root.getChildren().add(btn3);
		*/
			ObservableList<Node> childs = root.getChildren();
			childs.addAll(btn1,btn2,btn3);
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					event.consume();
					System.out.println("기존 이벤트가 처리되기 전에 소비하여 삭제");
				}
			});
						
			// window 창 - icon 추가
			// 1. 입력 스트림 - 상대경로로 찾아가는 것
			ObservableList<Image> icons = primaryStage.getIcons();
			InputStream is = getClass().getResourceAsStream("puppy.png");
			Image image = new Image(is);
			icons.add(image);
			
			// 2. url
			// javafx 에서 경로는 src package에서 찾아가는 것
			URL url = getClass().getResource("/e01_event_handler/AreaChart.png");
			// src부터 찾아 들어가서 문제가 발생
			System.out.println(url.getPath());
			// 컴퓨터 최상위 폴더부터 들어가기에 이 방법을 사용해야 함
			System.out.println(url.toString());
			
			icons.add(new Image(url.toString()));
			
			primaryStage.setWidth(500);
			primaryStage.setHeight(300);
			primaryStage.setX(0);
			primaryStage.setY(0);
			primaryStage.show();
			primaryStage.setTitle("Event Handler Test");	// 창 제목
			primaryStage.setAlwaysOnTop(true);				// 포커스를 다른데둬도 제일 위에 떠있음
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
