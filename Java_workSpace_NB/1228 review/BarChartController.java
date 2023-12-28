package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BarChartController implements Initializable {

	// xAxis - 학생이름
	// yAxis - Number - 학생 이름별 국어 수학 영어점수
	@FXML private BarChart<String, Integer> barChart;
	@FXML private Button btnClose;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		XYChart.Series<String, Integer> seriesKor = new XYChart.Series<>();
		seriesKor.setName("국어");
		XYChart.Series<String, Integer> seriesMath = new XYChart.Series<>();
		seriesMath.setName("수학");
		XYChart.Series<String, Integer> seriesEng = new XYChart.Series<>();
		seriesEng.setName("영어");
		
		ObservableList<XYChart.Data<String,Integer>> listKor
			= FXCollections.observableArrayList();
		ObservableList<XYChart.Data<String,Integer>> listMath
		= FXCollections.observableArrayList();
		ObservableList<XYChart.Data<String,Integer>> listEng
		= FXCollections.observableArrayList();
		
		for(AppMain a : practiceAController.list) {
			listKor.add(new XYChart.Data<>(a.getName(), a.getHangle()));
			listMath.add(new XYChart.Data<>(a.getName(), a.getMath()));
			listEng.add(new XYChart.Data<>(a.getName(), a.getEnglish()));
		}
		
		seriesKor.setData(listKor);
		seriesMath.setData(listMath);
		seriesEng.setData(listEng);
		
		barChart.getData().addAll(seriesKor, seriesMath, seriesEng);
		
		btnClose.setOnAction(e->{
			((Stage)barChart.getScene().getWindow()).close();
		});
		
		
	}	// end initialize

}
