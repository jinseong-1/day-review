package e02_bundle;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainCon extends Application {

	@Override
	public void start(Stage primaryStage) {
	// 언어 기본값 확인	
		System.out.println(Locale.getDefault());
	// 각 나라의 언어, 나라 조회
		for(Locale locale : Locale.getAvailableLocales()) {
	// 한글 언어 이름
			System.out.printf("Display Language : %s, ", locale.getDisplayLanguage());
	// 언어 코드		
			System.out.printf("Display Code : %s, ", locale.getLanguage());
	// 국가 이름		
			System.out.printf("Display Country : %s, ", locale.getDisplayCountry());
	// 국가코드, 국가/언어코드		
			System.out.printf("Country Code : %s, code %s %n", locale.getDisplayCountry(), locale.toString());
		}
		System.out.println("====================");
		Locale locale = Locale.getDefault();
		System.out.println(locale);
		Locale localeJP = new Locale("ja","JP");		// 앞엔 국가코드, 뒤엔 언어(?) - 일본
		System.out.println(localeJP);
		Locale localeCN = new Locale("zh","CN");		// 앞엔 국가코드, 뒤엔 언어(?) - 중국
		System.out.println(localeCN);
		
		
		ResourceBundle abundle = ResourceBundle.getBundle("prop.s", new Locale("zh","CN"));
		
		Locale.setDefault(localeCN);
		
		abundle = ResourceBundle.getBundle("prop.s");
		
		try {
			HBox call = FXMLLoader.load(getClass().getResource("Root.fxml"),abundle);
			primaryStage.setScene(new Scene(call));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
