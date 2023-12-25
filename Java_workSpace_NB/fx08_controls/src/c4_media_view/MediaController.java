package c4_media_view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class MediaController implements Initializable {

	@FXML private Label lblTime;
	@FXML private Button btnPlay, btnPause, btnStop;
	@FXML private ProgressBar progressBar;
	@FXML private ProgressIndicator indicator;
	@FXML private Slider sliderVolume, sliderPlay;
	// requires javafx.media; module-info에 있어야함
	// Media 를 재생할 공간
	@FXML private MediaView mediaView;
	
	// 재생해야할 Media Resource 정보를 저장하는 객체
	private Media media;
	// MediaView를 통해 재생되는 Resource 를 제어하는 객체
	private MediaPlayer mediaPlayer;
	// Media 재생이 파일의 끝까지 완료 했는지 여부를 저장할 flag
	private boolean endOfMedia;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// player 에 볼륨 조절은 0 ~ 1.0 의 값으로 표현
		sliderVolume.setValue(0.5);
		progressBar.setProgress(0.5);
		indicator.setProgress(0.5);
		media = new Media(
			getClass().getResource("/media/video.m4v").toString()
		);
		init();
	}

	// 재생할 Media가 변경될 경우 호출해서 재생에 필요한 요소를 초기화
	public void init() {
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);		// 재생할 위치 선택
		
		setProgress(0,"0/0 sec");
		setMediaPlayer();
		
		// 재생버튼 action event
		btnPlay.setOnAction((e)->{
			if(endOfMedia) {
				mediaPlayer.stop();
			}
			endOfMedia = false;
			
			// 미디어 재생
			mediaPlayer.play();
			
			mediaPlayer.currentTimeProperty().addListener((target,old,newValue)->{
				System.out.println(newValue);
				// 현재 재생중인 패일의 전체 재생시간을 초단위로 반환
		/*
			JavaFX의 Duration 객체는 시간 간격을 나타내는 클래스
			특정 시간 단위를 기반으로한 지속 시간(duration)을 나타내는데 사용
			시간에 관련된 작업을 수행 할 때 유용
		*/
				double totalTime = mediaPlayer.getTotalDuration().toSeconds();
				
				// 현재 재생 위치 시간을 초단위로 반환
				double currentTime = mediaPlayer.getCurrentTime().toSeconds();
				double progress = currentTime / totalTime;
				String lblText = (int)currentTime+"/"+(int)totalTime+"sec";
				setProgress(progress,lblText);
			});
		});
		
		btnPause.setOnAction((e)->{
			// 일시정지
			mediaPlayer.pause();
		});
		
		btnStop.setOnAction((e)->{
			// 재생 중지
			mediaPlayer.stop();
		});
		
		sliderVolume.valueProperty().addListener((target,old,newValue)->{
			System.out.println("volume : " + newValue);
			double volume = newValue.doubleValue();
			// media volume 조절 : 0 ~ 1.0
			mediaPlayer.setVolume(volume);
		});
		
		// slider play 를 이용하여 미디어 재생 위치 제어
		sliderPlay.valueProperty().addListener((t,o,n)->{
			// 전체 재생 시간
			Duration totalDuration = mediaPlayer.getTotalDuration();
			// sliderPlay 에 지정된 현재 수치
			// 0 ~ 1.0
			double value = sliderPlay.getValue();
			// 전체 재생 시간을 1/1000 단위의 millis 로 반환
			double totalValue = totalDuration.toMillis();
			// 재생 위치를 slider 의 현재 조작 값으로 계산
			double now = totalValue * value;
			// 계산된 재생 시간 위치 정보로 Duration 객체 생성
			Duration duration = new Duration(now);
			// 미디어 플레이어에 재생 시간 위치를 전달받은 duration 객체에 시간으로 변경
			mediaPlayer.seek(duration);
			mediaPlayer.play();
		});
		
	}  // end init
	
	public void setProgress(double p, String lblText) {
		progressBar.setProgress(p);
		indicator.setProgress(p);
		lblTime.setText(lblText);
	}
	
	// media player 에서 재생되는 media 상태별 처리
	public void setMediaPlayer() {
		// 재생 준비가 완료된 상태 시 호출 될 기능		
		mediaPlayer.setOnReady(new Runnable() {
	// 독립적인 Thread 가 되어 작업을 수행해야하므로 지정
			@Override
			public void run() {
				btnPlay.setDisable(false);	// 버튼 활성화
				btnPause.setDisable(true);	// 버튼 비활성화
				btnStop.setDisable(true);	// 버튼 비활성화			
			}			
		}); // on play
		
		// play 상태
		mediaPlayer.setOnPlaying(()->{
			btnPlay.setDisable(true);	// 버튼 비활성화
			btnPause.setDisable(false);	// 버튼 활성화
			btnStop.setDisable(false);	// 버튼 활성화
		});
		
		// 일시 정지
		mediaPlayer.setOnPaused(()->{
			btnPlay.setDisable(false);	// 버튼 활성화
			btnPause.setDisable(true);	// 버튼 비활성화
			btnStop.setDisable(false);	// 버튼 활활성화
		});
		
		// 모든 미디어 재생이 완료된 상태
		mediaPlayer.setOnEndOfMedia(()->{
			endOfMedia = true;
			btnPlay.setDisable(false);	// 버튼 활성화
			btnPause.setDisable(true);	// 버튼 비활성화
			btnStop.setDisable(true);	// 버튼 비활성화
		});
		
		// 미디어가 끝났을때
		mediaPlayer.setOnStopped(()->{
			// mediaPlayer에 등록된 미디어의 재생 시작 시간을 반환
			Duration duration = mediaPlayer.getStartTime();
			System.out.println(duration);
			// media 재생 시간을 설정하는 method
			mediaPlayer.seek(duration);
			btnPlay.setDisable(false);	// 버튼 활성화
			btnPause.setDisable(true);	// 버튼 비활성화
			btnStop.setDisable(true);	// 버튼 비활성화
		});
	}
	
	// 재생할 Media 를 선택할 method
	public void changeResource(ActionEvent e){
		Button btn = (Button)e.getTarget();
		String text = btn.getText();
		System.out.println(text);
		String path = "";
		switch(text) {
			case "midea1" :
				path = "/media/video.m4v";
				break;
			case "midea2" :
				path = "/media/video.mp4";
				break;
			case "music1" :
				path = "/media/audio.mp3";
				break;
			case "music2" :
				path = "/media/audio.wav";
				break;
		}
		URL url = getClass().getResource(path);
		media = new Media(url.toString());
		init();
	}
}
