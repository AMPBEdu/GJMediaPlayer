package GJMediaPlayer.Client.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import GJMediaPlayer.Client.Config;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GJMainController implements Initializable {
	
	//FXML Objects
	@FXML	
	private ToggleButton volumeButton;
	@FXML
	private Slider volumeSlider;
	@FXML
	private ToggleButton playButton;
	
	//Class Variables
	private Config config = new Config();
	private final Image volumeMute = new Image("GJMediaPlayer/Client/res/img/btn_volume_mute.png");
	private final Image volumeLow = new Image("GJMediaPlayer/Client/res/img/btn_volume_low.png");
	private final Image volumeMed = new Image("GJMediaPlayer/Client/res/img/btn_volume_med.png");
	private final Image volumeMax = new Image("GJMediaPlayer/Client/res/img/btn_volume_max.png");
	private final ImageView volumeImage = new ImageView();
	
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert volumeButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        
        initUI();
        
        //playButton.setOnAction(e -> volumeButton.setStyle("-fx-graphic: url(\"../res/img/btn_pause.png\")"));
        
        volumeButton.setOnAction(e -> volumeSlider.setVisible(!volumeSlider.isVisible()));
        volumeSlider.setOnMouseReleased(e -> {
        	config.setVolume(volumeSlider.getValue());
        	setVolumeImage(volumeSlider.getValue());
        });
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
        	System.out.println(observable);
            //setVolumeImage((double)newValue);
        });
    }
    
    public void initUI(){ 
    	volumeSlider.setVisible(false);
    	volumeSlider.setValue(Config.getVolume());
    	
    	setVolumeImage(Config.getVolume());
    }
    
    public void setVolumeImage(double newValue){
    	volumeImage.setImage(getVolumeImage(newValue));
    	volumeButton.setGraphic(volumeImage);
    }
	
    public Image getVolumeImage(double newValue){
    	
    	if(newValue == 0){
    		return volumeMute;
    	}else if(newValue >= 0 && Config.getVolume() < 25){
    		return volumeLow;
    	}else if (newValue >=25 && Config.getVolume() < 75){
    		return volumeMed;
    	}else if (newValue >= 75){
    		return volumeMax;
    	}else {
    		System.out.println("Image returned null");
    		return null;
    	}
    	
    }
    
}
