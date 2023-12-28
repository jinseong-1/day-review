package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PieChartCotroller implements Initializable {

	@FXML private PieChart pieChart;
	@FXML private Button btnClose;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(practiceAController.student);
		pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("국어", practiceAController.student.getHangle()),
				new PieChart.Data("수학", practiceAController.student.getMath()),
				new PieChart.Data("영어", practiceAController.student.getEnglish())
			));
		
		btnClose.setOnAction(e->{
			((Stage)pieChart.getScene().getWindow()).close();
		});
	}

}
