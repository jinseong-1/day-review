package application;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class practiceAController implements Initializable{
	
	@FXML private TableView<AppMain> vTable;
	@FXML private Button btnAdd, styGrap;
	
	public static ObservableList<AppMain> list;
	
	public static AppMain student;
	
	@Override
	public void initialize(URL location, ResourceBundle bundle) {
		list = FXCollections.observableArrayList(
			new	AppMain("홍길동A", 40, 60, 80),
			new	AppMain("홍길동B", 90, 20, 40),
			new	AppMain("홍길동C", 10, 80, 50)
		);
		Class<AppMain> clasz = AppMain.class;
		// import java.lang.reflect.Field
		Field[] fields = clasz.getDeclaredFields();
		for(Field f : fields) {
			String name = f.getName();
			TableColumn<AppMain,String> tc = new TableColumn<>(name);	// 테이블에 들어갈 컬럼 생성
			tc.setCellValueFactory(new PropertyValueFactory<>(name));
			tc.setPrefWidth(100);
			tc.setResizable(false); 	// 크기 바꾸기 X
			tc.setStyle("-fx-alignment:center;-fx-background-color:black;-fx-text-fill:yellow;");
			vTable.getColumns().add(tc);
		}
		vTable.setItems(list);
		// 여기까지 테이블에 데이터 추가
		
		// 테이블에서 데이터 가져오기
		vTable.getSelectionModel().selectedItemProperty().addListener((target, o, n)->{
			System.out.println(n);			// 테이블의 주소값들이 가지고와짐
		});
		
		// tableView 항목 더블클릭시 prieChart State open
		vTable.setOnMouseClicked(e->{
			int clickCount = e.getClickCount();
			System.out.println("click count : " + clickCount);
			
			// Mouse click 의 종류
			MouseButton btn = e.getButton();
			System.out.println(btn);
			
			// 클릭 2번
			if(btn == MouseButton.PRIMARY && clickCount == 2) {
				AppMain value= vTable.getSelectionModel().getSelectedItem();
				student = vTable.getSelectionModel().getSelectedItem();
				System.out.println(student);
				
				if(student == null) return;
				
				Stage stage = new Stage(StageStyle.UTILITY);
				Parent root = null;
				FXMLLoader loader= null;
				
				try {
					loader = new FXMLLoader(getClass().getResource("peigrap.fxml"));
					root = loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
					return;
				}
				stage.setScene(new Scene(root));
				stage.setTitle("파이그래프");
				stage.show();
				
			}
		});  // end mouse click event
		
		btnAdd.setOnAction(e->{
			Stage stage = new Stage(StageStyle.UTILITY);
			stage.setTitle("추가");
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Form.fxml"));
				Parent root = loader.load();
				stage.setScene(new Scene(root));
				
				stage.initModality(Modality.APPLICATION_MODAL);
				FormController controller = loader.getController();
				controller.init(list, stage);
				stage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}); // end btnAdd
		
		styGrap.setOnAction(e->{
			Stage stage = new Stage(StageStyle.UTILITY);
			try {
				Parent root = FXMLLoader.load(getClass().getResource("BarChart.fxml"));
				stage.setScene(new Scene(root));
				stage.setTitle("막대그래프");
				stage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		
	} // end initialize
 
	
	
}
