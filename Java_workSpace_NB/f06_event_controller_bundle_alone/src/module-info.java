module f06_event_controller_bundle_alone {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens e01_controller to javafx.graphics, javafx.fxml;
	opens e02_bundle to javafx.graphics, javafx.fxml;
}
