package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ApplicationController implements Initializable{
	
	@FXML private ImageView img;
	@FXML private Slider slider;
	@FXML private ToggleButton toggle;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(slider.valueProperty());
		double value = slider.valueProperty().doubleValue();
		System.out.println(value);		// 현재 slider 의 위치 확인용
		setImageWidth(value);
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			// 슬라이드 위치에 따라 출력되는 위치값
			@Override
			public void changed(ObservableValue<? extends Number> observalue, 
					Number oldNumber, 
					Number newValue) {
				System.out.println(observalue);
				System.out.println(oldNumber);
				System.out.println(newValue);
			}
		});
		
		slider.valueProperty().addListener((target,oldNumber,newValue)->{
			byte b = newValue.byteValue();
			System.out.println(b);
			int i = newValue.intValue();
			System.out.println(i);
			double d = newValue.doubleValue();
			System.out.println(d);		// 바뀌는 슬라이드에 따라 출력되는 타입 변경
		});
		
		toggle.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> target, 
					Boolean oldNumber, 
					Boolean newNumber) {
				System.out.println(newNumber);		// 버튼 클릭시 true, false
				
				String path = "images/image1.jpg";
				if(newNumber) {
					path = "images/image2.jpg";
				}
				File file = new File(path);
				System.out.println(file.getAbsolutePath());
				URL url = getClass().getResource(path);
				System.out.println(url);
				
				Image image = new Image("file :/"+file.getAbsolutePath());
				img.setImage(image);
			}
			
		});
		
	} // end initialize
	
	public void setImageWidth(double value) {
		double width = ((double)350/100) * value;
		width = (width == 0) ? 1 : width;
		img.setFitWidth(width);
		System.out.println("image size : " + img.getFitWidth());
	}
	
}
