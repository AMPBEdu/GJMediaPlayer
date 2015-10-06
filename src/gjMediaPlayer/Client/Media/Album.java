package gjMediaPlayer.Client.Media;

public class Album {
	
	public static String name;
	
	public Album(String name){
		this.name = name;
	}
	
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Album.name = name;
	}
}
