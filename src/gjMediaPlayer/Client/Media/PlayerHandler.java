package gjMediaPlayer.Client.Media;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

//Handles playing of songs, and makes sure multiple songs aren't playing at once.
public class PlayerHandler {
	
	//TODO: Make a play queue system
	
	private static Artist currentArtist = null;
	private static PlayList currentPlayList = null;
	private static MediaPlayer currentMediaPlayer = null;
	private static Media currentMedia = null;
	
	
	public void play(Artist artist){
		currentMediaPlayer.stop();
	}
	
	public void play(PlayList playlist){
		currentMediaPlayer.stop();
	 }
	//possibly will be removed
	public void play(MediaPlayer mediaplayer){
		if(currentMediaPlayer != null)
			currentMediaPlayer.stop();
		currentMediaPlayer = mediaplayer;
		currentMediaPlayer.play();
	}
	
	public void play(Media dir){
		MediaPlayer mediaplayer = new MediaPlayer(dir);
		if(currentMediaPlayer != null)
			currentMediaPlayer.stop();
		currentMediaPlayer = mediaplayer;
		currentMediaPlayer.play();
	}
	
	public void playNext(){
		
	}
	
	public void playPrevious(){
		
	}
	
	//Getters
	public static MediaPlayer getCurrentMediaPlayer(){
		return currentMediaPlayer;
	}
	
	public static PlayList getCurrentPlayList(){
		return currentPlayList;
	}
	
	public static Artist getCurrentArtist(){
		return currentArtist;
	}
	
	public static Media getCurrentMedia() {
		return currentMedia;
	}

	//Setters
	public static void setCurrentPlayList(PlayList currentPlayList) {
		PlayerHandler.currentPlayList = currentPlayList;
	}

	public static void setCurrentMediaPlayer(MediaPlayer mediaplayer) {
		PlayerHandler.currentMediaPlayer = mediaplayer;
	}
	
	public static void setCurrentMediaPlayer(Media media){
		MediaPlayer mediaplayer = new MediaPlayer(media);
		PlayerHandler.currentMediaPlayer = mediaplayer;
	}
	
	public static void setCurrentMedia(Media currentMedia) {
		PlayerHandler.currentMedia = currentMedia;
	}

}
