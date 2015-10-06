package gjMediaPlayer.Client.Media;

//Handles playing of songs, and makes sure multiple songs aren't playing at once.
public class PlayerHandler {
	
	//TODO: Make a play queue system
	
	private static Artist currentArtist = null;
	private static PlayList currentPlayList = null;
	private static Song currentSong = new Song("");
	
	
	public void play(Artist artist){
		currentSong.getPlayer().stop();
	}
	
	public void play(PlayList playlist){
		currentSong.getPlayer().stop();
	 }
	
	public void play(Song song){
		if(currentSong !=null)
			currentSong.getPlayer().stop();
		currentSong = song;
		currentSong.getPlayer().play();
	}
	
	public void playNext(){
		
	}
	
	public void playPrevious(){
		
	}

	public static Artist getCurrentArtist() {
		return currentArtist;
	}

	public static void setCurrentArtist(Artist currentArtist) {
		PlayerHandler.currentArtist = currentArtist;
	}

	public static PlayList getCurrentPlayList() {
		return currentPlayList;
	}

	public static void setCurrentPlayList(PlayList currentPlayList) {
		PlayerHandler.currentPlayList = currentPlayList;
	}

	public static Song getCurrentSong() {
		return currentSong;
	}

	public static void setCurrentSong(Song currentSong) {
		PlayerHandler.currentSong = currentSong;
	}
}
