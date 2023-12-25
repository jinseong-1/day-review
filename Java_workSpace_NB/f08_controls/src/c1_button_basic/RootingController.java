package c1_button_basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class RootingController implements Initializable{

	@FXML private BorderPane Rooting;
	@FXML private CheckBox chk1, chk2;
	@FXML private ToggleGroup group;
	@FXML private ImageView chkImg, radioImg;
	@FXML private Button btnExit;
	@FXML private Hyperlink hyperLink;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		chk1.setOnAction((e)->{
			handlerChkAction(e);
		});
		
		chk2.setOnAction((e)->{
			handlerChkAction(e);
		});
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> target,
					Toggle oldNumber,
					Toggle newNumber) {
				RadioButton value = (RadioButton)newNumber;
				String text = value.getText();
				System.out.println(text);
				text = "/images/"+text+".png";
				String path = getClass().getResource(text).toString();
				Image changed = new Image(path);
				radioImg.setImage(changed);
				
			}
			
			
		});	// end toggle

		btnExit.setOnAction((e)->{
			System.exit(0);
		});	// end btnExit
		
		hyperLink.setOnAction((e)->{
			String link = (String)hyperLink.getUserData();
			System.out.println(link);
			
			WebView webview = new WebView();
			WebEngine we = webview.getEngine();
			we.load(link);
			
			Stage stage = new Stage();
			BorderPane pane = new BorderPane();
			pane.setCenter(webview);
			stage.setScene(new Scene(pane));
			stage.setWidth(1074);
			stage.setHeight(700);
			stage.show();
			
		});	// end hyperLink
		
	} // end Initializable
	
	
	// click 시 image change 
	private void handlerChkAction(ActionEvent action) {
		boolean isCheck1 = chk1.isSelected();
		boolean isCheck2 = chk2.isSelected();
		
		// geek-glasses.gif		 안경
		// geek-hair.gif		 모자
		// geek-glasses-hair.gif 안경+모자
		// geek.gif				 둘다 없음
		
		String none = "";
		if(isCheck1 && isCheck2) {
			none = "/images/geek-glasses-hair.gif";
		}else if(isCheck1) {
			none = "/images/geek-glasses.gif";
		}else if(isCheck2) {
			none = "/images/geek-hair.gif";
		}else {
			none = "/images/geek.gif";
		}
		
		URL url = getClass().getResource(none);
		
		chkImg.setImage(new Image(url.toString()));
		
	}
	
}
