package gjMediaPlayer.Client.Media;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Song {
	
	private String title;
	private Artist artist;
	private Album album;
	private int track;
	private int year;
	private Duration songTime;
	private Media media;
	private MediaPlayer player;
	
	public Song(String dir){
		media = new Media(dir);
		player = new MediaPlayer(media);
		title = media.getMetadata().get("title").toString();
		album = new Album(media.getMetadata().get("album").toString());
		artist = new Artist(media.getMetadata().get("artist").toString());
		
	}
	
	public Song(Media media){
		this.media = media;
		player = new MediaPlayer(this.media);
		if(this.media.getMetadata().containsKey(title))
			title = this.media.getMetadata().get("title").toString();
		//album = new Album(this.media.getMetadata().get("album").toString());
		//artist = new Artist(this.media.getMetadata().get("artist").toString());
	}
	
	public Song(MediaPlayer mediaplayer){
		
	}
	
	//Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Duration getSongTime() {
		return songTime;
	}

	public void setSongTime(Duration songTime) {
		this.songTime = songTime;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media songMedia) {
		this.media = songMedia;
	}

	public MediaPlayer getPlayer() {
		return player;
	}

	public void setPlayer(MediaPlayer songPlayer) {
		this.player = songPlayer;
	}
}
