module fx05_event_handler {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens e01_event_handler to javafx.graphics, javafx.fxml;
	opens e02_event_fxml to javafx.graphics, javafx.fxml;
}
