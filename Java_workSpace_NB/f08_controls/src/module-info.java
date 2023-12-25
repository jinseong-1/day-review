module f08_controls {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;
	requires javafx.graphics;
	
	opens c1_button_basic to javafx.graphics, javafx.fxml;
}
