package c3_view_controls;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewController implements Initializable{

	@FXML private ListView<String> listView;
	@FXML private TableView<PhoneVO> tableView;
	// Table에 들어갈 속성이 2개이기에 따로 class를 생성하여 만든 것
	@FXML private ImageView imageView;
	@FXML private TextField txtName;
	@FXML private Button btnUpdate;
	
	
	@Override
	public void initialize(URL location, ResourceBundle bundle) {
		String[] strs = new String[] {
				"갤럭시S1","갤럭시S2","갤럭시S3","갤럭시S4","갤럭시S5","갤럭시S6","갤럭시S7"	
		};
		List<String> strList = Arrays.asList(strs);
		ObservableList<String> list = FXCollections.observableArrayList(
			//"갤럭시S1","갤럭시S2","갤럭시S3","갤럭시S4","갤럭시S5","갤럭시S6","갤럭시S7"
			// strs
			strList
		);
		System.out.println(list);
		listView.setItems(list);		// list view 에 출력할 항목 추가
		
		// tableView - 목록을 저장할 List 생성
		ObservableList<PhoneVO> phoneList = FXCollections.observableArrayList();
		for(int i =1;i<8;i++) {
			PhoneVO phone = new PhoneVO("갤럭시S"+i,"phone0"+i+".png");
			phoneList.add(phone);
		// tableView.setItems(phoneList);		-> 이렇게만하면 테이블에 출력이 안되니 추가로 작업해야함
		}
		
		ObservableList<TableColumn<PhoneVO, ?>> columnList = tableView.getColumns();
		System.out.println(columnList);

		
/*		
		TableColumn<PhoneVO,?> columnName = columnList.get(0);
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<PhoneVO,?> columnPath = columnList.get(1);
		columnPath.setCellValueFactory(new PropertyValueFactory<>("path"));
*/	
	// 위와 같이 작업을 해도되지만 결국 반복 작업이기에 반복문 처리해주는 것	
		Field[] fields = PhoneVO.class.getDeclaredFields();
		for(int i = 0; i<fields.length;i++) {
			String name = fields[i].getName();
			System.out.println("field name : " + name);
			TableColumn<PhoneVO,?> columnName = columnList.get(i);
			columnName.setCellValueFactory(new PropertyValueFactory<>(name));
		}
	// 여기까지 작성하고 module-info에서 export 시켜야 읽어올수있음
	// 보안상의 이유로 다시 지정해준다고 생각하면 편함
		tableView.setItems(phoneList);
		
		// tableView 에 선택 항목 변경 감지
		// javaFX에는 다양한 데이터를 관리하기 위해 모델 개념을 도입
		// 모델은 동적으로 조작되는 데이터를 관리하기 위한 것
		tableView.getSelectionModel().selectedItemProperty()
		.addListener(new ChangeListener<PhoneVO>() {

			@Override
			public void changed(
					ObservableValue<? extends PhoneVO> target,
					PhoneVO oldValue,
					PhoneVO newValue) {
				System.out.println(oldValue);
				System.out.println(newValue);
				if(newValue != null) {
					String path = "/images/"+newValue.getPath();
					URL url = getClass().getResource(path);
					imageView.setImage(new Image(url.toString()));
					
					// 텍스트 정보 수정을 위해서 TextField의 값을 선택된 핸드폰의 이름 정보로 변경
					txtName.setText(newValue.getName());
				}
			}
		}); // end selectedItemProperty changed
		
		tableView.getSelectionModel().selectedIndexProperty()
		.addListener((target,oldValue,newValue)->{
			int index = newValue.intValue();
			System.out.println("선택된 항목의 인덱스 번호 : " + index);
			PhoneVO phone = phoneList.get(index);
			System.out.println(phone);
			// tableView 항목 선택시 동일한 이름의 listView 항목도 선택
			listView.getSelectionModel().select(index);
			// 해당 인덱스로 스크롤 이동
			listView.scrollTo(index);
		});	// end tableView index property listener
		
		// 리스트 뷰 변경 감지 -> tableView 항목 선택
		listView.getSelectionModel().selectedIndexProperty()
		.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(
					ObservableValue<? extends Number> target,
					Number old,
					Number newValue) {
				System.out.println(newValue);
				int index = newValue.intValue();
				tableView.getSelectionModel().select(index);
				tableView.scrollTo(index);
			}
		});	// end listView index listener
	
		// 이름 수정 버튼 이벤트
		btnUpdate.setOnAction((e)->{
			String updateName = txtName.getText();
			// method 가 호출되는 시점에 선택된 항목의 인덱스 번호를 반환
			int index = tableView.getSelectionModel().getSelectedIndex();
			list.set(index, updateName);
			// 새로고침
			listView.refresh();
			
			// method 가 호출되는 시점에 선택된 항목(item) 반환			
			PhoneVO phone = tableView.getSelectionModel().getSelectedItem();
			phone.setName(updateName);
			tableView.refresh();
		});
	
	} // end initialize
}
