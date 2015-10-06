package gjMediaPlayer.Client;

import javafx.util.Duration;

public class Util {
	
    public static String formatDuration(Duration time){
		int minutes = (int)time.toMinutes();
		int seconds = (int)time.toSeconds() - (minutes * 60);
		
		String formattedTime = String.format("%d:%d", minutes, seconds);
		
		if(seconds < 10)
			formattedTime = String.format("%d:0%d", minutes, seconds);
		return formattedTime;
    }
	
}
