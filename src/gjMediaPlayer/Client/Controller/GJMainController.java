package gjMediaPlayer.Client.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import gjMediaPlayer.Client.Config;
import gjMediaPlayer.Client.Media.PlayerHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.util.Duration;

public class GJMainController implements Initializable {
	
//FXML Objects
	//Buttons
	@FXML private ToggleButton playButton;
	@FXML private ToggleButton volumeButton;
	@FXML private Button mp3Loader;
	@FXML private Button skipButton;
	@FXML private Button previousButton;
	//Other
	@FXML private Slider volumeSlider;
	@FXML private Slider progressSlider;
	@FXML private Label leftTime;
	@FXML private Label rightTime;
	
	private boolean play = false;
	
	//Class Variables
	private Config config = new Config();
	private final Media testMedia = new Media("file:///Users/Andrew/Documents/Music/Zedd/Clarity/Clarity.mp3");
	private final Media testMedia2 = new Media("file:///Users/Andrew/Documents/Music/test/betMyLife.mp3");
	private final Image volumeMute = new Image("GJMediaPlayer/Client/res/img/btn_volume_mute.png");
	private final Image volumeLow = new Image("GJMediaPlayer/Client/res/img/btn_volume_low.png");
	private final Image volumeMed = new Image("GJMediaPlayer/Client/res/img/btn_volume_med.png");
	private final Image volumeMax = new Image("GJMediaPlayer/Client/res/img/btn_volume_max.png");
	private final ImageView volumeImage = new ImageView();
	private ChangeListener<Duration> durationListener;
	
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        
        initUI();
        
        PlayerHandler playerhandler = new PlayerHandler();
        PlayerHandler.setCurrentMediaPlayer(testMedia);
        
		durationListener = new ChangeListener<Duration>() {
			@Override
			public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue,
					Duration newValue) {
				Duration currentTime = PlayerHandler.getCurrentMediaPlayer().getCurrentTime();
				Duration totalTime = PlayerHandler.getCurrentMediaPlayer().getMedia().getDuration();
				Duration timeLeft = totalTime.subtract(currentTime);
				
				leftTime.setText(formatTime(currentTime));
				rightTime.setText(formatTime(timeLeft));
				
				progressSlider.setValue(100.0 * PlayerHandler.getCurrentMediaPlayer().getCurrentTime().toMillis() / PlayerHandler.getCurrentMediaPlayer().getTotalDuration().toMillis());
			}
		};
		
		PlayerHandler.getCurrentMediaPlayer().currentTimeProperty().addListener(durationListener);
        mp3Loader.setOnAction(e -> {
        });
        
        
        //Button Actions
        playButton.setOnAction(e -> {
        	play = !play;
        	if (play)
        		PlayerHandler.getCurrentMediaPlayer().play();
        	else{
        		PlayerHandler.getCurrentMediaPlayer().pause();
        	}
        });
        
        skipButton.setOnAction(e -> {
        	playerhandler.playNext();
        });
        previousButton.setOnAction(e -> {
        	playerhandler.playPrevious();
        });
        volumeButton.setOnAction(e -> volumeSlider.setVisible(!volumeSlider.isVisible()));
        volumeSlider.setOnMouseReleased(e -> {
        	config.setVolume(volumeSlider.getValue());
        	PlayerHandler.getCurrentMediaPlayer().setVolume(Config.getVolume());
        	setVolumeImage(volumeSlider.getValue());
        });
    }
    
    private void initUI(){ 
    	volumeSlider.setVisible(false);
    	volumeSlider.setValue(Config.getVolume());
    	setVolumeImage(Config.getVolume());
    	
    }
    
    //Load metadata
    private void loadMedia(Media media){
    	rightTime.setText(formatTime(media.getDuration()));
    }
    
    private void setVolumeImage(double newValue){
    	volumeImage.setImage(getVolumeImage(newValue));
    	volumeButton.setGraphic(volumeImage);
    }
	
    private Image getVolumeImage(double newValue){
    	
    	if(newValue == 0){
    		return volumeMute;
    	}else if(newValue >= 0 && Config.getVolume() < 33){
    		return volumeLow;
    	}else if (newValue >=33 && Config.getVolume() < 67){
    		return volumeMed;
    	}else if (newValue >= 67){
    		return volumeMax;
    	}else {
    		System.out.println("Image returned null");
    		return null;
    	}
    	
    }
    
    private String formatTime(Duration time){
		int minutes = (int)time.toMinutes();
		int seconds = (int)time.toSeconds() - (minutes * 60);
		
		String formattedTime = String.format("%d:%d", minutes, seconds);
		
		if(seconds < 10)
			formattedTime = String.format("%d:0%d", minutes, seconds);
		return formattedTime;
    }
}
