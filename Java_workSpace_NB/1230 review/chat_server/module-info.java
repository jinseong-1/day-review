module f_chat_server {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens chatting_server to javafx.graphics, javafx.fxml;
}
