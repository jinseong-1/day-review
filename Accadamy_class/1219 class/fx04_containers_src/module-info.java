module fx04_containers {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens c1_anchorpane to javafx.graphics, javafx.fxml;
	opens c2_hbox_vbox to javafx.graphics, javafx.fxml;
	opens c3_border_pane to javafx.graphics, javafx.fxml;
	opens c4_flow_pane to javafx.graphics, javafx.fxml;
	opens c7_stack_pane to javafx.graphics, javafx.fxml;
}
