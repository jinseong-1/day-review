module f03_layout_basic {
	requires javafx.controls;
	requires javafx.base;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens test_fxml to javafx.graphics, javafx.fxml;		// 이 줄도 추가시켜줘야함
}
