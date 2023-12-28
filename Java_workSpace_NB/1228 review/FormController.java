package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormController implements Initializable {

	@FXML private TextField txtName, txtKor, txtEng, txtMath;
	@FXML private Button btnSave, btnCancel;
	
	// vTable 의 리스트 정보, 현재 control 이 등록된 Form stage 정보
	public void init(ObservableList<AppMain> list, Stage formStage) {
		// 취소버튼
		btnCancel.setOnAction(e->{
			formStage.close();
		});
		
		// 저장버튼
		btnSave.setOnAction(e->{
			String name = txtName.getText().trim();
			String strKor = txtKor.getText().trim();
			String strMath = txtMath.getText().trim();
			String strEng = txtEng.getText().trim();
			
			boolean isChecked = checkInteger(strKor, strMath, strEng);
			if(isChecked) {
				int hangle = Integer.parseInt(strKor);
				int math = Integer.parseInt(strMath);
				int english = Integer.parseInt(strEng);
				AppMain vo = new AppMain(name, hangle, math, english);
				list.add(vo);
			}
			
			txtName.clear();
			txtKor.clear();
			txtMath.clear();
			txtEng.clear();
			txtName.requestFocus();
			
		});
		
	} // end init
	
	public boolean checkInteger(String... scores) {
		for(String str : scores) {
			System.out.println(str);
			for(char c : str.toCharArray()) {
				System.out.println(c);
				if(c < 48 || c > 57) {
					return false;
				}
			}
		}
		return true;
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
